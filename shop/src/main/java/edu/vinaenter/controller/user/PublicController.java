package edu.vinaenter.controller.user;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.vinaenter.daos.GiftCodeDao;
import edu.vinaenter.daos.ProductDao;
import edu.vinaenter.dto.CategoryDto;
import edu.vinaenter.dto.OrderDto;
import edu.vinaenter.dto.ProductDto;
import edu.vinaenter.models.GiftCode;
import edu.vinaenter.models.Parent_Cat;
import edu.vinaenter.services.CategoryServices;
import edu.vinaenter.services.ProductService;


@Controller
public class PublicController {
	@Autowired
	private ProductService productservice;
	@Autowired
	private ProductDao productdao;
	@Autowired
	private GiftCodeDao giftcodedao;
	@Autowired
	private CategoryServices categoryservice;
	
	public List<OrderDto> cart = new ArrayList<OrderDto>();
	
	@ModelAttribute
	public void commonObject(Model model, HttpSession session) {
		List<CategoryDto> listcat = categoryservice.findAll();
		List<Parent_Cat> listparent = categoryservice.listParent();
		session.setAttribute("cart",cart);
		model.addAttribute("listcat", listcat);	
		model.addAttribute("listparent", listparent);	
		
	}
	
	@GetMapping(value = "/home")
	public String home(Model model) {	
		List<ProductDto> listNew = productdao.ListNew();
		List<ProductDto> listSale = productdao.ListSale();
		List<ProductDto> listSuggest = productdao.ListSuggest();
		model.addAttribute("listNew", listNew);
		model.addAttribute("listSale", listSale);
		model.addAttribute("listSuggest", listSuggest);
		
		return "shop.public.index";
	}
	@GetMapping(value = "/cat/{id}")
	public String cat(@PathVariable Integer id,Model model) {	
		List<ProductDto> listproduct = productservice.findByCatId(id);
		model.addAttribute("listproduct", listproduct);
		return "shop.public.cat";
	}
	@GetMapping(value = "/product/{id}")
	public String product(@PathVariable Integer id,Model model) {	
		ProductDto product = productservice.getItem(id);
		List<ProductDto> listSuggest = productdao.ListSuggest();
		model.addAttribute("product", product);
		model.addAttribute("listSuggest", listSuggest);
		return "shop.public.product";
	}
	
	@GetMapping(value = "/cart")
	public String cart(Model model) {	
		return "shop.public.cart";
	}
	
	@PostMapping(value = "/add/order")
	public String add(@RequestParam("id") int id,RedirectAttributes ra,Model model,HttpSession session) {
		
		ProductDto product = productservice.getItem(id);
	
		OrderDto  order = new OrderDto();
		order.setAmount(1);
		order.setPicture(product.getPicture());
		order.setPrice_import(product.getPrice_import());
		order.setPrice_new(product.getPrice_new());
		order.setProduct_name(product.getName());
		order.setSum(order.getPrice_new()*order.getAmount());
		int dem=0;
		List<OrderDto> cart = (List<OrderDto>)session.getAttribute("cart");
		for (OrderDto orderDto : cart) {
			if(orderDto.getProduct_name().equals(product.getName())) {
				orderDto.setAmount(orderDto.getAmount()+1);
			}else dem++;
		}
		if(dem==cart.size()) cart.add(order);
		session.setAttribute("cart",cart);
		return "shop.displayCart";
	}
	
	@GetMapping(value = "/del/order/{product_name}")
	public String delorder(@PathVariable("product_name") String name,RedirectAttributes ra,Model model,HttpSession session) {
		System.out.println(name);
		List<OrderDto> cart = (List<OrderDto>) session.getAttribute("cart");
		int dem=0;
		for (OrderDto orderDto : cart) {
			if(!orderDto.getProduct_name().equals(name)) dem++;else {
				cart.remove(dem);
				break;
			}
			
			
		}
		session.setAttribute("cart",cart);
	
		return "redirect:/cart";
	}
	
	@PostMapping(value = "/confirm/cart")
	public String confim(@RequestParam("amount") List<Integer> amount,@RequestParam("giftcode") String code,RedirectAttributes ra,Model model,HttpSession session) {
		List<OrderDto> cart = (List<OrderDto>) session.getAttribute("cart");
		int dem=0;
		int sum=0;
		int total=0;
		for (OrderDto orderDto : cart) {
			orderDto.setAmount(amount.get(dem));
			orderDto.setSum(orderDto.getPrice_new()*orderDto.getAmount());
			dem++;
			sum+=orderDto.getSum();
		}
		if(!"".equals(code)) {
			if(giftcodedao.countgift(code)>0) {
				GiftCode giftCode = giftcodedao.findByName(code);
				if(giftCode!=null) {
					if(giftCode.getAmount()>0) {
						total=sum-(sum*giftCode.getPercent()/100);
						model.addAttribute("msg","Mã Giảm Giá Đã Được Áp Dụng");
					}
				}else {
					total=sum;
					model.addAttribute("msg","Mã Giảm Giá Không CÓ Hiệu Lực");
				}
			}else {
				total=sum;
				model.addAttribute("msg","Mã Giảm Giá Không CÓ Hiệu Lực");
			}
		}else {
			total=sum;
			model.addAttribute("msg","Không Có Mã Giảm Giá");
		}
		session.setAttribute("cart",cart);
		model.addAttribute("sum",sum);
		model.addAttribute("total",total);
		return "shop.public.orderlist";
	}

}

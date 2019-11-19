package edu.vinaenter.controllers.admins;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.vinaenter.constants.CommonConstants;
import edu.vinaenter.constants.UrlConstants;
import edu.vinaenter.dto.BillDto;
import edu.vinaenter.dto.OrderDto;
import edu.vinaenter.dto.ProductDto;
import edu.vinaenter.models.User;
import edu.vinaenter.services.BillService;
import edu.vinaenter.services.OrderService;
import edu.vinaenter.utils.FileDefine;
import edu.vinaenter.utils.FileUtil;
import edu.vinaenter.utils.MessageDefine;

@Controller
@RequestMapping(UrlConstants.URL_ADMIN)
public class AdminBillController {
	@Autowired
	private BillService billService;
	@Autowired 
	private OrderService orderservice;
	
	@GetMapping({ "/bill/index", "/bill/index/{page}" })
	public String index(@PathVariable(required = false) Integer page, Model model) {
		if (page == null) {
			page = 1;
		}
		int offset = (page - 1) * CommonConstants.DEFAULT_PAGING_SIZE;
		int coutPagination = billService.countPagination();
		int totalPage = (int) Math.ceil((float) coutPagination / CommonConstants.DEFAULT_PAGING_SIZE);
		List<BillDto> listBill = billService.findAllPagination(offset);
		model.addAttribute("listBill", listBill);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("page", page);
		return "shop.admin.bill.index";
	}
	  @GetMapping(UrlConstants.URL_ADMIN_BILL_EDIT) 
	  public String edit(@PathVariable Integer id, Model model) { 
		  BillDto item =billService.getItem(id);
		  List<OrderDto> listOrder = orderservice.findByID(id);
		  model.addAttribute("listOrder", listOrder);
		  model.addAttribute("item", item); 
		  return "shop.admin.bill.edit"; 
	  }
	  @PostMapping(UrlConstants.URL_ADMIN_BILL_EDIT)
		public String edit(@Valid @ModelAttribute("bill") BillDto bill, BindingResult rs,
				@PathVariable int id, RedirectAttributes ra,Model model) {
		  System.out.println(bill);
			if (rs.hasErrors()) {
				model.addAttribute("bill",bill);
				return "shop.admin.bill.edit";
			}
			
				int addProduct = billService.edit(bill);
				if (addProduct > 0) {
					ra.addFlashAttribute("msg","Sửa Thành Công");
					return "redirect:/admin" + UrlConstants.URL_ADMIN_BILL_INDEX;
				}
				ra.addFlashAttribute("msg","Sửa Thất Bại");
				return "redirect:/admin" + UrlConstants.URL_ADMIN_BILL_INDEX;
		}
	  	
	  @GetMapping(UrlConstants.URL_ADMIN_BILL_DEL) 
	  public String del(@PathVariable Integer id, Model model,RedirectAttributes ra) { 
		  int del = billService.delete(id);
			if (del > 0) {
				ra.addFlashAttribute("msg","Xóa Thành Công");
				return "redirect:/admin" + UrlConstants.URL_ADMIN_BILL_INDEX;
			}
			ra.addFlashAttribute("msg","Xóa Thất Bại");
			return "redirect:/admin" + UrlConstants.URL_ADMIN_BILL_INDEX;
	  }
}

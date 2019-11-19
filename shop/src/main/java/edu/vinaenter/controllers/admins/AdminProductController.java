package edu.vinaenter.controllers.admins;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
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
import edu.vinaenter.dto.CategoryDto;
import edu.vinaenter.dto.ProductDto;
import edu.vinaenter.services.CategoryServices;
import edu.vinaenter.services.ProductService;
import edu.vinaenter.utils.FileDefine;
import edu.vinaenter.utils.FileUtil;
import edu.vinaenter.utils.MessageDefine;

@Controller
@RequestMapping(UrlConstants.URL_ADMIN)
public class AdminProductController {
	@Autowired
	ProductService productService;
	@Autowired
	private ServletContext servletContext;
	@Autowired
	private CategoryServices categoryService;
	
	@ModelAttribute
	public void commonObject(Model model) {
		List<CategoryDto> listparent = categoryService.findAll();
		
		model.addAttribute("listparent", listparent);	
	}
	
	@GetMapping({UrlConstants.URL_ADMIN_PRODUCT_INDEX,UrlConstants.URL_ADMIN_PRODUCT_INDEX_PAGE })
	public String index(@PathVariable(required = false) Integer page, Model model) {
		if (page == null) {
			page = 1;
		}
		int offset = (page - 1) * CommonConstants.DEFAULT_PAGING_SIZE;
		int coutPagination = productService.countPagination();
		int totalPage = (int) Math.ceil((float) coutPagination / CommonConstants.DEFAULT_PAGING_SIZE);
		List<ProductDto> listPrice = productService.findAllPagination(offset);
		model.addAttribute("listProduct", listPrice);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("page", page);
		return "shop.admin.product.index";
	}
	
	@GetMapping({UrlConstants.URL_ADMIN_PRODUCT_ADD})
	public String add(Model model) {
		return "shop.admin.product.add";
	}
	@PostMapping({UrlConstants.URL_ADMIN_PRODUCT_ADD})
	public String add(@Valid @ModelAttribute("product") ProductDto product, BindingResult rs,@RequestParam("file") MultipartFile mtf,
			RedirectAttributes ra,Model model) {
		System.out.println(product);
		if (rs.hasErrors()) {
			model.addAttribute("product", product);
			return "shop.admin.product.add";
		}
		/* if((productService.checkso(product.getPrice_new())==false)) */
		if(((product.getAmount()<0))||(product.getPrice_import()<0)||(product.getPrice_new()<0)) {
			model.addAttribute("msg","Nháº­p Sá»‘ NguyÃªn DÆ°Æ¡ng Cho CÃ¡c TrÆ°á»�ng GiÃ¡ vÃ  Sá»‘ LÆ°á»£ng");
			return "shop.admin.product.add";
		}
		product.setPrice_old(0);
		//=============upload file===============
		String filename = mtf.getOriginalFilename();
		String newFileName = FileUtil.rename(filename);
		String dirPath = servletContext.getRealPath("") + FileDefine.DIR_UPLOAD;
		File saveDir = new File(dirPath);
		if (saveDir.exists()) {
			saveDir.mkdir();
		}
		String filePath = dirPath + File.separator + newFileName;
																
		try {
			mtf.transferTo(new File(filePath));
			System.out.println(filePath);
			ra.addAttribute("msg","OK");
		} catch (IllegalStateException | IOException e) {
			ra.addAttribute("msg","Fail");
		}
		product.setPicture(newFileName); 
		
		
		
		
		if(product.getPicture()==null) product.setPicture("");
		int addProduct = productService.addPrice(product);
		if (addProduct > 0) {
			ra.addFlashAttribute("msg","Them Product Thanh Cong");
			return "redirect:/admin" + UrlConstants.URL_ADMIN_PRODUCT_INDEX;
		}
		ra.addFlashAttribute("msg","Them Product That Bai");
		return "redirect:/admin" + UrlConstants.URL_ADMIN_PRODUCT_ADD;
	}
	@GetMapping(UrlConstants.URL_ADMIN_PRODUCT_EDIT)
	public String edit(@PathVariable Integer id, Model model) {
		ProductDto proDto = productService.getItem(id);
//		land.setLandName(landservice.getname(id).getName());
		model.addAttribute("proDto", proDto);
		return "shop.admin.product.edit";
	}
	@PostMapping(UrlConstants.URL_ADMIN_PRODUCT_EDIT)
	public String edit(@Valid @ModelAttribute("product") ProductDto product, BindingResult rs,
			@RequestParam("file") MultipartFile mtf,@PathVariable int id, RedirectAttributes ra,Model model) {

		if (rs.hasErrors()) {
			product.setPicture(productService.getItem(id).getPicture());
			model.addAttribute("product",product);
			return "shop.admin.product.edit";
		}
		product.setId(id);
		String filename = mtf.getOriginalFilename();
		String newFileName = FileUtil.rename(filename);
		if (filename.isEmpty()) {
			product.setPicture(productService.getItem(id).getPicture());
			product.setPrice_old(productService.getItem(id).getPrice_new());
			int addProduct = productService.edit(product);
			if (addProduct > 0) {
				ra.addFlashAttribute("msg","Sá»­a ThÃ nh CÃ´ng");
				return "redirect:/admin" + UrlConstants.URL_ADMIN_PRODUCT_INDEX;
			}
			ra.addFlashAttribute("msg","Sá»­a Tháº¥t Báº¡i");
			return "redirect:/admin" + UrlConstants.URL_ADMIN_PRODUCT_INDEX;
		} else {
			String dirPath = servletContext.getRealPath("") + FileDefine.DIR_UPLOAD;
			File saveDir = new File(dirPath);
			if (saveDir.exists()) {
				saveDir.mkdir();
			}
			String filePath = dirPath + File.separator + newFileName;

			String nameoldfile = dirPath + File.separator + productService.getItem(id).getPicture();
			File oldFile = new File(nameoldfile);
			oldFile.delete();

			try {
				mtf.transferTo(new File(filePath));
				System.out.println(filePath);
				ra.addAttribute("msg", MessageDefine.MSG_SUCCESS);
			} catch (IllegalStateException | IOException e) {
				ra.addAttribute("msg", MessageDefine.MSG_ERR);
			}
			product.setPicture(newFileName);
			int addProduct = productService.edit(product);
			if (addProduct > 0) {
				ra.addFlashAttribute("msg","Sá»­a ThÃ nh CÃ´ng");
				return "redirect:/admin" + UrlConstants.URL_ADMIN_PRODUCT_INDEX;
			}
			ra.addFlashAttribute("msg","Sá»­a Tháº¥t Báº¡i");
			return "redirect:/admin" + UrlConstants.URL_ADMIN_PRODUCT_INDEX;
		}

	
	}
	
	
	@GetMapping(UrlConstants.URL_ADMIN_PRODUCT_DEL)
	public String del(@PathVariable Integer id, RedirectAttributes ra) {
		String dirPath = servletContext.getRealPath("") + FileDefine.DIR_UPLOAD;
		String nameoldfile = dirPath + File.separator + productService.getItem(id).getPicture();
		File oldFile = new File(nameoldfile);
		int delcat = productService.delete(id);
		if (delcat > 0) {
			oldFile.delete();	
			ra.addFlashAttribute("msg","Delete ThÃ nh CÃ´ng");
			return "redirect:/admin" + UrlConstants.URL_ADMIN_PRODUCT_INDEX;
		}
		ra.addFlashAttribute("msg","Delete Tháº¥t Báº¡i");
		return "redirect:/admin" + UrlConstants.URL_ADMIN_PRODUCT_INDEX;
	}

}

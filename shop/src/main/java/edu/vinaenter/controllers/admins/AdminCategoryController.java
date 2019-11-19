package edu.vinaenter.controllers.admins;

import java.io.File; 
import java.util.List;

import javax.servlet.ServletContext;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.vinaenter.constants.UrlConstants;
import edu.vinaenter.dto.CategoryDto;
import edu.vinaenter.dto.ProductDto;
import edu.vinaenter.models.Parent_Cat;
import edu.vinaenter.services.CategoryServices;
import edu.vinaenter.services.ProductService;
import edu.vinaenter.utils.FileDefine;

@Controller
@RequestMapping(UrlConstants.URL_ADMIN)
public class AdminCategoryController {
	
	@Autowired
	private CategoryServices categoryService;
	@Autowired
	private ProductService productService;
	
	@Autowired
	private ServletContext servletContext;

	@Autowired
	private MessageSource messageSource;
	
	@ModelAttribute
	public void commonObject(Model model) {
		List<Parent_Cat> listparent = categoryService.listParent();
		
		model.addAttribute("listparent", listparent);	
	}

	@GetMapping(UrlConstants.URL_ADMIN_CAT_INDEX)
	public String index(Model model) {
		List<CategoryDto> liCat = categoryService.findAll();
		model.addAttribute("listCat", liCat);
		return "shop.admin.cat.index";
	}

	@GetMapping(UrlConstants.URL_ADMIN_CAT_ADD)
	public String add() {
		return "shop.admin.cat.add";
	}

	@PostMapping(UrlConstants.URL_ADMIN_CAT_ADD)
	public String add(@Valid @ModelAttribute("cat") CategoryDto cat, BindingResult rs, RedirectAttributes ra,Model model) {
		if (rs.hasErrors()) {
			model.addAttribute("cat",cat);
			return "shop.admin.cat.add";
		}
		if(categoryService.checkCate(cat)!=null) {
			model.addAttribute("msg","Danh Muc Da Ton Tai");
			model.addAttribute("cat",cat);
			return "shop.admin.cat.add";
		}
		int addCat = categoryService.add(cat);
		if (addCat > 0) {
			ra.addFlashAttribute("msg","Them Danh Muc Thanh Cong");
			return "redirect:/admin" + UrlConstants.URL_ADMIN_CAT_INDEX;
		}
		ra.addFlashAttribute("msg","Them Danh Muc That Bai");
		return "redirect:/admin" + UrlConstants.URL_ADMIN_CAT_ADD;
	}

	@GetMapping(UrlConstants.URL_ADMIN_CAT_DEL)
	public String Del(@PathVariable Integer id, RedirectAttributes ra) {
		List<ProductDto> list = productService.findByCatId(id);
		for (ProductDto productDto : list) {
			String dirPath = servletContext.getRealPath("") + FileDefine.DIR_UPLOAD;
			String nameoldfile = dirPath + File.separator + productService.getItem(id).getPicture();
			File oldFile = new File(nameoldfile);
			oldFile.delete();
			int del =productService.delete(productDto.getId());
		}
		int delcat = categoryService.delete(id);
		if (delcat > 0) {
			ra.addFlashAttribute("msg","Xóa Danh Mục Thành Công");
			return "redirect:/admin" + UrlConstants.URL_ADMIN_CAT_INDEX;
		}
		ra.addFlashAttribute("msg","Xóa Danh Mục Thất Bại");
		return "redirect:/admin" + UrlConstants.URL_ADMIN_CAT_INDEX;
	}

	@GetMapping(UrlConstants.URL_ADMIN_CAT_EDIT)
	public String Edit(@PathVariable Integer id, Model model) {
		CategoryDto category = categoryService.getItem(id);
		System.out.println(category.getParent_id());
		model.addAttribute("category", category);
		return "shop.admin.cat.edit";
	}

	@PostMapping(UrlConstants.URL_ADMIN_CAT_EDIT)
	public String edit(@Valid @ModelAttribute("cat") CategoryDto cat, BindingResult rs,@PathVariable Integer id,
			RedirectAttributes ra,Model model) {
		if(rs.hasErrors()) { return "shop.admin.cat.edit"; }
		if((categoryService.checkCate(cat)!=null) && (categoryService.getParent(cat.getParent_id()).getName().equals(categoryService.getItem(id).getParent_name()))) {
			model.addAttribute("msg","Danh Muc Da Ton Tai");
			model.addAttribute("category",cat);
			return "shop.admin.cat.edit";
		}
		int editcat = categoryService.edit(cat);
		if (editcat > 0) {
			ra.addFlashAttribute("msg","Sua Danh Muc Thanh Cong");
			return "redirect:/admin" + UrlConstants.URL_ADMIN_CAT_INDEX;
		}
		ra.addFlashAttribute("msg","Sua Danh Muc That Bai");
		return "redirect:/admin" + UrlConstants.URL_ADMIN_CAT_EDIT;
	}
	
	

}

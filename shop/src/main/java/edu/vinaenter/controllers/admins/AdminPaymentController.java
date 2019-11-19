package edu.vinaenter.controllers.admins;

import java.io.File;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.vinaenter.constants.UrlConstants;
import edu.vinaenter.dto.CategoryDto;
import edu.vinaenter.dto.ProductDto;
import edu.vinaenter.models.Payments;
import edu.vinaenter.services.PaymentService;
import edu.vinaenter.utils.FileDefine;

@Controller
@RequestMapping(UrlConstants.URL_ADMIN)
public class AdminPaymentController {
	@Autowired
	private PaymentService paymentService;
	@Autowired
	private ServletContext servletContext;
	
	@GetMapping(UrlConstants.URL_ADMIN_PAY_INDEX)
	public String index(Model model) {
		List<Payments> listPay =	paymentService.findAll();	
		model.addAttribute("listPay", listPay);
		return "shop.admin.pay.index";
	}
	@GetMapping(UrlConstants.URL_ADMIN_PAY_ADD)
	public String add(Model model) {
		return "shop.admin.pay.add";
	}
	@PostMapping(UrlConstants.URL_ADMIN_PAY_ADD)
	public String add(@Valid @ModelAttribute("pay") Payments pay, BindingResult rs, RedirectAttributes ra,Model model) {
		if (rs.hasErrors()) {
			model.addAttribute("pay",pay);
			return "shop.admin.pay.add";
		}
		int addPay= paymentService.add(pay);
		if (addPay > 0) {
			ra.addFlashAttribute("msg","Them Thanh Cong");
			return "redirect:/admin" + UrlConstants.URL_ADMIN_PAY_INDEX;
		}
		ra.addFlashAttribute("msg","Them That Bai");
		return "redirect:/admin" + UrlConstants.URL_ADMIN_PAY_ADD;
	}
	
	@GetMapping(UrlConstants.URL_ADMIN_PAY_EDIT)
	public String Edit(@PathVariable Integer id, Model model) {
		Payments pay = paymentService.getPaayment(id);
		model.addAttribute("pay", pay);
		return "shop.admin.pay.edit";
	}
	@PostMapping(UrlConstants.URL_ADMIN_PAY_EDIT)
	public String edit(@Valid @ModelAttribute("pay") Payments pay, BindingResult rs,@PathVariable Integer id,
			RedirectAttributes ra,Model model) {
		if(rs.hasErrors()) { 
			model.addAttribute("pay",pay);
			return "shop.admin.pay.edit"; }
		
		int editcat = paymentService.edit(pay);
		if (editcat > 0) {
			ra.addFlashAttribute("msg","Sua Danh Muc Thanh Cong");
			return "redirect:/admin" + UrlConstants.URL_ADMIN_PAY_INDEX;
		}
		ra.addFlashAttribute("msg","Sua Danh Muc That Bai");
		return "redirect:/admin" + UrlConstants.URL_ADMIN_PAY_EDIT;
	}
	@GetMapping(UrlConstants.URL_ADMIN_PAY_DEL)
	public String Del(@PathVariable Integer id, RedirectAttributes ra) {
		
		int delcat = paymentService.delete(id);
		if (delcat > 0) {
			ra.addFlashAttribute("msg","Xóa Thành Công");
			return "redirect:/admin" + UrlConstants.URL_ADMIN_PAY_INDEX;
		}
		ra.addFlashAttribute("msg","Xóa Thất Bại");
		return "redirect:/admin" + UrlConstants.URL_ADMIN_PAY_INDEX;
	}
}

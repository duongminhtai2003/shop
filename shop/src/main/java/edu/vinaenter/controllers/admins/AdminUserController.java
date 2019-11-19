package edu.vinaenter.controllers.admins;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import edu.vinaenter.constants.CommonConstants;
import edu.vinaenter.constants.UrlConstants;
//import edu.vinaenter.models.Category;
import edu.vinaenter.models.User;
import edu.vinaenter.services.UserServices;

@Controller
@RequestMapping(UrlConstants.URL_ADMIN)
public class AdminUserController {

	@Autowired
	private UserServices userServices;

	@Autowired
	private MessageSource messageSource;

	@GetMapping({ "/user/index", "/user/index/{page}" })
	public String index(@PathVariable(required = false) Integer page, Model model) {
		if (page == null) {
			page = 1;
		}
		int offset = (page - 1) * CommonConstants.DEFAULT_PAGING_SIZE;
		int coutPagination = userServices.countPagination();
		int totalPage = (int) Math.ceil((float) coutPagination / CommonConstants.DEFAULT_PAGING_SIZE);
		List<User> listUser = userServices.findAllPagination(offset);
		model.addAttribute("listUser", listUser);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("page", page);
		return "shop.admin.user.index";
	}

	@GetMapping(UrlConstants.URL_ADMIN_USER_ADD)
	public String add() {
		return "shop.admin.user.add";
	}

	@PostMapping(UrlConstants.URL_ADMIN_USER_ADD)
	public String add(@Valid @ModelAttribute("user") User user, BindingResult rs, RedirectAttributes ra,Model model) {
		if (rs.hasErrors()) {
			model.addAttribute("user", user);
			return "shop.admin.user.add";
		}
		if (userServices.checkUser(user) == false) {
			model.addAttribute("msg","Email Da Ton Tai");
			return "shop.admin.user.add";
		}
		if(user.getActive()==null) user.setActive(0);
		user.setPassword(BCrypt.hashpw(user.getPassword(),BCrypt.gensalt()));
		
		int addUser = userServices.addUser(user);
		if (addUser > 0) {
			ra.addFlashAttribute("msg","Them USER Thanh Cong");
			return "redirect:/admin" + UrlConstants.URL_ADMIN_USER_INDEX;
		}
		ra.addFlashAttribute("msg","Them USER That Bai");
		return "redirect:/admin" + UrlConstants.URL_ADMIN_USER_ADD;
	}

	
	  @GetMapping(UrlConstants.URL_ADMIN_USER_EDIT) 
	  public String edit(@PathVariable Integer id, Model model) { 
		  User item =userServices.getItem(id);
		  model.addAttribute("item", item); 
		  return "shop.admin.user.edit"; 
	  }
  
	  @PostMapping(UrlConstants.URL_ADMIN_USER_EDIT)
		public String edit(@Valid @ModelAttribute("user") User user, BindingResult rs,@PathVariable Integer id,
				RedirectAttributes ra,Model model) {
		  System.out.println(user);
		  	if(!"".equals(user.getPassword())) {
		  		if(!user.getPassword().equals(userServices.getItem(id).getPassword()))
				user.setPassword(BCrypt.hashpw(user.getPassword(),BCrypt.gensalt()));
			}else {
				user.setPassword(userServices.getItem(id).getPassword());
			}
		  	if(rs.hasErrors()) {
		  		model.addAttribute("item",user);
		  		return "shop.admin.user.edit"; 
		  	}
		  	if(user.getOtp()==null) user.setOtp(0);

			int edituser =  userServices.edit(user);
			if (edituser > 0) {
				ra.addFlashAttribute("msg","EDIT USER Thanh Cong");
				return "redirect:/admin" + UrlConstants.URL_ADMIN_USER_INDEX;
			}
			ra.addFlashAttribute("msg","EDIT USER That Bai");
			return "redirect:/admin" + UrlConstants.URL_ADMIN_USER_EDIT;
		}
	 

	@GetMapping(UrlConstants.URL_ADMIN_USER_DEL)
	public String Del(@PathVariable Integer id, RedirectAttributes ra) {
		int delcat = userServices.delete(id);
		if (delcat > 0) {
			ra.addFlashAttribute("msg","XOA USER Thanh Cong");
			return "redirect:/admin" + UrlConstants.URL_ADMIN_USER_INDEX;
		}
		ra.addFlashAttribute("msg","XOA USER THAT BAI");
		return "redirect:/admin" + UrlConstants.URL_ADMIN_USER_INDEX;
	}
}

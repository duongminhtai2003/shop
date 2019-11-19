package edu.vinaenter.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/auth")
public class LoginController {
	
	@GetMapping(value = "/login")
	public String login() {
		return "shop.login";
	}
	
	@GetMapping(value = "/create")
	public String create() {
		return "shop.createaccount";
	}
}

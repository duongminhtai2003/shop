package edu.vinaenter.controllers.admins;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class AdminIndexController {


	@GetMapping(value = "/admin")
	public String index() {
		return "shop.admin.index";
	}
	
}

package fr.doranco.ecommerce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class IndexController {

	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("test", "test");
		return "index";
	}
}

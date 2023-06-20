package fr.doranco.ecommerce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/test")
public class IndexController {

	@RequestMapping("")
	public String index(@RequestParam(name = "name", required = false, defaultValue = "test") String name,
			Model model) {
		model.addAttribute("name", name);
		return "index";
	}
}

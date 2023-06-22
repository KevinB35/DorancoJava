package fr.doranco.ecommerce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
@RequestMapping("/test")
public class IndexController {

    @RequestMapping("")
    public String index(Principal principal,
                        @RequestParam(name = "name", required = false, defaultValue = "test") String name,
                        Model model) {
        try {
            model.addAttribute("user", principal.getName());
        } catch (NullPointerException e) {
            model.addAttribute("user", "");
        }
        model.addAttribute("user", "test user");
        return "index";
    }
    
}

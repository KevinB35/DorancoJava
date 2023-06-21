package fr.doranco.ecommerce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
public class AccueilController {

    @RequestMapping("/")
    public String index(Principal principal, Model model) {
        try {
            model.addAttribute("user", principal.getName());
        } catch (NullPointerException e) {
            model.addAttribute("user", "");
        }
        return "accueil";
    }
}

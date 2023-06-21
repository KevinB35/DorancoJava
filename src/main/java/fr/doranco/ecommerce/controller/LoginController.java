package fr.doranco.ecommerce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
public class LoginController {

    @RequestMapping("/login-utilisateur")
    public String index(Principal principal, Model model) {
        try {
            model.addAttribute("user", principal.getName());
        } catch (NullPointerException e) {
            model.addAttribute("user", "");
        }
        return "login-utilisateur";
    }

}

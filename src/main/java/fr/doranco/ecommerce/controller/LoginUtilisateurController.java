package fr.doranco.ecommerce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

@Controller
public class LoginUtilisateurController {

    @RequestMapping(value = "/login-utilisateur", method = RequestMethod.GET)
    public String index(Principal principal, Model model) {
        try {
            model.addAttribute("user", principal.getName());
        } catch (NullPointerException e) {
            model.addAttribute("user", "");
        }
        return "login-utilisateur";
    }
    
    @RequestMapping("/create-utilisateur")
    public String index(Principal principal, Model model) {
        try {
            model.addAttribute("user", principal.getName());
        } catch (NullPointerException e) {
            model.addAttribute("user", "");
        }
        return "add-utilisateur";
    }

}

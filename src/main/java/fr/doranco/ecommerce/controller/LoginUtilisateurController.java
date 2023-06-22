package fr.doranco.ecommerce.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

@Controller
public class LoginUtilisateurController {

    @RequestMapping(value = "/login-utilisateur", method = RequestMethod.GET)
    public String index(Authentication auth, Model model) {
        try {
            model.addAttribute("user", (User) auth.getPrincipal());
        } catch (NullPointerException e) {
            model.addAttribute("user", null);
        }
        return "login-utilisateur";
    }
}

package fr.doranco.ecommerce.controller;

import fr.doranco.ecommerce.entities.Article;
import fr.doranco.ecommerce.repository.ArticleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Controller
public class GestionAchatController {

    @Autowired
    private ArticleRepository articleRepository;

    @RequestMapping("/gestion-achats")
    public String gestionAchats(Authentication auth,
                                Model model) {

        List<Article> articles = articleRepository.findAll();
        model.addAttribute("articles", articles);

        try {
            model.addAttribute("user", (User) auth.getPrincipal());
        } catch (NullPointerException e) {
            model.addAttribute("user", null);
        }
        model.addAttribute("role", SecurityContextHolder.getContext().getAuthentication().getAuthorities().stream().iterator().next().toString());

        return "gestion-achats";
    }
}

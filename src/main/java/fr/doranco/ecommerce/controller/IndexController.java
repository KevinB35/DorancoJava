package fr.doranco.ecommerce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.doranco.ecommerce.entities.Article;
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
    
    @GetMapping(value = "/article/{articleId}")
    public Article getArticleById(@PathVariable Long id) {
        Article articleDto = new Article();

        return articleDto;
    }
}

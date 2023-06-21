package fr.doranco.ecommerce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.doranco.ecommerce.dto.articleDto;
import fr.doranco.ecommerce.entities.Article;

@Controller
@RequestMapping("/test")
public class IndexController {

    @RequestMapping("")
    public String index(@RequestParam(name = "name", required = false, defaultValue = "test") String name,
                        Model model) {
        model.addAttribute("name", name);
        model.addAttribute("user", "test user");
        return "index";
    }
    
    @GetMapping(value = "/article/{articleId}")
    public articleDto getArticleById(@PathVariable Long id) {
        articleDto articleDto = new Article();

        return articleDto;
    }
}

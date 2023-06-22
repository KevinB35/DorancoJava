package fr.doranco.ecommerce.controller;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.doranco.ecommerce.entities.Article;
import fr.doranco.ecommerce.repository.ArticleRepository;

@Controller
public class ArticleController {
	
	@Autowired
	private ArticleRepository articleRepository;

    @RequestMapping("/Article")
    public String article(Principal principal,
                                @RequestParam(name = "id", required = false, defaultValue = "") Long id,
                                Model model) {

    	Optional<Article> findArticle = articleRepository.findById(id);
    	Article article = findArticle.get();
        model.addAttribute("articles", article);

        try {
            model.addAttribute("user", principal.getName());
        } catch (NullPointerException e) {
            model.addAttribute("user", "");
        }
        return "article";
    }
    
}
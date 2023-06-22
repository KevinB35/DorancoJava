package fr.doranco.ecommerce.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.doranco.ecommerce.entities.Article;

@RestController
public class ArticleRestController {

    @PostMapping(value = "/create")
    public Article createArticle(@PathVariable Long id) {
        Article student = new Article();

        return student;
    }
    
    @DeleteMapping(value = "/delete")
    public void deleteArticle(@PathVariable Long id) {
    }
}

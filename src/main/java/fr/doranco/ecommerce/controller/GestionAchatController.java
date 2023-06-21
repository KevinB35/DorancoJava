package fr.doranco.ecommerce.controller;

import fr.doranco.ecommerce.entities.Article;
import fr.doranco.ecommerce.repository.ArticleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;

@Controller
public class GestionAchatController {
	
	@Autowired
	private ArticleRepository articleRepository;

    @RequestMapping("/gestion-achats")
    public String gestionAchats(Principal principal,
                                @RequestParam(name = "id", required = false, defaultValue = "1") Long id,
                                Model model) {

    	Optional<Article> findArticle = articleRepository.findById(id);
    	Article article = findArticle.get();
        model.addAttribute("articles", List.of(article));

        try {
            model.addAttribute("user", principal.getName());
        } catch (NullPointerException e) {
            model.addAttribute("user", "");
        }
        return "gestion-achats";
    }
    
}


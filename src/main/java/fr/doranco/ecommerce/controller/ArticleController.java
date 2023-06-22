package fr.doranco.ecommerce.controller;

import java.security.Principal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fr.doranco.ecommerce.entities.Article;
import fr.doranco.ecommerce.entities.Categorie;
import fr.doranco.ecommerce.entities.Commentaire;
import fr.doranco.ecommerce.repository.ArticleRepository;

@Controller
public class ArticleController {
	
	@Autowired
	private ArticleRepository articleRepository;

    @RequestMapping(value = "/Article", method = RequestMethod.GET)
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
    
    @RequestMapping(value = "/Article?id=${article.id}", method = RequestMethod.POST)
    public String post(@RequestParam(name = "nom") String nom,
                       @RequestParam(name = "description") String description,
                       @RequestParam(name = "prix") Float prix,
                       @RequestParam(name = "remise") Float remise,
                       @RequestParam(name = "stock") Integer stock,
                       @RequestParam(name = "isVendable") Boolean isVendable,
                       @RequestParam(name = "photo") String photo,
                       @RequestParam(name = "video") String video,
                       @RequestParam(name = "commentaire") List<Commentaire> commentaires,
                       @RequestParam(name = "categorie") Categorie categorie,
                       Model model) {
    	Article article = new Article();
    	article.setNom(nom);
    	article.setDescription(description);
    	article.setPrix(prix);
    	article.setRemise(remise);
    	article.setStock(stock);
    	article.setIsVendable(isVendable);
    	article.setPhoto(photo);
    	article.setVideo(video);
    	article.setCommentaire(commentaires);
    	article.setCategorie(categorie);

        saveAndFlush(article);

        return "article";
    }
    
}

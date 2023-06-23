package fr.doranco.ecommerce.controller;

import java.security.Principal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fr.doranco.ecommerce.entities.Article;
import fr.doranco.ecommerce.entities.Categorie;
import fr.doranco.ecommerce.entities.Commentaire;
import fr.doranco.ecommerce.repository.ArticleRepository;
import fr.doranco.ecommerce.repository.CategorieRepository;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private CategorieRepository categorieRepository;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String article(@PathVariable("id") Long id,
                          Authentication auth,
                          Model model) {

        Optional<Article> findArticle = articleRepository.findById(id);
        Article article = findArticle.get();
        model.addAttribute("article", article);
        model.addAttribute("id", id);

        try {
            model.addAttribute("user", (User) auth.getPrincipal());
            model.addAttribute("role", ((User) auth.getPrincipal()).getAuthorities().iterator().next());
        } catch (NullPointerException e) {
            model.addAttribute("user", null);
        }
        model.addAttribute("role", SecurityContextHolder.getContext().getAuthentication().getAuthorities().stream().iterator().next().toString());

        return "article";
    }

    @RequestMapping(value = "/ajouter", method = RequestMethod.GET)
    public String article(
            Authentication auth,
            Model model) {

        try {
            model.addAttribute("user", (User) auth.getPrincipal());
        } catch (NullPointerException e) {
            model.addAttribute("user", null);
        }
        return "add-articles";
    }

    @RequestMapping(value = "/ajouter", method = RequestMethod.POST)
    public String post(@RequestParam(name = "nom") String nom,
                       @RequestParam(name = "description") String description,
                       @RequestParam(name = "prix") Float prix,
                       @RequestParam(name = "remise") Float remise,
                       @RequestParam(name = "stock") Integer stock,
                       @RequestParam(name = "isVendable") Boolean isVendable,
                       @RequestParam(name = "photo") String photo,
                       @RequestParam(name = "video") String video,
                       @RequestParam(name = "categorie") String categorie,
                       Authentication auth,
                       Model model) {

        Optional<Categorie> foundC = categorieRepository.findById(Long.parseLong(categorie));
        Categorie c = foundC.get();

        Article article = new Article();
        article.setNom(nom);
        article.setDescription(description);
        article.setPrix(prix);
        article.setRemise(remise);
        article.setStock(stock);
        article.setVendable(isVendable);
        article.setPhoto(photo);
        article.setVideo(video);
        article.setCategorie(c);

        saveAndFlush(article);

        try {
            model.addAttribute("user", (User) auth.getPrincipal());
        } catch (NullPointerException e) {
            model.addAttribute("user", null);
        }

        return "accueil";
    }


    @RequestMapping("/catalogue")
    public String gestionAchats(Authentication auth,
                                Model model,
                                @RequestParam(name = "categorie", required = false, defaultValue = "0") String categorie) {
        List<Article> articles = articleRepository.findAll();

        if (!categorie.equals("0")) {
            articles = articles.stream().filter(article -> article.getCategorie().getId().toString().equals(categorie)).toList();
        }

        model.addAttribute("articles", articles);
        model.addAttribute("categorie", categorie);

        try {
            model.addAttribute("user", (User) auth.getPrincipal());
        } catch (NullPointerException e) {
            model.addAttribute("user", null);
        }
        model.addAttribute("role", SecurityContextHolder.getContext().getAuthentication().getAuthorities().stream().iterator().next().toString());

        return "gestion-achats";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(Authentication auth,
                         Model model,
                         @RequestParam(name = "id") String id) {
        Optional<Article> foundArticle = articleRepository.findById(Long.parseLong(id));
        Article article = foundArticle.get();

        articleRepository.delete(article);

        try {
            model.addAttribute("user", (User) auth.getPrincipal());
        } catch (NullPointerException e) {
            model.addAttribute("user", null);
        }

        return "accueil";
    }

    public void saveAndFlush(Article article) {
        articleRepository.saveAndFlush(article);
    }
}

package fr.doranco.ecommerce.controller;

import fr.doranco.ecommerce.entities.Article;
import fr.doranco.ecommerce.entities.ArticlePanier;
import fr.doranco.ecommerce.entities.Utilisateur;
import fr.doranco.ecommerce.repository.ArticleRepository;
import fr.doranco.ecommerce.repository.PanierRepository;
import fr.doranco.ecommerce.repository.UtilisateurRepository;
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

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/panier")
public class PanierController {

    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private UtilisateurRepository utilisateurRepository;
    @Autowired
    private PanierRepository panierRepository;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@RequestParam("idArticle") Long idArticle,
                      @RequestParam("idUtilisateur") String idUtilisateur,
                      @RequestParam("quantite") Integer quantite,
                      Authentication auth,
                      Model model) {

        Optional<Utilisateur> utilisateurT;

        switch (idUtilisateur) {
            case "Admin@admin.com":
                utilisateurT = utilisateurRepository.findById(1L);
                break;
            case "Magasinier@admin.com":
                utilisateurT = utilisateurRepository.findById(2L);
                break;
            default:
                utilisateurT = utilisateurRepository.findById(3L);
                break;
        }

        Optional<Article> articleT = articleRepository.findById(idArticle);
        Article article = articleT.get();

        Utilisateur utilisateur = utilisateurT.get();

        ArticlePanier articlePanier = new ArticlePanier(article, quantite, utilisateur);

        //TODO: Enlever 1 au stock de l'artice
        panierRepository.saveAndFlush(articlePanier);

        try {
            model.addAttribute("user", (User) auth.getPrincipal());
        } catch (NullPointerException e) {
            model.addAttribute("user", null);
        }
        model.addAttribute("role", SecurityContextHolder.getContext().getAuthentication().getAuthorities().stream().iterator().next().toString());

        return "accueil";
    }
}

package fr.doranco.ecommerce.controller;

import fr.doranco.ecommerce.entities.Article;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.List;

@Controller
public class GestionAchatController {

    @RequestMapping("/gestion-achats")
    public String gestionAchats(Principal principal,
                                @RequestParam(name = "category", required = false, defaultValue = "") String category,
                                Model model) {

        List<Article> articles = List.of(
                new Article(
                        "Nom 1",
                        "Description 1",
                        1F,
                        0F,
                        1,
                        true,
                        "",
                        "",
                        null,
                        null
                ), new Article(
                        "Nom 2",
                        "Description 2",
                        2F,
                        1F,
                        2,
                        true,
                        "",
                        "",
                        null,
                        null
                )
        );

        model.addAttribute("articles", articles);

        try {
            model.addAttribute("user", principal.getName());
        } catch (NullPointerException e) {
            model.addAttribute("user", "");
        }
        return "gestion-achats";
    }
}


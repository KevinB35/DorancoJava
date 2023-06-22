/*
package fr.doranco.ecommerce.controller;


import java.security.Principal;
import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fr.doranco.ecommerce.entities.Utilisateur;
import fr.doranco.ecommerce.repository.UtilisateurRepository;

@Controller
public class AddUtilisateurController {

    @Autowired
    PasswordEncoder passwordEncoder;

    @RequestMapping(value = "/add-utilisateur", method = RequestMethod.POST)
    public String post(@RequestParam(name = "nom") String nom,
                       @RequestParam(name = "prenom") String prenom,
                       @RequestParam(name = "dateNaissance") Date dateNaissance,
                       @RequestParam(name = "profil") String profil,
                       @RequestParam(name = "username") String username,
                       @RequestParam(name = "password") String password,
                       @RequestParam(name = "telephone") String telephone,
                       Model model) {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setNom(nom);
        utilisateur.setPrenom(prenom);
        utilisateur.setDateNaissance(dateNaissance);
        utilisateur.setUsername(username);
        utilisateur.setPassword(passwordEncoder.encode(password));
        utilisateur.setTelephone(telephone);
        utilisateur.setEnabled(true);

        saveAndFlush(utilisateur);

        model.addAttribute("signin", true);
        return "login-utilisateur";
    }

    @RequestMapping(value = "/add-utilisateur", method = RequestMethod.GET)
    public String get(Principal principal, Model model) {
        try {
            model.addAttribute("user", principal.getName());
        } catch (NullPointerException e) {
            model.addAttribute("user", "");
        }
        return "add-utilisateur";
    }

    public void saveAndFlush(Utilisateur utilisateur) {
        utilisateurRepository.saveAndFlush(utilisateur);
    }
}
*/
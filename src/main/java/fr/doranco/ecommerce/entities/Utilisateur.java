package fr.doranco.ecommerce.entities;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Utilisateur {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private String prenom;

    @Column(nullable = false)
    private Date dateNaissance;

    //isActif
    @Column(nullable = false)
    private Boolean enabled;
    
    //email
    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column()
    private String telephone;

    @OneToMany
    private List<Adresse> adresse;

    @OneToMany
    private List<Commande> commandes;

    @OneToMany
    private List<CartePaiement> carteDePaiemement;

    @OneToMany
    private List<Commentaire> commentaires;

    @OneToMany
    private List<ArticlePanier> panier;
}

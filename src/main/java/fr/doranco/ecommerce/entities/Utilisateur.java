package fr.doranco.ecommerce.entities;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
public class Utilisateur {

    @Id
    @GeneratedValue
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

    @Column(nullable = false)
    private String profil;

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

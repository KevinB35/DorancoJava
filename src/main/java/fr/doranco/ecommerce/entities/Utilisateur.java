package fr.doranco.ecommerce.entities;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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

    @Column(nullable = false)
    private Boolean isActif;

    @Column(nullable = false)
    private String profil;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column()
    private String telephone;

    @Column(nullable = false)
    private List<Adresse> adresse;

    @Column()
    private List<Commande> commandes;

    @Column(nullable = false)
    private List<CartePaiement> carteDePaiemement;

    @Column()
    private List<Commentaire> commentaires;

    @Column()
    private List<Panier> panier;
}

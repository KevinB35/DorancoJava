package fr.doranco.ecommerce.entities;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class Utilisateur {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, length = 100)
    private String nom;

    @Column(nullable = false, length = 100)
    private String prenom;

    @Column(nullable = false)
    private Date dateNaissance;

    @Column()
    private Boolean isActif;

    @Column()
    private String profil;

    @Column()
    private String email;

    @Column()
    private String password;

    @Column()
    private String telephone;

    @Column()
    private List<Adresse> adresse;

    @Column()
    private List<Commande> commandes;

    @Column()
    private List<CartePaiement> carteDePaiemement;

    @Column()
    private List<Commentaire> commentaires;

    @Column()
    private List<Panier> panier;
}

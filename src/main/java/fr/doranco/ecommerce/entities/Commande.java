package fr.doranco.ecommerce.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;
import java.util.List;

@Entity
@Table
public class Commande {

    @Id
    @Column
    private Long id;

    @Column
    private Integer numero;

    @Column
    private Date dateCreation;

    @Column
    private Date dateLivraison;

    @Column
    private Float totalRemise;

    @Column
    private Float fraisExpedition;

    @Column
    private Float totalGeneral;

    @Column
    private Adresse adresseFacturation;

    @Column
    private Adresse adresseLivraison;

    @Column
    private CartePaiement cartePaiement;

    @Column
    private Utilisateur utilisateur;

    @Column
    private List<LigneCommande> lignesCommande;
}

package fr.doranco.ecommerce.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class LigneCommande {

    @Id
    @Column
    private Long id;

    @Column
    private Integer quantite;

    @Column
    private Float prixUnitaire;

    @Column
    private Float remiseArticle;

    @Column
    private Commande commande;

    @Column
    private Article article;
}

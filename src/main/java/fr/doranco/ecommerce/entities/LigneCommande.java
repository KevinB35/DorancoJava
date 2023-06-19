package fr.doranco.ecommerce.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
public class LigneCommande {

    @Id
    @GeneratedValue
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

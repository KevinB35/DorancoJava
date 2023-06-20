package fr.doranco.ecommerce.entities;

import java.util.List;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
public class Article {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String nom;

    @Column
    private String description;

    @Column(nullable = false)
    private Float prix;

    @Column
    private Float remise;

    @Column(nullable = false)
    private Integer stock;

    @Column(nullable = false)
    private Boolean isVendable;

    @Column(nullable = false)
    private String photo;

    @Column
    private String video;

    @OneToMany
    private List<Commentaire> commentaires;

    @ManyToOne
    private Categorie categorie;

    public Article(String nom, String description, Float prix, Float remise, Integer stock, Boolean isVendable, String photo, String video, List<Commentaire> commentaires, Categorie categorie) {
        this.nom = nom;
        this.description = description;
        this.prix = prix;
        this.remise = remise;
        this.stock = stock;
        this.isVendable = isVendable;
        this.photo = photo;
        this.video = video;
        this.commentaires = commentaires;
        this.categorie = categorie;
    }
}

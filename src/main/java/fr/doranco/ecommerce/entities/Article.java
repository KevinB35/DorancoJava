package fr.doranco.ecommerce.entities;

import java.util.List;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
//@NoArgsConstructor
public class Article {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
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

    public Article() {
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

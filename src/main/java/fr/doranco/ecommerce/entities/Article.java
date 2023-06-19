package fr.doranco.ecommerce.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

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

    @Column
    private List<Commentaire> commentaires;
}

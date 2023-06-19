package fr.doranco.ecommerce.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table
public class Article {

    @Id
    @Column
    private Long id;

    @Column
    private String description;

    @Column
    private Float prix;

    @Column
    private Float remise;

    @Column
    private Integer stock;

    @Column
    private Boolean isVendable;

    @Column
    private String photo;

    @Column
    private String video;

    @Column
    private List<Commentaire> commentaires;
}

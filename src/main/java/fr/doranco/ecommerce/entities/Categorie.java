package fr.doranco.ecommerce.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table
@Getter
@Setter
public class Categorie {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String nom;

    @Column
    private Float remise;

    @Column(nullable = false)
    private Boolean isRemiseCumulable;

    @Column
    private String photo;

    @Column
    private List<Article> articles;
}

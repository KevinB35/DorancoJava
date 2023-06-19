package fr.doranco.ecommerce.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table
public class Categorie {

    @Id
    @Column
    private Long id;

    @Column
    private Float remise;

    @Column
    private Boolean isRemiseCumulable;

    @Column
    private String photo;

    @Column
    private List<Article> articles;
}

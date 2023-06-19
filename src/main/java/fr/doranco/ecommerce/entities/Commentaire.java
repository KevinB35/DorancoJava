package fr.doranco.ecommerce.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Commentaire {

    @Id
    @Column
    private Long id;

    @Column
    private String texte;

    @Column
    private Float note;

    @Column
    private Article article;

    @Column
    private Utilisateur utilisateur;
}

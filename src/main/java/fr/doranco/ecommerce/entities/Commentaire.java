package fr.doranco.ecommerce.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
public class Commentaire {

    @Id
    @GeneratedValue
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
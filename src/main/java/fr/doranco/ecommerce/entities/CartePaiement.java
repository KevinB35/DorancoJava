package fr.doranco.ecommerce.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table
@Getter
@Setter
public class CartePaiement {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String nomProprietaire;

    @Column(nullable = false)
    private String prenomProprietaire;

    @Column(nullable = false)
    private String numero;

    @Column(nullable = false)
    private Date dateFinValidite;

    @Column(nullable = false)
    private String cryptogramme;

    @Column(nullable = false)
    private Utilisateur utilisateur;
}

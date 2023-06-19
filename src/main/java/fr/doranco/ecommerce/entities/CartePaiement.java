package fr.doranco.ecommerce.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table
public class CartePaiement {

    @Id
    @Column
    private Long id;

    @Column
    private String nomProprietaire;

    @Column
    private String prenomProprietaire;

    @Column
    private String numero;

    @Column
    private Date dateFinValidite;

    @Column
    private String cryptogramme;

    @Column
    private Utilisateur utilisateur;
}

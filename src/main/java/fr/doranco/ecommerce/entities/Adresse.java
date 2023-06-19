package fr.doranco.ecommerce.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Adresse {

    @Id
    @Column
    private Long id;

    @Column
    private String numero;

    @Column
    private String rue;

    @Column
    private String ville;

    @Column
    private String codePostal;

    @Column
    private Utilisateur utilisateur;

}

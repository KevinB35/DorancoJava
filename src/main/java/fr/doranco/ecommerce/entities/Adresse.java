package fr.doranco.ecommerce.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
public class Adresse {

    @Id
    @GeneratedValue
    private Long id;

    @Column()
    private String numero;

    @Column(nullable = false)
    private String rue;

    @Column(nullable = false)
    private String ville;

    @Column(nullable = false)
    private String codePostal;

    @Column(nullable = false)
    private Utilisateur utilisateur;

}

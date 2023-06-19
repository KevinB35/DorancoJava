package fr.doranco.ecommerce.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table()
public class Panier {


    @Id
    @Column()
    private Long id;

    @Column()
    private Article article;

    @Column()
    private Integer quantite;

    @Column()
    private Utilisateur utilisateur;
}

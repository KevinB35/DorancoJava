package fr.doranco.ecommerce.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table()
@Getter
@Setter
public class Panier {


    @Id
    @GeneratedValue
    private Long id;

    @Column()
    private Article article;

    @Column()
    private Integer quantite;

    @Column()
    private Utilisateur utilisateur;
}

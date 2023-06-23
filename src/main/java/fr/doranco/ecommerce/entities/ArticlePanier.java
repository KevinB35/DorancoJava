package fr.doranco.ecommerce.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table()
@Getter
@Setter
public class ArticlePanier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Article article;

    @Column()
    private Integer quantite;

    @ManyToOne
    private Utilisateur utilisateur;

    public ArticlePanier(Article article, Integer quantite, Utilisateur utilisateur) {
        this.article = article;
        this.quantite = quantite;
        this.utilisateur = utilisateur;
    }
}

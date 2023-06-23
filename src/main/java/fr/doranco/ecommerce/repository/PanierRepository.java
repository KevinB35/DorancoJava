package fr.doranco.ecommerce.repository;

import fr.doranco.ecommerce.entities.Article;
import fr.doranco.ecommerce.entities.ArticlePanier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface PanierRepository extends JpaRepository<Article, Long> {
    ArticlePanier saveAndFlush(ArticlePanier articlePanier);
}

package fr.doranco.ecommerce.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import fr.doranco.ecommerce.entities.Article;  

public interface ArticleRepository extends JpaRepository<Article, Long>{
	Optional<Article> findById(Long id);

}

package fr.doranco.ecommerce.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import fr.doranco.ecommerce.entities.Article;
import fr.doranco.ecommerce.entities.Categorie;  


public interface CategorieRepository extends JpaRepository<Categorie, Long>{
	Optional<Categorie> findById(Long id);

}

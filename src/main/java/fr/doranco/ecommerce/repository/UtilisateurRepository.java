package fr.doranco.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.doranco.ecommerce.entities.Utilisateur;

import java.util.Optional;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
    Utilisateur findByUsername(String username);

    Optional<Utilisateur> findById(Long id);

    Utilisateur saveAndFlush(Utilisateur utilisateur);
}
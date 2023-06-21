package fr.doranco.ecommerce.dto;

import java.util.List;

import fr.doranco.ecommerce.entities.Commentaire;

public record articleDto(Long id, String nom, String description, Float prix, Float remise, Integer stock, Boolean isVendable,
		String photo, String video, List<Commentaire> commentaires) {

}

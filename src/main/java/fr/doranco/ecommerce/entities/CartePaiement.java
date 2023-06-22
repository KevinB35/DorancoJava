package fr.doranco.ecommerce.entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
public class CartePaiement {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String nomProprietaire;

	@Column(nullable = false)
	private String prenomProprietaire;

	@Column(nullable = false)
	private String numero;

	@Column(nullable = false)
	private Date dateFinValidite;

	@Column(nullable = false)
	private String cryptogramme;

	@ManyToOne
	private Utilisateur utilisateur;
}

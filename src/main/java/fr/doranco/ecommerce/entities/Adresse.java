package fr.doranco.ecommerce.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
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

	@ManyToOne
	private Utilisateur utilisateur;
}

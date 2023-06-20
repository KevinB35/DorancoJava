package fr.doranco.ecommerce.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
public class Article {

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	private String nom;

	@Column
	private String description;

	@Column(nullable = false)
	private Float prix;

	@Column
	private Float remise;

	@Column(nullable = false)
	private Integer stock;

	@Column(nullable = false)
	private Boolean isVendable;

	@Column(nullable = false)
	private String photo;

	@Column
	private String video;

	@OneToMany
	private List<Commentaire> commentaires;
}

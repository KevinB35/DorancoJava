package fr.doranco.ecommerce.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
public class Categorie {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String nom;

	@Column
	private Float remise;

	@Column(nullable = false)
	private Boolean isRemiseCumulable;

	@Column
	private String photo;

	@OneToMany
	private List<Article> articles;
}

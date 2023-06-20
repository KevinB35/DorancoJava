package fr.doranco.ecommerce.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table()
@Getter
@Setter
public class ArticlePanier {

	@Id
	@GeneratedValue
	private Long id;

	@OneToOne
	private Article article;

	@Column()
	private Integer quantite;

	@ManyToOne
	private Utilisateur utilisateur;
}

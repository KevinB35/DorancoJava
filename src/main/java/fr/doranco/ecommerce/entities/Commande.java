package fr.doranco.ecommerce.entities;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
public class Commande {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column
	private Integer numero;

	@Column
	private Date dateCreation;

	@Column
	private Date dateLivraison;

	@Column
	private Float totalRemise;

	@Column
	private Float fraisExpedition;

	@Column
	private Float totalGeneral;

	@OneToOne
	private Adresse adresseFacturation;

	@OneToOne
	private Adresse adresseLivraison;

	@OneToOne
	private CartePaiement cartePaiement;

	@ManyToOne
	private Utilisateur utilisateur;

	@OneToMany
	private List<LigneCommande> lignesCommande;
}

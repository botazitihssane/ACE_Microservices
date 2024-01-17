package ma.emsi.model;

import java.time.LocalDate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "Article")
public class Article {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotBlank(message = "Titre ne peut pas etre vide")
	private String titre;

	@Column(columnDefinition = "TEXT")
	@NotBlank(message = "Texte ne peut pas etre vide")
	private String texte;

	private String photo;

	private String lien;

	@NotNull(message = "Date ne peut pas etre vide")
	private LocalDate date;

	@Min(value = 0, message = "Nombre de commentaire ne peut pas etre négatif")
	private int nombreCommentaire;

	@ManyToOne
	private Categorie categorie;

	public Article(int id, @NotBlank(message = "Titre ne peut pas etre vide") String titre,
			@NotBlank(message = "Texte ne peut pas etre vide") String texte, String photo, String lien,
			@NotNull(message = "Date ne peut pas etre vide") LocalDate date,
			@Min(value = 0, message = "Nombre de commentaire ne peut pas etre négatif") int nombreCommentaire,
			@NotBlank(message = "Categorie ne peut pas etre vide") Categorie categorie) {
		super();
		this.id = id;
		this.titre = titre;
		this.texte = texte;
		this.photo = photo;
		this.lien = lien;
		this.date = date;
		this.nombreCommentaire = nombreCommentaire;
		this.categorie = categorie;
	}

	public Article() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Article(@NotBlank(message = "Titre ne peut pas etre vide") String titre,
			@NotBlank(message = "Texte ne peut pas etre vide") String texte, String photo, String lien,
			@NotNull(message = "Date ne peut pas etre vide") LocalDate date,
			@Min(value = 0, message = "Nombre de commentaire ne peut pas etre négatif") int nombreCommentaire,
			@NotBlank(message = "Categorie ne peut pas etre vide") Categorie categorie) {
		super();
		this.titre = titre;
		this.texte = texte;
		this.photo = photo;
		this.lien = lien;
		this.date = date;
		this.nombreCommentaire = nombreCommentaire;
		this.categorie = categorie;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getTexte() {
		return texte;
	}

	public void setTexte(String texte) {
		this.texte = texte;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getLien() {
		return lien;
	}

	public void setLien(String lien) {
		this.lien = lien;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public int getNombreCommentaire() {
		return nombreCommentaire;
	}

	public void setNombreCommentaire(int nombreCommentaire) {
		this.nombreCommentaire = nombreCommentaire;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

}

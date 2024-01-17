package ma.emsi.model;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "Commentaire")
public class Commentaire {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotBlank(message = "Texte ne peut pas etre vide")
	private String texte;

	private LocalDate date;

	@ManyToOne
	@JoinColumn(name = "article_id")
	@NotNull(message = "Article ne peut pas etre vide")
	private Article article;

	@ManyToOne
	@JoinColumn(name = "commentaire_parent_id")
	private Commentaire commentaireParent;

	private int visiteur_id;

	private int proprietaire_id;

	@Transient
	@ManyToOne(cascade = CascadeType.ALL)
	private Visiteur visiteur;

	@Transient
	@ManyToOne(cascade = CascadeType.ALL)
	private Proprietaire proprietaire;

	public Commentaire(int id, @NotBlank(message = "Texte ne peut pas etre vide") String texte, LocalDate date,
			@NotBlank(message = "Article ne peut pas etre vide") Article article, Commentaire commentaireParent,
			int visiteur_id, int proprietaire_id) {
		super();
		this.id = id;
		this.texte = texte;
		this.date = date;
		this.article = article;
		this.commentaireParent = commentaireParent;
		this.visiteur_id = visiteur_id;
		this.proprietaire_id = proprietaire_id;
	}

	public Commentaire() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Commentaire(@NotBlank(message = "Texte ne peut pas etre vide") String texte, LocalDate date,
			@NotBlank(message = "Article ne peut pas etre vide") Article article, Commentaire commentaireParent,
			int visiteur_id, int proprietaire_id) {
		super();
		this.texte = texte;
		this.date = date;
		this.article = article;
		this.commentaireParent = commentaireParent;
		this.visiteur_id = visiteur_id;
		this.proprietaire_id = proprietaire_id;
	}

	public Commentaire(int id, @NotBlank(message = "Texte ne peut pas etre vide") String texte, LocalDate date,
			@NotBlank(message = "Article ne peut pas etre vide") Article article, Commentaire commentaireParent,
			int visiteur_id, int proprietaire_id, Visiteur visiteur, Proprietaire proprietaire) {
		super();
		this.id = id;
		this.texte = texte;
		this.date = date;
		this.article = article;
		this.commentaireParent = commentaireParent;
		this.visiteur_id = visiteur_id;
		this.proprietaire_id = proprietaire_id;
		this.visiteur = visiteur;
		this.proprietaire = proprietaire;
	}

	public Visiteur getVisiteur() {
		return visiteur;
	}

	public void setVisiteur(Visiteur visiteur) {
		this.visiteur = visiteur;
	}

	public Proprietaire getProprietaire() {
		return proprietaire;
	}

	public void setProprietaire(Proprietaire proprietaire) {
		this.proprietaire = proprietaire;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTexte() {
		return texte;
	}

	public void setTexte(String texte) {
		this.texte = texte;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public Commentaire getCommentaireParent() {
		return commentaireParent;
	}

	public void setCommentaireParent(Commentaire commentaireParent) {
		this.commentaireParent = commentaireParent;
	}

	public int getVisiteur_id() {
		return visiteur_id;
	}

	public void setVisiteur_id(int visiteur_id) {
		this.visiteur_id = visiteur_id;
	}

	public int getProprietaire_id() {
		return proprietaire_id;
	}

	public void setProprietaire_id(int proprietaire_id) {
		this.proprietaire_id = proprietaire_id;
	}

}

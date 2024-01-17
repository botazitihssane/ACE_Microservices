package ma.emsi.model;

public class Visiteur {
	private int id;
	private String email;
	private String nom;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Visiteur(int id, String email, String nom) {
		super();
		this.id = id;
		this.email = email;
		this.nom = nom;
	}

	public Visiteur(String email, String nom) {
		super();
		this.email = email;
		this.nom = nom;
	}

	public Visiteur() {
		super();
		// TODO Auto-generated constructor stub
	}

}

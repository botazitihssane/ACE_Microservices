package ma.emsi.model;

public class Proprietaire {
	private int id;
	private String email;
	private String usernamae;
	private String password;
	private String photo;
	private String biographie;

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

	public String getUsernamae() {
		return usernamae;
	}

	public void setUsernamae(String usernamae) {
		this.usernamae = usernamae;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getBiographie() {
		return biographie;
	}

	public void setBiographie(String biographie) {
		this.biographie = biographie;
	}

	public Proprietaire(int id, String email, String usernamae, String password, String photo, String biographie) {
		super();
		this.id = id;
		this.email = email;
		this.usernamae = usernamae;
		this.password = password;
		this.photo = photo;
		this.biographie = biographie;
	}

	public Proprietaire(String email, String usernamae, String password, String photo, String biographie) {
		super();
		this.email = email;
		this.usernamae = usernamae;
		this.password = password;
		this.photo = photo;
		this.biographie = biographie;
	}

	public Proprietaire() {
		super();
		// TODO Auto-generated constructor stub
	}

}

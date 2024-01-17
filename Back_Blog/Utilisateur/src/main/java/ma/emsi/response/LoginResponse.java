package ma.emsi.response;

public class LoginResponse {
	private boolean success;
	private int id;
	private String email;

	public LoginResponse(int id, String email) {
		super();
		this.success = true;
		this.id = id;
		this.email = email;
	}

	public boolean isSuccess() {
		return success;
	}

	public LoginResponse() {
		super();
	}

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

}

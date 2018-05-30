package dto;

public class User {

	private String userId;
	private String password;
	private String userName;

	public User(String userId, String password, String userName) {
		this.userId = userId;
		this.password = password;
		this.userName = userName;
	}

	public String getUserId() {
		return this.userId;
	}

	public String getUserName() {
		return this.userName;
	}

	public boolean equalsPassword(String password) {
		return this.password.equals(password);
	}
}

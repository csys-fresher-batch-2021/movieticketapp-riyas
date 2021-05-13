package in.riyasahamed.model;

public class Admin {

	private String userName;
	
	private String password;

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}
	
	public Admin() {
		this.userName="admin";
		this.password="Admin@12";
	}

	@Override
	public String toString() {
		return "Admin [userName=" + userName + ", password=" + password + "]";
	}
}

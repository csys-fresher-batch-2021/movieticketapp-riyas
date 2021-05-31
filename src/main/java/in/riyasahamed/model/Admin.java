package in.riyasahamed.model;

public class Admin {
	
	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	private String userName;
	
	private String password;

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}
	
	public Admin() {
		//Default Constructor
	}

	@Override
	public String toString() {
		return "Admin [id=" + id + ", userName=" + userName + ", password=" + password + "]";
	}
}

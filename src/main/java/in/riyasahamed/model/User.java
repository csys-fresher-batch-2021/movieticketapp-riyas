package in.riyasahamed.model;

public class User {

	private String name;

	public String getName() {
		return name;
	}

	private String userName;

	public String getUserName() {
		return userName;
	}

	private String password;

	public String getPassword() {
		return password;
	}

	private Long mobileNumber;

	public Long getMobileNumber() {
		return mobileNumber;
	}

	private String email;

	public String getGender() {
		return email;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public User(String name, String userName, String password, Long mobileNumber, String email) {
		this.name = name;
		this.userName = userName;
		this.password = password;
		this.mobileNumber = mobileNumber;
		this.email = email;
	}

	public User() {
		//Default Constructor
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", userName=" + userName + ", password=" + password + ", mobileNumber="
				+ mobileNumber + ", gender=" + email + "]";
	}

	public String getEmail() {
		return email;
	}

	

}

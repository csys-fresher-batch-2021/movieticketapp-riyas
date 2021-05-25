package in.riyasahamed.dto;


public class UserDTO {
	
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
	
	private Integer userId;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	private String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
	
	private static final UserDTO instance = new UserDTO();

	// This Method returns the object which can be used for access methods in DAO
	public static UserDTO getInstance() {
		return instance;
	}

}

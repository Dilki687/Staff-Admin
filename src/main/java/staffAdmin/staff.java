package staffAdmin;

public class staff {
	private int empID;
	private String username;
	private String password;
	private String post;
	private String phoneNumber;
	private String gender;
	private String email;
	
	public staff(int empID, String username, String password, String post, String phoneNumber, String gender,String email) {
		this.empID = empID;
		this.username = username;
		this.password = password;
		this.post = post;
		this.phoneNumber = phoneNumber;
		this.gender = gender;
		this.email = email;
	}
	
	public int getEmpID() {
		return empID;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getPost() {
		return post;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getGender() {
		return gender;
	}

	public String getEmail() {
		return email;
	}
}

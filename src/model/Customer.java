package model;

public class Customer {
	private int id;
//	private String user_type;
	private String username;
	private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String address;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
		public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customer(int id,   String firstName, String lastName,
			String email, String phone, String address,String username, String password) {
		super();
		this.id = id;
		
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.username = username;
		this.password = password;
	}
    
	
    
}

package entity.person;

public class Customer extends Person {
	private int id;
	private String phoneNum;
	private String email;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Customer(int id, String phoneNum, String email) {
		super();
		this.id = id;
		this.phoneNum = phoneNum;
		this.email = email;
	}

	public Customer() {
		super();
	}

}

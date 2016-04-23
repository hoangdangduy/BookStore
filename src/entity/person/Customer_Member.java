package entity.person;

import entity.bank.Kcoin_Bank;

public class Customer_Member extends Customer {
	private int id;
	private String username;
	private String password;
	private Kcoin_Bank coinBank;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Kcoin_Bank getCoinBank() {
		return coinBank;
	}

	public void setCoinBank(Kcoin_Bank coinBank) {
		this.coinBank = coinBank;
	}

	public Customer_Member(int id, String phoneNum, String email, int id2, String username, String password,
			Kcoin_Bank coinBank) {
		super(id, phoneNum, email);
		id = id2;
		this.username = username;
		this.password = password;
		this.coinBank = coinBank;
	}

	
	
	public Customer_Member() {
		super();
	}

	public Customer_Member(int id, String phoneNum, String email) {
		super(id, phoneNum, email);
	}

}

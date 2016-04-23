package entity.person;

public class Person {
	private int id;
	private Address address;
	private FullName full_name;
	private String path;

	
	
	public String getPath() {
		return "path - chua biet, check lai y nghia";
	}

	public void setPath(String path) {
		this.path = path;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public FullName getFull_name() {
		return full_name;
	}

	public void setFull_name(FullName full_name) {
		this.full_name = full_name;
	}

	
	
	public Person() {
		super();
	}

	public Person(int id, Address address, FullName full_name, String path) {
		super();
		this.id = id;
		this.address = address;
		this.full_name = full_name;
		this.path = path;
	}
	
	

}

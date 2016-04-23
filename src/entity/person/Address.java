package entity.person;

public class Address {
	private int id;
	private String num;
	private String ward;
	private String district;
	private String city;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getWard() {
		return ward;
	}

	public void setWard(String ward) {
		this.ward = ward;
	}

	public String getDistric() {
		return district;
	}

	public void setDistric(String district) {
		this.district = district;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Address(int id, String num, String ward, String district, String city) {
		super();
		this.id = id;
		this.num = num;
		this.ward = ward;
		this.district = district;
		this.city = city;
	}

	public Address() {
		super();
	}

}

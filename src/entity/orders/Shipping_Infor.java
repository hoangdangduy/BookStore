package entity.orders;

import entity.person.Customer;

public class Shipping_Infor {
	private Customer customer;
	private Address_shipping address;

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Address_shipping getAddress() {
		return address;
	}

	public void setAddress(Address_shipping address) {
		this.address = address;
	}

}

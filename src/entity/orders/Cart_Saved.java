package entity.orders;

import entity.person.Customer_Member;

public class Cart_Saved {
	private Cart cart;
	private float totalPrice;
	private Customer_Member customer;

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Customer_Member getCustomer() {
		return customer;
	}

	public void setCustomer(Customer_Member customer) {
		this.customer = customer;
	}

}

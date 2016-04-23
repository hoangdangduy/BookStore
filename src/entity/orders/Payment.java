package entity.orders;

import entity.bank.Bank;

public class Payment {
	private Bank bank;
	private Cart cart;

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

}

package entity.orders;

import entity.book.Book;

public class Book_Order {
	private int quantity;
	private float totalPrice;
	private Book book;

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Book_Order(int quantity, float totalPrice, Book book) {
		super();
		this.quantity = quantity;
		this.totalPrice = totalPrice;
		this.book = book;
	}

	public Book_Order() {
		super();
	}

}

package entity.orders;

import java.util.ArrayList;

public class Cart {
	private ArrayList<Book_Order> list;
	private float totalPrice;

	public ArrayList<Book_Order> getList() {
		return list;
	}

	public void setList(ArrayList<Book_Order> list) {
		this.list = list;
	}

	public float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}

}

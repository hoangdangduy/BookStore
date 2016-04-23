package entity.bill;

import java.sql.Date;

import entity.orders.Orders;
import entity.person.Seller;

public class Bill {
	private Date date;
	private Orders order;
	private Seller seller;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Orders getOrder() {
		return order;
	}

	public void setOrder(Orders order) {
		this.order = order;
	}

	public Seller getSeller() {
		return seller;
	}

	public void setSeller(Seller seller) {
		this.seller = seller;
	}

}

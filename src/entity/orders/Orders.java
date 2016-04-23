package entity.orders;

import java.sql.Date;

public class Orders {
	private Shipping_Infor shipping;
	private Payment payment;
	private Date date;

	public Shipping_Infor getShipping() {
		return shipping;
	}

	public void setShipping(Shipping_Infor shipping) {
		this.shipping = shipping;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}

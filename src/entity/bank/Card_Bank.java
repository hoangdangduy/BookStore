package entity.bank;

import java.sql.Date;

public class Card_Bank extends Bank {
	private String cardType;
	private String nameOwner;
	private String numCard;
	private Date dateReissue;

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getNameOwner() {
		return nameOwner;
	}

	public void setNameOwner(String nameOwner) {
		this.nameOwner = nameOwner;
	}

	public String getNumCard() {
		return numCard;
	}

	public void setNumCard(String numCard) {
		this.numCard = numCard;
	}

	public Date getDateReissue() {
		return dateReissue;
	}

	public void setDateReissue(Date dateReissue) {
		this.dateReissue = dateReissue;
	}

}

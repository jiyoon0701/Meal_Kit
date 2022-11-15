package dto;

import java.util.Date;

public class ItemPurchase {
	private int itemCode;
	private String email;
	public int getItemCode() {
		return itemCode;
	}
	public void setItemCode(int itemCode) {
		this.itemCode = itemCode;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	private Date date;
	private int quantity;
	@Override
	public String toString() {
		return "ItemPurchase [itemCode=" + itemCode + ", email=" + email + ", date=" + date + ", quantity=" + quantity
				+ ", getItemCode()=" + getItemCode() + ", getEmail()=" + getEmail() + ", getDate()=" + getDate()
				+ ", getQuantity()=" + getQuantity() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

}
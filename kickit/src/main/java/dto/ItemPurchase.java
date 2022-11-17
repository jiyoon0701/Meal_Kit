package dto;

import java.sql.Date;

public class ItemPurchase{
	private int id;
	private int itemCode;
	private String email;
	private Date date;
	private int quantity;
	private String item;
	private int price;
	private String file_name;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getFile_name() {
		return file_name;
	}
	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}
	
	@Override
	public String toString() {
		return "{'itemCode':'" + itemCode + "', 'email':'" + email + "', 'date':'" + date + "', 'quantity':'" + quantity
				+ "', 'item':'" + item + "', 'price':'" + price + "', 'file_name':'" + file_name + "'}";
	}

}
package dto;

public class CartList {
	private int id;
	private int itemCode;
	private String email;
	private int quantity;
	private String item;
	private int price;
	private String content;
	private String file_name;
	private String catogory;
	
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getFile_name() {
		return file_name;
	}
	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}
	public String getCatogory() {
		return catogory;
	}
	public void setCatogory(String catogory) {
		this.catogory = catogory;
	}
	@Override
	public String toString() {
		return "CartList [id=" + id + ", itemCode=" + itemCode + ", email=" + email + ", quantity=" + quantity
				+ ", item=" + item + ", price=" + price + ", content=" + content + ", file_name=" + file_name
				+ ", catogory=" + catogory + "]";
	}

	
}
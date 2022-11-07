package dto;

public class Item {
	
	// 아이템이름 
	private String item;
	
	// 아이템 가격
	private int price;
	
	// 아이템 내용
	private String content;
	
	// 아이템 재고수
	private int quantity;
	
	// 아이템 카테고리
	private String category;
	
	// 아이템 추천수
	private int recommend;
	
	// 아이템 구매수
	private int buy;
	
	//아이템 별점
	private float star;
	
	
	
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
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getRecommend() {
		return recommend;
	}
	public void setRecommend(int recommend) {
		this.recommend = recommend;
	}
	public int getBuy() {
		return buy;
	}
	public void setBuy(int buy) {
		this.buy = buy;
	}
	public float getStar() {
		return star;
	}
	public void setStar(float star) {
		this.star = star;
	}
	
	@Override
	public String toString() {
		return "itme = [ itme = " + item + ", price = " + price + ", content = " + content
				+ ", quantity = " + quantity + ", category = " + category + ", recommend ="
				+ recommend + ", buy = " + buy + ", star = " + star;
	}
	

	
}

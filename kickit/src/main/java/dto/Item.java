package dto;

import org.springframework.web.multipart.MultipartFile;

public class Item {
	
		private int itemCode;
	   private String item;
	   private int price;
	   private String content;
	   private String fileName;
	   private int quantity;
	   private String category;
	   private int recommend;
	   private int buy;
	   private float star;
	   private MultipartFile uploadFile;

		public MultipartFile getUploadFile() {
			return uploadFile;
		}
		
	
		public void setUploadFile(MultipartFile uploadFile) {
			this.uploadFile = uploadFile;
		}
		public String getFileName() {
			return fileName;
	   }
	
		public void setFileName(String fileName) {
			this.fileName = fileName;
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

	   public int getItemCode() {
	      return itemCode;
	   }

	   public void setItemCode(int itemCode) {
	      this.itemCode = itemCode;
	   }


	@Override
	public String toString() {
		return "Item [itemCode=" + itemCode + ", item=" + item + ", price=" + price + ", content=" + content
				+ ", fileName=" + fileName + ", quantity=" + quantity + ", category=" + category + ", recommend="
				+ recommend + ", buy=" + buy + ", star=" + star + ", uploadFile=" + uploadFile + "]";
	}

	

	
}

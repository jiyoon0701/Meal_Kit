package dto;

import java.sql.Blob;
import java.util.Date;

public class Review {
	
	private int id;
	private Date date;
	private String picture; 
	private String content;
	private float star;
	private int itemCode;
	private String item;
	private String title;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
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
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	@Override
	public String toString() {
		return "Review [id=" + id + ", date=" + date + ", picture=" + picture + ", content=" + content + ", star="
				+ star + ", itemCode=" + itemCode + ", item=" + item + ", title=" + title + "]";
	}
	
}

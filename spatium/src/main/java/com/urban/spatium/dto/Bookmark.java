package com.urban.spatium.dto;

public class Bookmark {
	private int bookMarkCode;
	private String userId;
	private int storeCode;
	private String bookRegDate;
	
	private User user;
	
	public int getBookMarkCode() {
		return bookMarkCode;
	}
	public void setBookMarkCode(int bookMarkCode) {
		this.bookMarkCode = bookMarkCode;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getStoreCode() {
		return storeCode;
	}
	public void setStoreCode(int storeCode) {
		this.storeCode = storeCode;
	}
	public String getBookRegDate() {
		return bookRegDate;
	}
	public void setBookRegDate(String bookRegDate) {
		this.bookRegDate = bookRegDate;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Bookmark [bookMarkCode=");
		builder.append(bookMarkCode);
		builder.append(", userId=");
		builder.append(userId);
		builder.append(", storeCode=");
		builder.append(storeCode);
		builder.append(", bookRegDate=");
		builder.append(bookRegDate);
		builder.append(", user=");
		builder.append(user);
		builder.append("]");
		return builder.toString();
	}
	
}

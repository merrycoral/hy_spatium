package com.urban.spatium.dto;

public class Bookmark {
	private int bookMarkCode;
	private String userId;
	private int storeCode;
	private String bookRegDate;
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
	@Override
	public String toString() {
		return "Bookmark [bookMarkCode=" + bookMarkCode + ", userId=" + userId + ", storeCode=" + storeCode
				+ ", bookRegDate=" + bookRegDate + "]";
	}
	
}

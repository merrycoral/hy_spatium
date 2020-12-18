package com.urban.spatium.dto;

public class item {
	private int itemCode;
	private int storeTotalCode;
	private String itemTotalName;
	private int itemTotalAmount;
	private int itemRentalAmount;
	private int itemRentalPrice;
	private int itemRentalDeposit;
	private String itemImg;
	private String itemRegDate;
	private String itemChangeRegDate;
	private String itemTotalUserId;
	public int getItemCode() {
		return itemCode;
	}
	public void setItemCode(int itemCode) {
		this.itemCode = itemCode;
	}
	public int getStoreTotalCode() {
		return storeTotalCode;
	}
	public void setStoreTotalCode(int storeTotalCode) {
		this.storeTotalCode = storeTotalCode;
	}
	public String getItemTotalName() {
		return itemTotalName;
	}
	public void setItemTotalName(String itemTotalName) {
		this.itemTotalName = itemTotalName;
	}
	public int getItemTotalAmount() {
		return itemTotalAmount;
	}
	public void setItemTotalAmount(int itemTotalAmount) {
		this.itemTotalAmount = itemTotalAmount;
	}
	public int getItemRentalAmount() {
		return itemRentalAmount;
	}
	public void setItemRentalAmount(int itemRentalAmount) {
		this.itemRentalAmount = itemRentalAmount;
	}
	public int getItemRentalPrice() {
		return itemRentalPrice;
	}
	public void setItemRentalPrice(int itemRentalPrice) {
		this.itemRentalPrice = itemRentalPrice;
	}
	public int getItemRentalDeposit() {
		return itemRentalDeposit;
	}
	public void setItemRentalDeposit(int itemRentalDeposit) {
		this.itemRentalDeposit = itemRentalDeposit;
	}
	public String getItemImg() {
		return itemImg;
	}
	public void setItemImg(String itemImg) {
		this.itemImg = itemImg;
	}
	public String getItemRegDate() {
		return itemRegDate;
	}
	public void setItemRegDate(String itemRegDate) {
		this.itemRegDate = itemRegDate;
	}
	public String getItemChangeRegDate() {
		return itemChangeRegDate;
	}
	public void setItemChangeRegDate(String itemChangeRegDate) {
		this.itemChangeRegDate = itemChangeRegDate;
	}
	public String getItemTotalUserId() {
		return itemTotalUserId;
	}
	public void setItemTotalUserId(String itemTotalUserId) {
		this.itemTotalUserId = itemTotalUserId;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Item [itemCode=");
		builder.append(itemCode);
		builder.append(", storeTotalCode=");
		builder.append(storeTotalCode);
		builder.append(", itemTotalName=");
		builder.append(itemTotalName);
		builder.append(", itemTotalAmount=");
		builder.append(itemTotalAmount);
		builder.append(", itemRentalAmount=");
		builder.append(itemRentalAmount);
		builder.append(", itemRentalPrice=");
		builder.append(itemRentalPrice);
		builder.append(", itemRentalDeposit=");
		builder.append(itemRentalDeposit);
		builder.append(", itemImg=");
		builder.append(itemImg);
		builder.append(", itemRegDate=");
		builder.append(itemRegDate);
		builder.append(", itemChangeRegDate=");
		builder.append(itemChangeRegDate);
		builder.append(", itemTotalUserId=");
		builder.append(itemTotalUserId);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}

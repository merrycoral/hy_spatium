package com.urban.spatium.dto;

public class Item {
	private int itemCode;
	private int storeTotalCode;
	private String itemTotalName;
	private int itemTotalAmount;
	private int itemRentalPrice;
	private int itemRentalDeposit;
	private String itemImg;
	private String itemRegDate;
	private String itemChangeRegDate;
	private String itemTotalUserId;
	
	private int storeItemCode;
	private int itemDetailCode;
	private int storeDetailCode;
	private String itemName;
	private String itemCategory;
	private String itemDetail;
	private String itemStatus;
	private String itemRentalStatus;
	private String itemDetailUserId;
	
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
	public int getStoreItemCode() {
		return storeItemCode;
	}
	public void setStoreItemCode(int storeItemCode) {
		this.storeItemCode = storeItemCode;
	}
	public int getItemDetailCode() {
		return itemDetailCode;
	}
	public void setItemDetailCode(int itemDetailCode) {
		this.itemDetailCode = itemDetailCode;
	}
	public int getStoreDetailCode() {
		return storeDetailCode;
	}
	public void setStoreDetailCode(int storeDetailCode) {
		this.storeDetailCode = storeDetailCode;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemCategory() {
		return itemCategory;
	}
	public void setItemCategory(String itemCategory) {
		this.itemCategory = itemCategory;
	}
	public String getItemDetail() {
		return itemDetail;
	}
	public void setItemDetail(String itemDetail) {
		this.itemDetail = itemDetail;
	}
	public String getItemStatus() {
		return itemStatus;
	}
	public void setItemStatus(String itemStatus) {
		this.itemStatus = itemStatus;
	}
	public String getItemRentalStatus() {
		return itemRentalStatus;
	}
	public void setItemRentalStatus(String itemRentalStatus) {
		this.itemRentalStatus = itemRentalStatus;
	}
	public String getItemDetailUserId() {
		return itemDetailUserId;
	}
	public void setItemDetailUserId(String itemDetailUserId) {
		this.itemDetailUserId = itemDetailUserId;
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
		builder.append(", storeItemCode=");
		builder.append(storeItemCode);
		builder.append(", itemDetailCode=");
		builder.append(itemDetailCode);
		builder.append(", storeDetailCode=");
		builder.append(storeDetailCode);
		builder.append(", itemName=");
		builder.append(itemName);
		builder.append(", itemCategory=");
		builder.append(itemCategory);
		builder.append(", itemDetail=");
		builder.append(itemDetail);
		builder.append(", itemStatus=");
		builder.append(itemStatus);
		builder.append(", itemRentalStatus=");
		builder.append(itemRentalStatus);
		builder.append(", itemDetailUserId=");
		builder.append(itemDetailUserId);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}

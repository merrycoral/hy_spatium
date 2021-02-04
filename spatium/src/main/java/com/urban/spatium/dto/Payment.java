package com.urban.spatium.dto;

import java.util.List;

public class Payment {
	private int paymentCode;
	private int paymentRsvCode;
	private int paymentPrice;
	private int paymentUsePoint;
	private int paymentUseMoney;
	private int paymentAddPoint;
	private int paymentStoreCode;
	private int paymentRefund;
	private String paymentRegDate;
	private String paymentMethod;
	private String paymentIP;
	private String paymentStoreId;
	private List<Rsv> RsvList;
	
	
	private int rsvCode;
	private int rsvDetailCode;
	private String rsvDetailSpace;
	private int okayStoreCode;
	private String okaySpaceType;
	private String okaySpaceName;
	private int rsvDetailItem;
	private String itemTotalName;
	private int rsvDetailNum;
	private int rsvDetailOnePrice;
	private String rsvState;
	private String rsvStartDateTime;
	
	
	public String getRsvStartDateTime() {
		return rsvStartDateTime;
	}
	public void setRsvStartDateTime(String rsvStartDateTime) {
		this.rsvStartDateTime = rsvStartDateTime;
	}
	public String getPaymentStoreId() {
		return paymentStoreId;
	}
	public void setPaymentStoreId(String paymentStoreId) {
		this.paymentStoreId = paymentStoreId;
	}
	public int getPaymentRefund() {
		return paymentRefund;
	}
	public void setPaymentRefund(int paymentRefund) {
		this.paymentRefund = paymentRefund;
	}
	public int getPaymentStoreCode() {
		return paymentStoreCode;
	}
	public void setPaymentStoreCode(int paymentStoreCode) {
		this.paymentStoreCode = paymentStoreCode;
	}
	public int getRsvCode() {
		return rsvCode;
	}
	public void setRsvCode(int rsvCode) {
		this.rsvCode = rsvCode;
	}
	public String getRsvState() {
		return rsvState;
	}
	public void setRsvState(String rsvState) {
		this.rsvState = rsvState;
	}
	public int getRsvDetailCode() {
		return rsvDetailCode;
	}
	public void setRsvDetailCode(int rsvDetailCode) {
		this.rsvDetailCode = rsvDetailCode;
	}
	public String getRsvDetailSpace() {
		return rsvDetailSpace;
	}
	public void setRsvDetailSpace(String rsvDetailSpace) {
		this.rsvDetailSpace = rsvDetailSpace;
	}
	public int getOkayStoreCode() {
		return okayStoreCode;
	}
	public void setOkayStoreCode(int okayStoreCode) {
		this.okayStoreCode = okayStoreCode;
	}
	public String getOkaySpaceType() {
		return okaySpaceType;
	}
	public void setOkaySpaceType(String okaySpaceType) {
		this.okaySpaceType = okaySpaceType;
	}
	public String getOkaySpaceName() {
		return okaySpaceName;
	}
	public void setOkaySpaceName(String okaySpaceName) {
		this.okaySpaceName = okaySpaceName;
	}
	public int getRsvDetailItem() {
		return rsvDetailItem;
	}
	public void setRsvDetailItem(int rsvDetailItem) {
		this.rsvDetailItem = rsvDetailItem;
	}
	public String getItemTotalName() {
		return itemTotalName;
	}
	public void setItemTotalName(String itemTotalName) {
		this.itemTotalName = itemTotalName;
	}
	public int getRsvDetailNum() {
		return rsvDetailNum;
	}
	public void setRsvDetailNum(int rsvDetailNum) {
		this.rsvDetailNum = rsvDetailNum;
	}
	public int getRsvDetailOnePrice() {
		return rsvDetailOnePrice;
	}
	public void setRsvDetailOnePrice(int rsvDetailOnePrice) {
		this.rsvDetailOnePrice = rsvDetailOnePrice;
	}
	public List<Rsv> getRsvList() {
		return RsvList;
	}
	public void setRsvList(List<Rsv> rsvList) {
		RsvList = rsvList;
	}
	public String getPaymentRegDate() {
		return paymentRegDate;
	}
	public void setPaymentRegDate(String paymentRegDate) {
		this.paymentRegDate = paymentRegDate;
	}
	public String getPaymentIP() {
		return paymentIP;
	}
	public void setPaymentIP(String paymentIP) {
		this.paymentIP = paymentIP;
	}
	public int getPaymentRsvCode() {
		return paymentRsvCode;
	}
	public void setPaymentRsvCode(int paymentRsvCode) {
		this.paymentRsvCode = paymentRsvCode;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public int getPaymentCode() {
		return paymentCode;
	}
	public void setPaymentCode(int paymentCode) {
		this.paymentCode = paymentCode;
	}
	public int getPaymentPrice() {
		return paymentPrice;
	}
	public void setPaymentPrice(int paymentPrice) {
		this.paymentPrice = paymentPrice;
	}
	public int getPaymentUsePoint() {
		return paymentUsePoint;
	}
	public void setPaymentUsePoint(int paymentUsePoint) {
		this.paymentUsePoint = paymentUsePoint;
	}
	public int getPaymentUseMoney() {
		return paymentUseMoney;
	}
	public void setPaymentUseMoney(int paymentUseMoney) {
		this.paymentUseMoney = paymentUseMoney;
	}
	public int getPaymentAddPoint() {
		return paymentAddPoint;
	}
	public void setPaymentAddPoint(int paymentAddPoint) {
		this.paymentAddPoint = paymentAddPoint;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Payment [paymentCode=");
		builder.append(paymentCode);
		builder.append(", paymentRsvCode=");
		builder.append(paymentRsvCode);
		builder.append(", paymentPrice=");
		builder.append(paymentPrice);
		builder.append(", paymentUsePoint=");
		builder.append(paymentUsePoint);
		builder.append(", paymentUseMoney=");
		builder.append(paymentUseMoney);
		builder.append(", paymentAddPoint=");
		builder.append(paymentAddPoint);
		builder.append(", paymentStoreCode=");
		builder.append(paymentStoreCode);
		builder.append(", paymentRefund=");
		builder.append(paymentRefund);
		builder.append(", paymentRegDate=");
		builder.append(paymentRegDate);
		builder.append(", paymentMethod=");
		builder.append(paymentMethod);
		builder.append(", paymentIP=");
		builder.append(paymentIP);
		builder.append(", paymentStoreId=");
		builder.append(paymentStoreId);
		builder.append(", RsvList=");
		builder.append(RsvList);
		builder.append(", rsvCode=");
		builder.append(rsvCode);
		builder.append(", rsvDetailCode=");
		builder.append(rsvDetailCode);
		builder.append(", rsvDetailSpace=");
		builder.append(rsvDetailSpace);
		builder.append(", okayStoreCode=");
		builder.append(okayStoreCode);
		builder.append(", okaySpaceType=");
		builder.append(okaySpaceType);
		builder.append(", okaySpaceName=");
		builder.append(okaySpaceName);
		builder.append(", rsvDetailItem=");
		builder.append(rsvDetailItem);
		builder.append(", itemTotalName=");
		builder.append(itemTotalName);
		builder.append(", rsvDetailNum=");
		builder.append(rsvDetailNum);
		builder.append(", rsvDetailOnePrice=");
		builder.append(rsvDetailOnePrice);
		builder.append(", rsvState=");
		builder.append(rsvState);
		builder.append(", rsvStartDateTime=");
		builder.append(rsvStartDateTime);
		builder.append("]");
		return builder.toString();
	}
	
}

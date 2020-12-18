package com.urban.spatium.dto;

public class Payment {
	private int paymentCode;
	private int paymentRsvCode;
	private int paymentPrice;
	private int paymentUsePoint;
	private int paymentUseMoney;
	private int paymentAddPoint;
	private String paymentRegDate;
	private String paymentMethod;
	private String paymentIP;
	
	
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
		return "Payment [paymentCode=" + paymentCode + ", paymentRsvCode=" + paymentRsvCode + ", paymentPrice="
				+ paymentPrice + ", paymentUsePoint=" + paymentUsePoint + ", paymentUseMoney=" + paymentUseMoney
				+ ", paymentAddPoint=" + paymentAddPoint + ", paymentRegDate=" + paymentRegDate + ", paymentMethod="
				+ paymentMethod + ", paymentIP=" + paymentIP + "]";
	}
	
}

package com.urban.spatium.dto;

public class CalcWait {
	private int paymentCode;
	private int paymentRsvCode;
	private int paymentRefund;
	private int paymentUseMoney;
	private String paymentStatus;
	private String rsvEndDateTime;
	private String rsvState;
	
	@Override
	public String toString() {
		return "CalcWait [paymentCode=" + paymentCode + ", paymentRsvCode=" + paymentRsvCode + ", paymentRefund="
				+ paymentRefund + ", paymentUseMoney=" + paymentUseMoney + ", paymentStatus=" + paymentStatus
				+ ", rsvEndDateTime=" + rsvEndDateTime + ", rsvState=" + rsvState + "]";
	}
	
	public int getPaymentCode() {
		return paymentCode;
	}
	public void setPaymentCode(int paymentCode) {
		this.paymentCode = paymentCode;
	}
	public int getPaymentRsvCode() {
		return paymentRsvCode;
	}
	public void setPaymentRsvCode(int paymentRsvCode) {
		this.paymentRsvCode = paymentRsvCode;
	}
	public int getPaymentRefund() {
		return paymentRefund;
	}
	public void setPaymentRefund(int paymentRefund) {
		this.paymentRefund = paymentRefund;
	}
	public int getPaymentUseMoney() {
		return paymentUseMoney;
	}
	public void setPaymentUseMoney(int paymentUseMoney) {
		this.paymentUseMoney = paymentUseMoney;
	}
	public String getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	public String getRsvEndDateTime() {
		return rsvEndDateTime;
	}
	public void setRsvEndDateTime(String rsvEndDateTime) {
		this.rsvEndDateTime = rsvEndDateTime;
	}
	public String getRsvState() {
		return rsvState;
	}
	public void setRsvState(String rsvState) {
		this.rsvState = rsvState;
	}

}

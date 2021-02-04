package com.urban.spatium.dto;

public class CalcWait {
	private int paymentCode;
	private int paymentRsvCode;
	private int paymentRefund;
	private int paymentUseMoney;
	private int paymentUsePoint;
	private String paymentState;
	private String paymentStoreId;
	private String rsvState;
	private String rsvEndDateTime;
	private String rsvStartDateTime;
	
	
	@Override
	public String toString() {
		return "CalcWait [paymentCode=" + paymentCode + ", paymentRsvCode=" + paymentRsvCode + ", paymentRefund="
				+ paymentRefund + ", paymentUseMoney=" + paymentUseMoney + ", paymentUsePoint=" + paymentUsePoint
				+ ", paymentState=" + paymentState + ", paymentStoreId=" + paymentStoreId + ", rsvState=" + rsvState
				+ ", rsvEndDateTime=" + rsvEndDateTime + ", rsvStartDateTime=" + rsvStartDateTime + "]";
	}

	public int getPaymentUsePoint() {
		return paymentUsePoint;
	}
	
	public void setPaymentUsePoint(int paymentUsePoint) {
		this.paymentUsePoint = paymentUsePoint;
	}
	
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
	public String getPaymentState() {
		return paymentState;
	}
	public void setPaymentState(String paymentState) {
		this.paymentState = paymentState;
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

package com.urban.spatium.dto;

public class RefundPolicy {
	private int refundPolicyCode;
	private int refundPolicyStoreCode;
	private int remainingDay;
	private int refundPercent;
	private String refundPolicyUserId;
	private int refundPolicyRegDate;
	
	private String storeName;

	public int getRefundPolicyCode() {
		return refundPolicyCode;
	}

	public void setRefundPolicyCode(int refundPolicyCode) {
		this.refundPolicyCode = refundPolicyCode;
	}

	public int getRefundPolicyStoreCode() {
		return refundPolicyStoreCode;
	}

	public void setRefundPolicyStoreCode(int refundPolicyStoreCode) {
		this.refundPolicyStoreCode = refundPolicyStoreCode;
	}

	public int getRemainingDay() {
		return remainingDay;
	}

	public void setRemainingDay(int remainingDay) {
		this.remainingDay = remainingDay;
	}

	public int getRefundPercent() {
		return refundPercent;
	}

	public void setRefundPercent(int refundPercent) {
		this.refundPercent = refundPercent;
	}

	public String getRefundPolicyUserId() {
		return refundPolicyUserId;
	}

	public void setRefundPolicyUserId(String refundPolicyUserId) {
		this.refundPolicyUserId = refundPolicyUserId;
	}

	public int getRefundPolicyRegDate() {
		return refundPolicyRegDate;
	}

	public void setRefundPolicyRegDate(int refundPolicyRegDate) {
		this.refundPolicyRegDate = refundPolicyRegDate;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	@Override
	public String toString() {
		return "refundPolicy [refundPolicyCode=" + refundPolicyCode + ", refundPolicyStoreCode=" + refundPolicyStoreCode
				+ ", remainingDay=" + remainingDay + ", refundPercent=" + refundPercent + ", refundPolicyUserId="
				+ refundPolicyUserId + ", refundPolicyRegDate=" + refundPolicyRegDate + ", storeName=" + storeName
				+ "]";
	}
	
}

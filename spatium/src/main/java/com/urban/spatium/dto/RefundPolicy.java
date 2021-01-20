package com.urban.spatium.dto;

import java.util.List;

public class RefundPolicy {
	private int refundPolicyCode;
	private int refundPolicyStoreCode;
	private int remainingDay;
	private int refundPercent;
	private String refundPolicyUserId;
	private int refundPolicyRegDate;
	private String storeName;
	private CancelRsv cancelRsv;
	private List<RefundPolicy> refundPolicyList;
	
	
	

	public CancelRsv getCancelRsv() {
		return cancelRsv;
	}

	public void setCancelRsv(CancelRsv cancelRsv) {
		this.cancelRsv = cancelRsv;
	}

	public List<RefundPolicy> getRefundPolicyList() {
		return refundPolicyList;
	}

	public void setRefundPolicyList(List<RefundPolicy> refundPolicyList) {
		this.refundPolicyList = refundPolicyList;
	}

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
		StringBuilder builder = new StringBuilder();
		builder.append("RefundPolicy [refundPolicyCode=");
		builder.append(refundPolicyCode);
		builder.append(", refundPolicyStoreCode=");
		builder.append(refundPolicyStoreCode);
		builder.append(", remainingDay=");
		builder.append(remainingDay);
		builder.append(", refundPercent=");
		builder.append(refundPercent);
		builder.append(", refundPolicyUserId=");
		builder.append(refundPolicyUserId);
		builder.append(", refundPolicyRegDate=");
		builder.append(refundPolicyRegDate);
		builder.append(", storeName=");
		builder.append(storeName);
		builder.append(", cancelRsv=");
		builder.append(cancelRsv);
		builder.append(", refundPolicyList=");
		builder.append(refundPolicyList);
		builder.append("]");
		return builder.toString();
	}
	
}

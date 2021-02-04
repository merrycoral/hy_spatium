package com.urban.spatium.dto;

import java.util.List;

public class CancelRsv {
	private int cancelCode;
	private int cancelRsvCode;
	private String cancelUserId;
	private String cancelRegDate;
	private String cancelState;
	private String cancelConfirmDate;
	private String cancelReason;
	private int cancelRefundPolicyCode;
	private int cancelPrice;
	private List<RefundPolicy> refundPolicyList;
	
	public List<RefundPolicy> getRefundPolicyList() {
		return refundPolicyList;
	}
	public void setRefundPolicyList(List<RefundPolicy> refundPolicyList) {
		this.refundPolicyList = refundPolicyList;
	}
	public int getCancelCode() {
		return cancelCode;
	}
	public void setCancelCode(int cancelCode) {
		this.cancelCode = cancelCode;
	}
	public int getCancelRsvCode() {
		return cancelRsvCode;
	}
	public void setCancelRsvCode(int cancelRsvCode) {
		this.cancelRsvCode = cancelRsvCode;
	}
	public String getCancelUserId() {
		return cancelUserId;
	}
	public void setCancelUserId(String cancelUserId) {
		this.cancelUserId = cancelUserId;
	}
	public String getCancelRegDate() {
		return cancelRegDate;
	}
	public void setCancelRegDate(String cancelRegDate) {
		this.cancelRegDate = cancelRegDate;
	}
	public String getCancelState() {
		return cancelState;
	}
	public void setCancelState(String cancelState) {
		this.cancelState = cancelState;
	}
	public String getCancelConfirmDate() {
		return cancelConfirmDate;
	}
	public void setCancelConfirmDate(String cancelConfirmDate) {
		this.cancelConfirmDate = cancelConfirmDate;
	}
	public String getCancelReason() {
		return cancelReason;
	}
	public void setCancelReason(String cancelReason) {
		this.cancelReason = cancelReason;
	}
	public int getCancelRefundPolicyCode() {
		return cancelRefundPolicyCode;
	}
	public void setCancelRefundPolicyCode(int cancelRefundPolicyCode) {
		this.cancelRefundPolicyCode = cancelRefundPolicyCode;
	}
	public int getCancelPrice() {
		return cancelPrice;
	}
	public void setCancelPrice(int cancelPrice) {
		this.cancelPrice = cancelPrice;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CancelRsv [cancelCode=");
		builder.append(cancelCode);
		builder.append(", cancelRsvCode=");
		builder.append(cancelRsvCode);
		builder.append(", cancelUserId=");
		builder.append(cancelUserId);
		builder.append(", cancelRegDate=");
		builder.append(cancelRegDate);
		builder.append(", cancelState=");
		builder.append(cancelState);
		builder.append(", cancelConfirmDate=");
		builder.append(cancelConfirmDate);
		builder.append(", cancelReason=");
		builder.append(cancelReason);
		builder.append(", cancelRefundPolicyCode=");
		builder.append(cancelRefundPolicyCode);
		builder.append(", cancelPrice=");
		builder.append(cancelPrice);
		builder.append(", refundPolicyList=");
		builder.append(refundPolicyList);
		builder.append("]");
		return builder.toString();
	}
	
	
	


}

package com.urban.spatium.dto;

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
	
	
	public int getCancelPrice() {
		return cancelPrice;
	}
	public void setCancelPrice(int cancelPrice) {
		this.cancelPrice = cancelPrice;
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
	public int getcancelRefundPolicyCode() {
		return cancelRefundPolicyCode;
	}
	public void setcancelRefundPolicyCode(int cancelRefundPolicyCode) {
		this.cancelRefundPolicyCode = cancelRefundPolicyCode;
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
		builder.append(", refundPolicyCode=");
		builder.append(cancelRefundPolicyCode);
		builder.append(", cancelPrice=");
		builder.append(cancelPrice);
		builder.append("]");
		return builder.toString();
	}

}

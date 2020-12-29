package com.urban.spatium.dto;

public class CancelRsv {
	private int cancelCode;
	private int cancelRsvCode;
	private String cancelUserId;
	private String cancelRegDate;
	private String cancelState;
	private String cancelConfirmDate;
	private String cancelReason;
	private int cancelrefundPolicyCode;
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
	public int getCancelrefundPolicyCode() {
		return cancelrefundPolicyCode;
	}
	public void setCancelrefundPolicyCode(int cancelrefundPolicyCode) {
		this.cancelrefundPolicyCode = cancelrefundPolicyCode;
	}
	@Override
	public String toString() {
		return "CancelRsv [cancelCode=" + cancelCode + ", cancelRsvCode=" + cancelRsvCode + ", cancelUserId="
				+ cancelUserId + ", cancelRegDate=" + cancelRegDate + ", cancelState=" + cancelState
				+ ", cancelConfirmDate=" + cancelConfirmDate + ", cancelReason=" + cancelReason
				+ ", cancelrefundPolicyCode=" + cancelrefundPolicyCode + "]";
	}

}

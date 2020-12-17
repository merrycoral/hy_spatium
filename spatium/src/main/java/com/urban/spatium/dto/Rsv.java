package com.urban.spatium.dto;

public class Rsv {
	private int rsvCode;
	private String rsvUserId;
	private String rsvUserName;
	private String rsvUserPhone;
	private String rsvUserEmail;
	private String rsvUserRequest;
	private int rsvTotalPrice;
	private String rsvRegDate;
	private String rsvState;
	private String rsvDate;
	private String startTime;
	private String endTime;
	private String rsvStartDateTime;
	private String rsvEndDateTime;
	public String getRsvUserName() {
		return rsvUserName;
	}
	public void setRsvUserName(String rsvUserName) {
		this.rsvUserName = rsvUserName;
	}
	public int getRsvCode() {
		return rsvCode;
	}
	public void setRsvCode(int rsvCode) {
		this.rsvCode = rsvCode;
	}
	public String getRsvUserId() {
		return rsvUserId;
	}
	public void setRsvUserId(String rsvUserId) {
		this.rsvUserId = rsvUserId;
	}
	public String getRsvUserPhone() {
		return rsvUserPhone;
	}
	public void setRsvUserPhone(String rsvUserPhone) {
		this.rsvUserPhone = rsvUserPhone;
	}
	public String getRsvUserEmail() {
		return rsvUserEmail;
	}
	public void setRsvUserEmail(String rsvUserEmail) {
		this.rsvUserEmail = rsvUserEmail;
	}
	public String getRsvUserRequest() {
		return rsvUserRequest;
	}
	public void setRsvUserRequest(String rsvUserRequest) {
		this.rsvUserRequest = rsvUserRequest;
	}
	public int getRsvTotalPrice() {
		return rsvTotalPrice;
	}
	public void setRsvTotalPrice(int rsvTotalPrice) {
		this.rsvTotalPrice = rsvTotalPrice;
	}
	public String getRsvStartDateTime() {
		return rsvStartDateTime;
	}
	public void setRsvStartDateTime(String rsvStartDateTime) {
		this.rsvStartDateTime = rsvStartDateTime;
	}
	public String getRsvEndDateTime() {
		return rsvEndDateTime;
	}
	public void setRsvEndDateTime(String rsvEndDateTime) {
		this.rsvEndDateTime = rsvEndDateTime;
	}
	public String getRsvRegDate() {
		return rsvRegDate;
	}
	public void setRsvRegDate(String rsvRegDate) {
		this.rsvRegDate = rsvRegDate;
	}
	public String getRsvState() {
		return rsvState;
	}
	public void setRsvState(String rsvState) {
		this.rsvState = rsvState;
	}
	public String getRsvDate() {
		return rsvDate;
	}
	public void setRsvDate(String rsvDate) {
		this.rsvDate = rsvDate;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Rsv [rsvCode=");
		builder.append(rsvCode);
		builder.append(", rsvUserId=");
		builder.append(rsvUserId);
		builder.append(", rsvUserName=");
		builder.append(rsvUserName);
		builder.append(", rsvUserPhone=");
		builder.append(rsvUserPhone);
		builder.append(", rsvUserEmail=");
		builder.append(rsvUserEmail);
		builder.append(", rsvUserRequest=");
		builder.append(rsvUserRequest);
		builder.append(", rsvTotalPrice=");
		builder.append(rsvTotalPrice);
		builder.append(", rsvRegDate=");
		builder.append(rsvRegDate);
		builder.append(", rsvState=");
		builder.append(rsvState);
		builder.append(", rsvDate=");
		builder.append(rsvDate);
		builder.append(", startTime=");
		builder.append(startTime);
		builder.append(", endTime=");
		builder.append(endTime);
		builder.append(", rsvStartDateTime=");
		builder.append(rsvStartDateTime);
		builder.append(", rsvEndDateTime=");
		builder.append(rsvEndDateTime);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}

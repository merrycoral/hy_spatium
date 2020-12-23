package com.urban.spatium.dto;

import java.util.List;
import java.util.Map;

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
	private List<Map<String,Object>> itemList;
	private List<Map<String,Object>> spaceList;
	
	private int rsvDetailCode;
	private int rsvDetailSpace;
	private int rsvDetailSeat;
	private int rsvDetailItem;
	private int rsvDetailNum;
	private int rsvDetailOnePrice;
	private int rsvDetailTotalPrice;
	
	public List<Map<String, Object>> getSpaceList() {
		return spaceList;
	}
	public void setSpaceList(List<Map<String, Object>> spaceList) {
		this.spaceList = spaceList;
	}
	public List<Map<String, Object>> getItemList() {
		return itemList;
	}
	public void setItemList(List<Map<String, Object>> itemList) {
		this.itemList = itemList;
	}
	public int getRsvDetailCode() {
		return rsvDetailCode;
	}
	public void setRsvDetailCode(int rsvDetailCode) {
		this.rsvDetailCode = rsvDetailCode;
	}
	public int getRsvDetailSpace() {
		return rsvDetailSpace;
	}
	public void setRsvDetailSpace(int rsvDetailSpace) {
		this.rsvDetailSpace = rsvDetailSpace;
	}
	public int getRsvDetailSeat() {
		return rsvDetailSeat;
	}
	public void setRsvDetailSeat(int rsvDetailSeat) {
		this.rsvDetailSeat = rsvDetailSeat;
	}
	public int getRsvDetailItem() {
		return rsvDetailItem;
	}
	public void setRsvDetailItem(int rsvDetailItem) {
		this.rsvDetailItem = rsvDetailItem;
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
	public int getRsvDetailTotalPrice() {
		return rsvDetailTotalPrice;
	}
	public void setRsvDetailTotalPrice(int rsvDetailTotalPrice) {
		this.rsvDetailTotalPrice = rsvDetailTotalPrice;
	}
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
		builder.append(", itemList=");
		builder.append(itemList);
		builder.append(", spaceList=");
		builder.append(spaceList);
		builder.append(", rsvDetailCode=");
		builder.append(rsvDetailCode);
		builder.append(", rsvDetailSpace=");
		builder.append(rsvDetailSpace);
		builder.append(", rsvDetailSeat=");
		builder.append(rsvDetailSeat);
		builder.append(", rsvDetailItem=");
		builder.append(rsvDetailItem);
		builder.append(", rsvDetailNum=");
		builder.append(rsvDetailNum);
		builder.append(", rsvDetailOnePrice=");
		builder.append(rsvDetailOnePrice);
		builder.append(", rsvDetailTotalPrice=");
		builder.append(rsvDetailTotalPrice);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}

package com.urban.spatium.dto;

import java.util.List;
import java.util.Map;

public class Rsv {
	private int rsvCode;
	private String rsvUserId;
	private int rsvStoreCode;
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
	
	private String storeId;
	private String okaySpaceName;
	private String itemTotalName;
	private String rsvTime;
	private int rsvTimePrice;
	private int itemCode;
	private Payment payment;
	
	public String getStoreId() {
		return storeId;
	}
	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}
	public int getRsvStoreCode() {
		return rsvStoreCode;
	}
	public void setRsvStoreCode(int rsvStoreCode) {
		this.rsvStoreCode = rsvStoreCode;
	}
	public int getItemCode() {
		return itemCode;
	}
	public void setItemCode(int itemCode) {
		this.itemCode = itemCode;
	}
	public Payment getPayment() {
		return payment;
	}
	public void setPayment(Payment payment) {
		this.payment = payment;
}
	public int getRsvTimePrice() {
		return rsvTimePrice;
	}
	public void setRsvTimePrice(int rsvTimePrice) {
		this.rsvTimePrice = rsvTimePrice;
	}
	public String getRsvTime() {
		return rsvTime;
	}
	public void setRsvTime(String rsvTime) {
		this.rsvTime = rsvTime;
	}
	public String getOkaySpaceName() {
		return okaySpaceName;
	}
	public void setOkaySpaceName(String okaySpaceName) {
		this.okaySpaceName = okaySpaceName;
	}
	public String getItemTotalName() {
		return itemTotalName;
	}
	public void setItemTotalName(String itemTotalName) {
		this.itemTotalName = itemTotalName;
	}
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
		return "Rsv [rsvCode=" + rsvCode + ", rsvUserId=" + rsvUserId + ", rsvStoreCode=" + rsvStoreCode
				+ ", rsvUserName=" + rsvUserName + ", rsvUserPhone=" + rsvUserPhone + ", rsvUserEmail=" + rsvUserEmail
				+ ", rsvUserRequest=" + rsvUserRequest + ", rsvTotalPrice=" + rsvTotalPrice + ", rsvRegDate="
				+ rsvRegDate + ", rsvState=" + rsvState + ", rsvDate=" + rsvDate + ", startTime=" + startTime
				+ ", endTime=" + endTime + ", rsvStartDateTime=" + rsvStartDateTime + ", rsvEndDateTime="
				+ rsvEndDateTime + ", itemList=" + itemList + ", spaceList=" + spaceList + ", rsvDetailCode="
				+ rsvDetailCode + ", rsvDetailSpace=" + rsvDetailSpace + ", rsvDetailSeat=" + rsvDetailSeat
				+ ", rsvDetailItem=" + rsvDetailItem + ", rsvDetailNum=" + rsvDetailNum + ", rsvDetailOnePrice="
				+ rsvDetailOnePrice + ", rsvDetailTotalPrice=" + rsvDetailTotalPrice + ", storeId=" + storeId
				+ ", okaySpaceName=" + okaySpaceName + ", itemTotalName=" + itemTotalName + ", rsvTime=" + rsvTime
				+ ", rsvTimePrice=" + rsvTimePrice + ", itemCode=" + itemCode + ", payment=" + payment + "]";
	}
}

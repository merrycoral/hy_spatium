package com.urban.spatium.dto;

public class ReadySpace {
	
	private int readySpace;
	private int readyStoreCode;
	private String readySpaceName;
	private String readySpaceType;
	private int readyPeopleNumber;
	private String readyBriefSpace;
	private String readyDetailSpace;
	private String readySpaceTag;
	private int readyRentalPrice;
	private String readyStartTime;
	private String readyCloseTime;
	private String readyExceptionStartDate;
	private String readyExceptionEndDate;
	private String readySpaceBasicOption;
	private String readyRequestDate;
	
	private String readyStoreBusinessType;
	private String readySpaceId;
	
	private int storeCode;
	private int spaceCateCode;
	
	public String getreadySpaceId() {
		return readySpaceId;
	}
	public void setreadySpaceId(String readySpaceId) {
		this.readySpaceId = readySpaceId;
	}
	public int getReadySpace() {
		return readySpace;
	}
	public void setReadySpace(int readySpace) {
		this.readySpace = readySpace;
	}
	public int getReadyStoreCode() {
		return readyStoreCode;
	}
	public void setReadyStoreCode(int readyStoreCode) {
		this.readyStoreCode = readyStoreCode;
	}
	public String getReadySpaceName() {
		return readySpaceName;
	}
	public void setReadySpaceName(String readySpaceName) {
		this.readySpaceName = readySpaceName;
	}
	public String getReadySpaceType() {
		return readySpaceType;
	}
	public void setReadySpaceType(String readySpaceType) {
		this.readySpaceType = readySpaceType;
	}
	public int getReadyPeopleNumber() {
		return readyPeopleNumber;
	}
	public void setReadyPeopleNumber(int readyPeopleNumber) {
		this.readyPeopleNumber = readyPeopleNumber;
	}
	public String getReadyBriefSpace() {
		return readyBriefSpace;
	}
	public void setReadyBriefSpace(String readyBriefSpace) {
		this.readyBriefSpace = readyBriefSpace;
	}
	public String getReadyDetailSpace() {
		return readyDetailSpace;
	}
	public void setReadyDetailSpace(String readyDetailSpace) {
		this.readyDetailSpace = readyDetailSpace;
	}
	public String getReadySpaceTag() {
		return readySpaceTag;
	}
	public void setReadySpaceTag(String readySpaceTag) {
		this.readySpaceTag = readySpaceTag;
	}
	public int getReadyRentalPrice() {
		return readyRentalPrice;
	}
	public void setReadyRentalPrice(int readyRentalPrice) {
		this.readyRentalPrice = readyRentalPrice;
	}
	public String getReadyStartTime() {
		return readyStartTime;
	}
	public void setReadyStartTime(String readyStartTime) {
		this.readyStartTime = readyStartTime;
	}
	public String getReadyCloseTime() {
		return readyCloseTime;
	}
	public void setReadyCloseTime(String readyCloseTime) {
		this.readyCloseTime = readyCloseTime;
	}
	public String getReadyExceptionStartDate() {
		return readyExceptionStartDate;
	}
	public void setReadyExceptionStartDate(String readyExceptionStartDate) {
		this.readyExceptionStartDate = readyExceptionStartDate;
	}
	public String getReadyExceptionEndDate() {
		return readyExceptionEndDate;
	}
	public void setReadyExceptionEndDate(String readyExceptionEndDate) {
		this.readyExceptionEndDate = readyExceptionEndDate;
	}
	public String getReadySpaceBasicOption() {
		return readySpaceBasicOption;
	}
	public void setReadySpaceBasicOption(String readySpaceBasicOption) {
		this.readySpaceBasicOption = readySpaceBasicOption;
	}
	public String getReadyRequestDate() {
		return readyRequestDate;
	}
	public void setReadyRequestDate(String readyRequestDate) {
		this.readyRequestDate = readyRequestDate;
	}
	
	public int getStoreCode() {
		return storeCode;
	}
	public void setStoreCode(int storeCode) {
		this.storeCode = storeCode;
	}
	public int getSpaceCateCode() {
		return spaceCateCode;
	}
	public void setSpaceCateCode(int spaceCateCode) {
		this.spaceCateCode = spaceCateCode;
	}
	
	public String getReadyStoreBusinessType() {
		return readyStoreBusinessType;
	}
	public void setReadyStoreBusinessType(String readyStoreBusinessType) {
		this.readyStoreBusinessType = readyStoreBusinessType;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ReadySpace [readySpace=");
		builder.append(readySpace);
		builder.append(", readyStoreCode=");
		builder.append(readyStoreCode);
		builder.append(", readySpaceName=");
		builder.append(readySpaceName);
		builder.append(", readySpaceType=");
		builder.append(readySpaceType);
		builder.append(", readyPeopleNumber=");
		builder.append(readyPeopleNumber);
		builder.append(", readyBriefSpace=");
		builder.append(readyBriefSpace);
		builder.append(", readyDetailSpace=");
		builder.append(readyDetailSpace);
		builder.append(", readySpaceTag=");
		builder.append(readySpaceTag);
		builder.append(", readyRentalPrice=");
		builder.append(readyRentalPrice);
		builder.append(", readyStartTime=");
		builder.append(readyStartTime);
		builder.append(", readyCloseTime=");
		builder.append(readyCloseTime);
		builder.append(", readyExceptionStartDate=");
		builder.append(readyExceptionStartDate);
		builder.append(", readyExceptionEndDate=");
		builder.append(readyExceptionEndDate);
		builder.append(", readySpaceBasicOption=");
		builder.append(readySpaceBasicOption);
		builder.append(", readyRequestDate=");
		builder.append(readyRequestDate);
		builder.append(", readyStoreBusinessType=");
		builder.append(readyStoreBusinessType);
		builder.append(", readySpaceId=");
		builder.append(readySpaceId);
		builder.append(", storeCode=");
		builder.append(storeCode);
		builder.append(", spaceCateCode=");
		builder.append(spaceCateCode);
		builder.append("]");
		return builder.toString();
	}
	
}

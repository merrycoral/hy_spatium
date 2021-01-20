package com.urban.spatium.dto;

public class OKSpace {
	private int okaySpaceCode;
	private int okayStoreCode;
	private String okaySpaceName;
	private String okaySpaceType;
	private int okayPeopleNumber;
	private String okayDetailSpace;
	private String okayBriefSpace;
	private String okaySpaceTag;
	private int okaySpaceRentalPrice;
	private String okayStartTime;
	private String okayCloseTime;
	private String okayExceptionStartDate;
	private String okayExceptionEndDate;
	private String okayCompletedDate;
	private String okaySpaceBasicOption;
	private String okaySpaceId;
	private String spaceCateName;
	
	public String getSpaceCateName() {
		return spaceCateName;
	}
	public void setSpaceCateName(String spaceCateName) {
		this.spaceCateName = spaceCateName;
	}
	public int getOkaySpaceCode() {
		return okaySpaceCode;
	}
	public void setOkaySpaceCode(int okaySpaceCode) {
		this.okaySpaceCode = okaySpaceCode;
	}
	public int getOkayStoreCode() {
		return okayStoreCode;
	}
	public void setOkayStoreCode(int okayStoreCode) {
		this.okayStoreCode = okayStoreCode;
	}
	public String getOkaySpaceName() {
		return okaySpaceName;
	}
	public void setOkaySpaceName(String okaySpaceName) {
		this.okaySpaceName = okaySpaceName;
	}
	public String getOkaySpaceType() {
		return okaySpaceType;
	}
	public void setOkaySpaceType(String okaySpaceType) {
		this.okaySpaceType = okaySpaceType;
	}
	public int getOkayPeopleNumber() {
		return okayPeopleNumber;
	}
	public void setOkayPeopleNumber(int okayPeopleNumber) {
		this.okayPeopleNumber = okayPeopleNumber;
	}
	public String getOkayDetailSpace() {
		return okayDetailSpace;
	}
	public void setOkayDetailSpace(String okayDetailSpace) {
		this.okayDetailSpace = okayDetailSpace;
	}
	public String getOkayBriefSpace() {
		return okayBriefSpace;
	}
	public void setOkayBriefSpace(String okayBriefSpace) {
		this.okayBriefSpace = okayBriefSpace;
	}
	public String getOkaySpaceTag() {
		return okaySpaceTag;
	}
	public void setOkaySpaceTag(String okaySpaceTag) {
		this.okaySpaceTag = okaySpaceTag;
	}
	public int getOkaySpaceRentalPrice() {
		return okaySpaceRentalPrice;
	}
	public void setOkaySpaceRentalPrice(int okaySpaceRentalPrice) {
		this.okaySpaceRentalPrice = okaySpaceRentalPrice;
	}
	public String getOkayStartTime() {
		return okayStartTime;
	}
	public void setOkayStartTime(String okayStartTime) {
		this.okayStartTime = okayStartTime;
	}
	public String getOkayCloseTime() {
		return okayCloseTime;
	}
	public void setOkayCloseTime(String okayCloseTime) {
		this.okayCloseTime = okayCloseTime;
	}
	public String getOkayExceptionStartDate() {
		return okayExceptionStartDate;
	}
	public void setOkayExceptionStartDate(String okayExceptionStartDate) {
		this.okayExceptionStartDate = okayExceptionStartDate;
	}
	public String getOkayExceptionEndDate() {
		return okayExceptionEndDate;
	}
	public void setOkayExceptionEndDate(String okayExceptionEndDate) {
		this.okayExceptionEndDate = okayExceptionEndDate;
	}
	public String getOkayCompletedDate() {
		return okayCompletedDate;
	}
	public void setOkayCompletedDate(String okayCompletedDate) {
		this.okayCompletedDate = okayCompletedDate;
	}
	public String getOkaySpaceBasicOption() {
		return okaySpaceBasicOption;
	}
	public void setOkaySpaceBasicOption(String okaySpaceBasicOption) {
		this.okaySpaceBasicOption = okaySpaceBasicOption;
	}
	public String getOkaySpaceId() {
		return okaySpaceId;
	}
	public void setOkaySpaceId(String okaySpaceId) {
		this.okaySpaceId = okaySpaceId;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OKSpace [okaySpaceCode=");
		builder.append(okaySpaceCode);
		builder.append(", okayStoreCode=");
		builder.append(okayStoreCode);
		builder.append(", okaySpaceName=");
		builder.append(okaySpaceName);
		builder.append(", okaySpaceType=");
		builder.append(okaySpaceType);
		builder.append(", okayPeopleNumber=");
		builder.append(okayPeopleNumber);
		builder.append(", okayDetailSpace=");
		builder.append(okayDetailSpace);
		builder.append(", okayBriefSpace=");
		builder.append(okayBriefSpace);
		builder.append(", okaySpaceTag=");
		builder.append(okaySpaceTag);
		builder.append(", okaySpaceRentalPrice=");
		builder.append(okaySpaceRentalPrice);
		builder.append(", okayStartTime=");
		builder.append(okayStartTime);
		builder.append(", okayCloseTime=");
		builder.append(okayCloseTime);
		builder.append(", okayExceptionStartDate=");
		builder.append(okayExceptionStartDate);
		builder.append(", okayExceptionEndDate=");
		builder.append(okayExceptionEndDate);
		builder.append(", okayCompletedDate=");
		builder.append(okayCompletedDate);
		builder.append(", okaySpaceBasicOption=");
		builder.append(okaySpaceBasicOption);
		builder.append(", okaySpaceId=");
		builder.append(okaySpaceId);
		builder.append(", spaceCateName=");
		builder.append(spaceCateName);
		builder.append("]");
		return builder.toString();
	}
	
}

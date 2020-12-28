package com.urban.spatium.dto;

import java.util.List;
import java.util.Map;

public class Store {
	
	private int storeCode;
	private String storeId;
	private String storeName;
	private String storeRepresentative;
	private String storeNumber;
	private String storeBusinessType;
	private String storeAddress;
	private String storeIntroduction;
	private String storeEmail;
	private String storePhone;
	private String storeAccountNumber;
	private String storeRefundRull;
	private String storeRemainingDay;
	private String storeRefundPercent;
	private String storeImage;
	private int storeLevel;
	
	private int spaceRelationStoreCode;
	private int spaceRelationCateCode;
	private int spaceRelationCode;
	
	private List<Map<String,Object>> storeRefundRullList;
	
	public String getStoreRefundRull() {
		return storeRefundRull;
	}
	public void setStoreRefundRull(String storeRefundRull) {
		this.storeRefundRull = storeRefundRull;
	}

	public int getStoreCode() {
		return storeCode;
	}
	public void setStoreCode(int storeCode) {
		this.storeCode = storeCode;
	}
	public String getStoreId() {
		return storeId;
	}
	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public String getStoreRepresentative() {
		return storeRepresentative;
	}
	public void setStoreRepresentative(String storeRepresentative) {
		this.storeRepresentative = storeRepresentative;
	}
	public String getStoreNumber() {
		return storeNumber;
	}
	public void setStoreNumber(String storeNumber) {
		this.storeNumber = storeNumber;
	}
	public String getStoreBusinessType() {
		return storeBusinessType;
	}
	public void setStoreBusinessType(String storeBusinessType) {
		this.storeBusinessType = storeBusinessType;
	}
	public String getStoreAddress() {
		return storeAddress;
	}
	public void setStoreAddress(String storeAddress) {
		this.storeAddress = storeAddress;
	}
	public String getStoreIntroduction() {
		return storeIntroduction;
	}
	public void setStoreIntroduction(String storeIntroduction) {
		this.storeIntroduction = storeIntroduction;
	}
	public String getStoreEmail() {
		return storeEmail;
	}
	public void setStoreEmail(String storeEmail) {
		this.storeEmail = storeEmail;
	}
	public String getStorePhone() {
		return storePhone;
	}
	public void setStorePhone(String storePhone) {
		this.storePhone = storePhone;
	}
	public String getStoreAccountNumber() {
		return storeAccountNumber;
	}
	public void setStoreAccountNumber(String storeAccountNumber) {
		this.storeAccountNumber = storeAccountNumber;
	}
	public String getStoreImage() {
		return storeImage;
	}
	public void setStoreImage(String storeImage) {
		this.storeImage = storeImage;
	}
	public int getStoreLevel() {
		return storeLevel;
	}
	public void setStoreLevel(int storeLevel) {
		this.storeLevel = storeLevel;
	}
	
	public int getSpaceRelationCode() {
		return spaceRelationCode;
	}
	public void setSpaceRelationCode(int spaceRelationCode) {
		this.spaceRelationCode = spaceRelationCode;
	}
	public int getSpaceRelationStoreCode() {
		return spaceRelationStoreCode;
	}
	public void setSpaceRelationStoreCode(int spaceRelationStoreCode) {
		this.spaceRelationStoreCode = spaceRelationStoreCode;
	}
	
	public int getSpaceRelationCateCode() {
		return spaceRelationCateCode;
	}
	public void setSpaceRelationCateCode(int spaceRelationCateCode) {
		this.spaceRelationCateCode = spaceRelationCateCode;
	}
	
	public String getStoreRemainingDay() {
		return storeRemainingDay;
	}
	public void setStoreRemainingDay(String storeRemainingDay) {
		this.storeRemainingDay = storeRemainingDay;
	}
	public String getStoreRefundPercent() {
		return storeRefundPercent;
	}
	public void setStoreRefundPercent(String storeRefundPercent) {
		this.storeRefundPercent = storeRefundPercent;
	}
	
	public List<Map<String, Object>> getStoreRefundRullList() {
		return storeRefundRullList;
	}
	public void setStoreRefundRullList(List<Map<String, Object>> storeRefundRullList) {
		this.storeRefundRullList = storeRefundRullList;
	}
	
	@Override
	public String toString() {
		return "Store [storeCode=" + storeCode + ", storeId=" + storeId + ", storeName=" + storeName
				+ ", storeRepresentative=" + storeRepresentative + ", storeNumber=" + storeNumber
				+ ", storeBusinessType=" + storeBusinessType + ", storeAddress=" + storeAddress + ", storeIntroduction="
				+ storeIntroduction + ", storeEmail=" + storeEmail + ", storePhone=" + storePhone
				+ ", storeAccountNumber=" + storeAccountNumber + ", storeRefundRull=" + storeRefundRull
				+ ", storeRemainingDay=" + storeRemainingDay + ", storeRefundPercent=" + storeRefundPercent
				+ ", storeImage=" + storeImage + ", storeLevel=" + storeLevel + ", spaceRelationStoreCode="
				+ spaceRelationStoreCode + ", spaceRelationCateCode=" + spaceRelationCateCode + ", spaceRelationCode="
				+ spaceRelationCode + ", storeRefundRullList=" + storeRefundRullList + "]";
	}
	
	
	
	
	
}

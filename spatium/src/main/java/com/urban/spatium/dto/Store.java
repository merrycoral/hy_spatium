package com.urban.spatium.dto;

import java.util.List;

public class Store {
	
	private int storeCode;
	private String storeId;
	private String storeName;
	private String storeRepresentative;
	private String storeNumber;
	private String storeBusinessType;
	private String storeAddressNumber;
	private String storeAddress;
	private String storeAddressDetail;
	private String storeIntroduction;
	private String storeEmail;
	private String storeRsvType;
	private String storePhone;
	private String storeAccountBankName;
	private String storeAccountNumber;
	private String storeRefundRull;
	private String storeRemainingDay;
	private String storeRefundPercent;
	private String storeImage;
	private int storeLevel;
	private String storeRegDate;
	
	private List<Store> storeCategoryList;
	private List<String> remainingDay;
	private List<String> refundPercent;
	private String remainingDays;
	private String refundPercents;
	private int refundPolicyCode;
	
	
	public int getRefundPolicyCode() {
		return refundPolicyCode;
	}
	public void setRefundPolicyCode(int refundPolicyCode) {
		this.refundPolicyCode = refundPolicyCode;
	}
	public String getRemainingDays() {
		return remainingDays;
	}
	public void setRemainingDays(String remainingDays) {
		this.remainingDays = remainingDays;
	}
	public String getRefundPercents() {
		return refundPercents;
	}
	public void setRefundPercents(String refundPercents) {
		this.refundPercents = refundPercents;
	}
	public List<String> getRemainingDay() {
		return remainingDay;
	}
	public void setRemainingDay(List<String> remainingDay) {
		this.remainingDay = remainingDay;
	}
	public List<String> getRefundPercent() {
		return refundPercent;
	}
	public void setRefundPercent(List<String> refundPercent) {
		this.refundPercent = refundPercent;
	}

	private int spaceRelationStoreCode;
	private int spaceRelationCateCode;
	private int spaceRelationCode;
	
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
	public String getStoreRegDate() {
		return storeRegDate;
	}
	public void setStoreRegDate(String storeRegDate) {
		this.storeRegDate = storeRegDate;
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
	public List<Store> getStoreCategoryList() {
		return storeCategoryList;
	}
	public void setStoreCategoryList(List<Store> storeCategoryList) {
		this.storeCategoryList = storeCategoryList;
	}
	public String getStoreRsvType() {
		return storeRsvType;
	}
	public void setStoreRsvType(String storeRsvType) {
		this.storeRsvType = storeRsvType;
	}
	public String getStoreAddressNumber() {
		return storeAddressNumber;
	}
	public void setStoreAddressNumber(String storeAddressNumber) {
		this.storeAddressNumber = storeAddressNumber;
	}
	public String getStoreAddressDetail() {
		return storeAddressDetail;
	}
	public void setStoreAddressDetail(String storeAddressDetail) {
		this.storeAddressDetail = storeAddressDetail;
	}
	public String getStoreAccountBankName() {
		return storeAccountBankName;
	}
	public void setStoreAccountBankName(String storeAccountBankName) {
		this.storeAccountBankName = storeAccountBankName;
	}
	
	@Override
	public String toString() {
		return "Store [storeCode=" + storeCode + ", storeId=" + storeId + ", storeName=" + storeName
				+ ", storeRepresentative=" + storeRepresentative + ", storeNumber=" + storeNumber
				+ ", storeBusinessType=" + storeBusinessType + ", storeAddressNumber=" + storeAddressNumber
				+ ", storeAddress=" + storeAddress + ", storeAddressDetail=" + storeAddressDetail
				+ ", storeIntroduction=" + storeIntroduction + ", storeEmail=" + storeEmail + ", storeRsvType="
				+ storeRsvType + ", storePhone=" + storePhone + ", storeAccountBankName=" + storeAccountBankName
				+ ", storeAccountNumber=" + storeAccountNumber + ", storeRefundRull=" + storeRefundRull
				+ ", storeRemainingDay=" + storeRemainingDay + ", storeRefundPercent=" + storeRefundPercent
				+ ", storeImage=" + storeImage + ", storeLevel=" + storeLevel + ", storeRegDate=" + storeRegDate
				+ ", storeCategoryList=" + storeCategoryList + ", remainingDay=" + remainingDay + ", refundPercent="
				+ refundPercent + ", remainingDays=" + remainingDays + ", refundPercents=" + refundPercents
				+ ", refundPolicyCode=" + refundPolicyCode + ", spaceRelationStoreCode=" + spaceRelationStoreCode
				+ ", spaceRelationCateCode=" + spaceRelationCateCode + ", spaceRelationCode=" + spaceRelationCode + "]";
	}
	
}

package com.urban.spatium.dto;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

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
	
	private MultipartFile proBgImage;
	
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
	public MultipartFile getProBgImage() {
		return proBgImage;
	}
	public void setProBgImage(MultipartFile proBgImage) {
		this.proBgImage = proBgImage;
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
		StringBuilder builder = new StringBuilder();
		builder.append("Store [storeCode=");
		builder.append(storeCode);
		builder.append(", storeId=");
		builder.append(storeId);
		builder.append(", storeName=");
		builder.append(storeName);
		builder.append(", storeRepresentative=");
		builder.append(storeRepresentative);
		builder.append(", storeNumber=");
		builder.append(storeNumber);
		builder.append(", storeBusinessType=");
		builder.append(storeBusinessType);
		builder.append(", storeAddressNumber=");
		builder.append(storeAddressNumber);
		builder.append(", storeAddress=");
		builder.append(storeAddress);
		builder.append(", storeAddressDetail=");
		builder.append(storeAddressDetail);
		builder.append(", storeIntroduction=");
		builder.append(storeIntroduction);
		builder.append(", storeEmail=");
		builder.append(storeEmail);
		builder.append(", storeRsvType=");
		builder.append(storeRsvType);
		builder.append(", storePhone=");
		builder.append(storePhone);
		builder.append(", storeAccountBankName=");
		builder.append(storeAccountBankName);
		builder.append(", storeAccountNumber=");
		builder.append(storeAccountNumber);
		builder.append(", storeRefundRull=");
		builder.append(storeRefundRull);
		builder.append(", storeRemainingDay=");
		builder.append(storeRemainingDay);
		builder.append(", storeRefundPercent=");
		builder.append(storeRefundPercent);
		builder.append(", storeImage=");
		builder.append(storeImage);
		builder.append(", storeLevel=");
		builder.append(storeLevel);
		builder.append(", storeRegDate=");
		builder.append(storeRegDate);
		builder.append(", storeCategoryList=");
		builder.append(storeCategoryList);
		builder.append(", remainingDay=");
		builder.append(remainingDay);
		builder.append(", refundPercent=");
		builder.append(refundPercent);
		builder.append(", remainingDays=");
		builder.append(remainingDays);
		builder.append(", refundPercents=");
		builder.append(refundPercents);
		builder.append(", refundPolicyCode=");
		builder.append(refundPolicyCode);
		builder.append(", proBgImage=");
		builder.append(proBgImage);
		builder.append(", spaceRelationStoreCode=");
		builder.append(spaceRelationStoreCode);
		builder.append(", spaceRelationCateCode=");
		builder.append(spaceRelationCateCode);
		builder.append(", spaceRelationCode=");
		builder.append(spaceRelationCode);
		builder.append("]");
		return builder.toString();
	}
	
}

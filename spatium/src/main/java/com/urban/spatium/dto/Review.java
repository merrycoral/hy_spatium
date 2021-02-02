package com.urban.spatium.dto;

public class Review {
	private int reviewCode;
	private int reviewSpaceRsv;
	private int reviewSpaceCode;
	private String reviewStoreId;
	private String reviewStoreCode;
	private String reviewTitle;
	private String reviewContents;
	private String reviewAddId;
	private String reviewAddDate;	
	private String reviewUpDate;
	private int reviewType;
	private int reviewPoint;
	private String reviewDisplay;
	private String reviewReply;
	private String reviewPhoto; 
	private int reviewClean; 
	private int reviewService;
	private int reviewRestroom;
	private int reviewFacility;
	private int reviewAmbience; 
	private int reviewScore;
	
	@Override
	public String toString() {
		return "Review [reviewCode=" + reviewCode + ", reviewSpaceRsv=" + reviewSpaceRsv + ", reviewSpaceCode="
				+ reviewSpaceCode + ", reviewStoreId=" + reviewStoreId + ", reviewStoreCode=" + reviewStoreCode
				+ ", reviewTitle=" + reviewTitle + ", reviewContents=" + reviewContents + ", reviewAddId=" + reviewAddId
				+ ", reviewAddDate=" + reviewAddDate + ", reviewUpDate=" + reviewUpDate + ", reviewType=" + reviewType
				+ ", reviewPoint=" + reviewPoint + ", reviewDisplay=" + reviewDisplay + ", reviewReply=" + reviewReply
				+ ", reviewPhoto=" + reviewPhoto + ", reviewClean=" + reviewClean + ", reviewService=" + reviewService
				+ ", reviewRestroom=" + reviewRestroom + ", reviewFacility=" + reviewFacility + ", reviewAmbience="
				+ reviewAmbience + ", reviewScore=" + reviewScore + "]";
	}

	public String getReviewStoreCode() {
		return reviewStoreCode;
	}

	public void setReviewStoreCode(String reviewStoreCode) {
		this.reviewStoreCode = reviewStoreCode;
	}
	
	public String getReviewReply() {
		return reviewReply;
	}

	public void setReviewReply(String reviewReply) {
		this.reviewReply = reviewReply;
	}

	public String getReviewPhoto() {
		return reviewPhoto;
	}

	public void setReviewPhoto(String reviewPhoto) {
		this.reviewPhoto = reviewPhoto;
	}

	public String getReviewStoreId() {
		return reviewStoreId;
	}
	public void setReviewStoreId(String reviewStoreId) {
		this.reviewStoreId = reviewStoreId;
	}
	public int getReviewCode() {
		return reviewCode;
	}
	public void setReviewCode(int reviewCode) {
		this.reviewCode = reviewCode;
	}
	public int getReviewSpaceRsv() {
		return reviewSpaceRsv;
	}
	public void setReviewSpaceRsv(int reviewSpaceRsv) {
		this.reviewSpaceRsv = reviewSpaceRsv;
	}
	public int getReviewSpaceCode() {
		return reviewSpaceCode;
	}
	public void setReviewSpaceCode(int reviewSpaceCode) {
		this.reviewSpaceCode = reviewSpaceCode;
	}
	public String getReviewTitle() {
		return reviewTitle;
	}
	public void setReviewTitle(String reviewTitle) {
		this.reviewTitle = reviewTitle;
	}
	public String getReviewContents() {
		return reviewContents;
	}
	public void setReviewContents(String reviewContents) {
		this.reviewContents = reviewContents;
	}
	public String getReviewAddId() {
		return reviewAddId;
	}
	public void setReviewAddId(String reviewAddId) {
		this.reviewAddId = reviewAddId;
	}
	public String getReviewAddDate() {
		return reviewAddDate;
	}
	public void setReviewAddDate(String reviewAddDate) {
		this.reviewAddDate = reviewAddDate;
	}
	public String getReviewUpDate() {
		return reviewUpDate;
	}
	public void setReviewUpDate(String reviewUpDate) {
		this.reviewUpDate = reviewUpDate;
	}
	public int getReviewType() {
		return reviewType;
	}
	public void setReviewType(int reviewType) {
		this.reviewType = reviewType;
	}
	public int getReviewPoint() {
		return reviewPoint;
	}
	public void setReviewPoint(int reviewPoint) {
		this.reviewPoint = reviewPoint;
	}
	public String getReviewDisplay() {
		return reviewDisplay;
	}
	public void setReviewDisplay(String reviewDisplay) {
		this.reviewDisplay = reviewDisplay;
	}
	public int getReviewClean() {
		return reviewClean;
	}
	public void setReviewClean(int reviewClean) {
		this.reviewClean = reviewClean;
	}
	public int getReviewService() {
		return reviewService;
	}
	public void setReviewService(int reviewService) {
		this.reviewService = reviewService;
	}
	public int getReviewRestroom() {
		return reviewRestroom;
	}
	public void setReviewRestroom(int reviewRestroom) {
		this.reviewRestroom = reviewRestroom;
	}
	public int getReviewFacility() {
		return reviewFacility;
	}
	public void setReviewFacility(int reviewFacility) {
		this.reviewFacility = reviewFacility;
	}
	public int getReviewAmbience() {
		return reviewAmbience;
	}
	public void setReviewAmbience(int reviewAmbience) {
		this.reviewAmbience = reviewAmbience;
	}
	public int getReviewScore() {
		return reviewScore;
	}
	public void setReviewScore(int reviewScore) {
		this.reviewScore = reviewScore;
	}
}

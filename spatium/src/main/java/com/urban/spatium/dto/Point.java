package com.urban.spatium.dto;

public class Point {
	private int PointCode;
	private String pointAddList;
	private String pointSellList;
	private String pointID;
	private String pointModyfiDate;
	private int pointList;
	private int pointPaymentCode;
	private int pointReviewCode;
	
	
	public String getPointModyfiDate() {
		return pointModyfiDate;
	}
	public void setPointModyfiDate(String pointModyfiDate) {
		this.pointModyfiDate = pointModyfiDate;
	}

	public int getPointReviewCode() {
		return pointReviewCode;
	}
	public void setPointReviewCode(int pointReviewCode) {
		this.pointReviewCode = pointReviewCode;
	}
	public int getPointPaymentCode() {
		return pointPaymentCode;
	}
	public void setPointPaymentCode(int pointPaymentCode) {
		this.pointPaymentCode = pointPaymentCode;
	}
	public String getPointID() {
		return pointID;
	}
	public void setPointID(String pointID) {
		this.pointID = pointID;
	}
	public int getPointCode() {
		return PointCode;
	}
	public void setPointCode(int pointCode) {
		PointCode = pointCode;
	}
	public String getPointAddList() {
		return pointAddList;
	}
	public void setPointAddList(String pointAddList) {
		this.pointAddList = pointAddList;
	}
	public String getPointSellList() {
		return pointSellList;
	}
	public void setPointSellList(String pointSellList) {
		this.pointSellList = pointSellList;
	}
	public int getPointList() {
		return pointList;
	}
	public void setPointList(int pointList) {
		this.pointList = pointList;
	}
	
	@Override
	public String toString() {
		return "Point [PointCode=" + PointCode + ", pointAddList=" + pointAddList + ", pointSellList=" + pointSellList
				+ ", pointID=" + pointID + ", pointModyfiDate=" + pointModyfiDate + ", pointList=" + pointList
				+ ", pointPaymentCode=" + pointPaymentCode + ", pointReviewCode=" + pointReviewCode + "]";
	}


}
	
	

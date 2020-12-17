package com.urban.spatium.dto;

public class Browser4 {
	private String browserName;
	private int browserCount;
	
	public String getBrowserName() {
		return browserName;
	}
	public void setBrowserName(String browserName) {
		this.browserName = browserName;
	}
	public int getBrowserCount() {
		return browserCount;
	}
	public void setBrowserCount(int browserCount) {
		this.browserCount = browserCount;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Browser4 [browserName=");
		builder.append(browserName);
		builder.append(", browserCount=");
		builder.append(browserCount);
		builder.append("]");
		return builder.toString();
	}
	
}

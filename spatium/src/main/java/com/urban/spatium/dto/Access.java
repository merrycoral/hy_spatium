package com.urban.spatium.dto;

public class Access {
	private int accessCode;
	private String accessBrowser;
	private String accessDevice;
	private String accessOS;
	private String accessRoute;
	private String accessIP;
	private String accessTime;
	private String accessID;
	
	public int getAccessCode() {
		return accessCode;
	}
	public void setAccessCode(int accessCode) {
		this.accessCode = accessCode;
	}
	public String getAccessBrowser() {
		return accessBrowser;
	}
	public void setAccessBrowser(String accessBrowser) {
		this.accessBrowser = accessBrowser;
	}
	public String getAccessDevice() {
		return accessDevice;
	}
	public void setAccessDevice(String accessDevice) {
		this.accessDevice = accessDevice;
	}
	public String getAccessOS() {
		return accessOS;
	}
	public void setAccessOS(String accessOS) {
		this.accessOS = accessOS;
	}
	public String getAccessRoute() {
		return accessRoute;
	}
	public void setAccessRoute(String accessRoute) {
		this.accessRoute = accessRoute;
	}
	public String getAccessIP() {
		return accessIP;
	}
	public void setAccessIP(String accessIP) {
		this.accessIP = accessIP;
	}
	public String getAccessTime() {
		return accessTime;
	}
	public void setAccessTime(String accessTime) {
		this.accessTime = accessTime;
	}
	public String getAccessID() {
		return accessID;
	}
	public void setAccessID(String accessID) {
		this.accessID = accessID;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Access [accessCode=");
		builder.append(accessCode);
		builder.append(", accessBrowser=");
		builder.append(accessBrowser);
		builder.append(", accessDevice=");
		builder.append(accessDevice);
		builder.append(", accessOS=");
		builder.append(accessOS);
		builder.append(", accessRoute=");
		builder.append(accessRoute);
		builder.append(", accessIP=");
		builder.append(accessIP);
		builder.append(", accessTime=");
		builder.append(accessTime);
		builder.append(", accessID=");
		builder.append(accessID);
		builder.append("]");
		return builder.toString();
	}
	
}

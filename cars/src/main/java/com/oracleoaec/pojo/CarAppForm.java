package com.oracleoaec.pojo;

public class CarAppForm {
	
	private Integer carAppId;
	private Integer appUserId;
	private Integer appDeptId;
	private Integer appRoverId;
	private String appTime;
	private String appRoverTime;
	private Integer approverStatus;
	private Integer schedulingId;
	public Integer getCarAppId() {
		return carAppId;
	}
	public void setCarAppId(Integer carAppId) {
		this.carAppId = carAppId;
	}
	public Integer getAppUserId() {
		return appUserId;
	}
	public void setAppUserId(Integer appUserId) {
		this.appUserId = appUserId;
	}
	public Integer getAppDeptId() {
		return appDeptId;
	}
	public void setAppDeptId(Integer appDeptId) {
		this.appDeptId = appDeptId;
	}
	public Integer getAppRoverId() {
		return appRoverId;
	}
	public void setAppRoverId(Integer appRoverId) {
		this.appRoverId = appRoverId;
	}
	public String getAppTime() {
		return appTime;
	}
	public void setAppTime(String appTime) {
		this.appTime = appTime;
	}
	public String getAppRoverTime() {
		return appRoverTime;
	}
	public void setAppRoverTime(String appRoverTime) {
		this.appRoverTime = appRoverTime;
	}
	public Integer getApproverStatus() {
		return approverStatus;
	}
	public void setApproverStatus(Integer approverStatus) {
		this.approverStatus = approverStatus;
	}
	public Integer getSchedulingId() {
		return schedulingId;
	}
	public void setSchedulingId(Integer schedulingId) {
		this.schedulingId = schedulingId;
	}
	@Override
	public String toString() {
		return "CarAppForm [carAppId=" + carAppId + ", appUserId=" + appUserId + ", appDeptId=" + appDeptId
				+ ", appRoverId=" + appRoverId + ", appTime=" + appTime + ", appRoverTime=" + appRoverTime
				+ ", approverStatus=" + approverStatus + ", schedulingId=" + schedulingId + "]";
	}
	
	
	
}

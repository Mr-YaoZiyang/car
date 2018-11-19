package com.oracleoaec.pojo;

public class Scheduling {
	private Integer schedulingId;
	private Integer userId;
	private Integer carId;
	private String appLeavingDate;
	private String actualLeavingDate;
	private String planedReturnTime;
	private String Storagetime;
	private Integer vktBeforeMoving;
	private Integer vktAfterMoving;
	private Integer roadToll;
	private String destination;
	private String usingReason;
	public Integer getSchedulingId() {
		return schedulingId;
	}
	public void setSchedulingId(Integer schedulingId) {
		this.schedulingId = schedulingId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getCarId() {
		return carId;
	}
	public void setCarId(Integer carId) {
		this.carId = carId;
	}
	public String getAppLeavingDate() {
		return appLeavingDate;
	}
	public void setAppLeavingDate(String appLeavingDate) {
		this.appLeavingDate = appLeavingDate;
	}
	public String getActualLeavingDate() {
		return actualLeavingDate;
	}
	public void setActualLeavingDate(String actualLeavingDate) {
		this.actualLeavingDate = actualLeavingDate;
	}
	public String getPlanedReturnTime() {
		return planedReturnTime;
	}
	public void setPlanedReturnTime(String planedReturnTime) {
		this.planedReturnTime = planedReturnTime;
	}
	public String getStoragetime() {
		return Storagetime;
	}
	public void setStoragetime(String storagetime) {
		Storagetime = storagetime;
	}
	public Integer getVktBeforeMoving() {
		return vktBeforeMoving;
	}
	public void setVktBeforeMoving(Integer vktBeforeMoving) {
		this.vktBeforeMoving = vktBeforeMoving;
	}
	public Integer getVktAfterMoving() {
		return vktAfterMoving;
	}
	public void setVktAfterMoving(Integer vktAfterMoving) {
		this.vktAfterMoving = vktAfterMoving;
	}
	public Integer getRoadToll() {
		return roadToll;
	}
	public void setRoadToll(Integer roadToll) {
		this.roadToll = roadToll;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getUsingReason() {
		return usingReason;
	}
	public void setUsingReason(String usingReason) {
		this.usingReason = usingReason;
	}
	@Override
	public String toString() {
		return "Scheduling [schedulingId=" + schedulingId + ", userId=" + userId + ", carId=" + carId
				+ ", appLeavingDate=" + appLeavingDate + ", actualLeavingDate=" + actualLeavingDate
				+ ", planedReturnTime=" + planedReturnTime + ", Storagetime=" + Storagetime + ", vktBeforeMoving="
				+ vktBeforeMoving + ", vktAfterMoving=" + vktAfterMoving + ", roadToll=" + roadToll + ", destination="
				+ destination + ", usingReason=" + usingReason + "]";
	}
	
	
}

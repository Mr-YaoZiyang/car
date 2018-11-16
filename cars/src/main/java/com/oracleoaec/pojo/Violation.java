package com.oracleoaec.pojo;

public class Violation {
	
	private Integer violationId;
	private Integer driverId;
	private Integer carId;
	private String violationTime;
	private String violationSite;
	private String violationInfo;
	private String results;
	private Integer violationCost;
	private Integer violationStatus;
	public Integer getViolationId() {
		return violationId;
	}
	public void setViolationId(Integer violationId) {
		this.violationId = violationId;
	}
	public Integer getDriverId() {
		return driverId;
	}
	public void setDriverId(Integer driverId) {
		this.driverId = driverId;
	}
	public Integer getCarId() {
		return carId;
	}
	public void setCarId(Integer carId) {
		this.carId = carId;
	}
	public String getViolationTime() {
		return violationTime;
	}
	public void setViolationTime(String violationTime) {
		this.violationTime = violationTime;
	}
	public String getViolationSite() {
		return violationSite;
	}
	public void setViolationSite(String violationSite) {
		this.violationSite = violationSite;
	}
	public String getViolationInfo() {
		return violationInfo;
	}
	public void setViolationInfo(String violationInfo) {
		this.violationInfo = violationInfo;
	}
	public String getResults() {
		return results;
	}
	public void setResults(String results) {
		this.results = results;
	}
	public Integer getViolationCost() {
		return violationCost;
	}
	public void setViolationCost(Integer violationCost) {
		this.violationCost = violationCost;
	}
	public Integer getViolationStatus() {
		return violationStatus;
	}
	public void setViolationStatus(Integer violationStatus) {
		this.violationStatus = violationStatus;
	}
	@Override
	public String toString() {
		return "Violation [violationId=" + violationId + ", driverId=" + driverId + ", carId=" + carId
				+ ", violationTime=" + violationTime + ", violationSite=" + violationSite + ", violationInfo="
				+ violationInfo + ", results=" + results + ", violationCost=" + violationCost + ", violationStatus="
				+ violationStatus + "]";
	}
	
}

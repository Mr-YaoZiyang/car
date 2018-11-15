package com.oracleoaec.pojo;

public class DriverInfo {

	private Integer driverId;
	private Integer sexId;
	private String driverNum;
	private String driverName;
	private Integer driverAge;
	private String driverNumber;
	private String driverTel;
	private String driverAddress;
	private String driverType;
	private Integer driverStatus;
	public Integer getDriverId() {
		return driverId;
	}
	public void setDriverId(Integer driverId) {
		this.driverId = driverId;
	}
	public Integer getSexId() {
		return sexId;
	}
	public void setSexId(Integer sexId) {
		this.sexId = sexId;
	}
	public String getDriverNum() {
		return driverNum;
	}
	public void setDriverNum(String driverNum) {
		this.driverNum = driverNum;
	}
	public String getDriverName() {
		return driverName;
	}
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}
	public Integer getDriverAge() {
		return driverAge;
	}
	public void setDriverAge(Integer driverAge) {
		this.driverAge = driverAge;
	}
	public String getDriverNumber() {
		return driverNumber;
	}
	public void setDriverNumber(String driverNumber) {
		this.driverNumber = driverNumber;
	}
	public String getDriverTel() {
		return driverTel;
	}
	public void setDriverTel(String driverTel) {
		this.driverTel = driverTel;
	}
	public String getDriverAddress() {
		return driverAddress;
	}
	public void setDriverAddress(String driverAddress) {
		this.driverAddress = driverAddress;
	}
	public String getDriverType() {
		return driverType;
	}
	public void setDriverType(String driverType) {
		this.driverType = driverType;
	}
	public Integer getDriverStatus() {
		return driverStatus;
	}
	public void setDriverStatus(Integer driverStatus) {
		this.driverStatus = driverStatus;
	}
	@Override
	public String toString() {
		return "DriverInfo [driverId=" + driverId + ", sexId=" + sexId + ", driverNum=" + driverNum + ", driverName="
				+ driverName + ", driverAge=" + driverAge + ", driverNumber=" + driverNumber + ", driverTel="
				+ driverTel + ", driverAddress=" + driverAddress + ", driverType=" + driverType + ", driverStatus="
				+ driverStatus + "]";
	}
	
}

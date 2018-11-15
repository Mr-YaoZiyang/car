package com.oracleoaec.pojo;

public class CarType {
	private Integer carTypeId;
	private String carTypeName;
	private Integer catTypeStatus;
	public Integer getCarTypeId() {
		return carTypeId;
	}
	public void setCarTypeId(Integer carTypeId) {
		this.carTypeId = carTypeId;
	}
	public String getCarTypeName() {
		return carTypeName;
	}
	public void setCarTypeName(String carTypeName) {
		this.carTypeName = carTypeName;
	}
	public Integer getCatTypeStatus() {
		return catTypeStatus;
	}
	public void setCatTypeStatus(Integer catTypeStatus) {
		this.catTypeStatus = catTypeStatus;
	}
	@Override
	public String toString() {
		return "CarType [carTypeId=" + carTypeId + ", carTypeName=" + carTypeName + ", catTypeStatus=" + catTypeStatus
				+ "]";
	}
	
}

package com.oracleoaec.pojo;

public class CarInfo {
	private Integer carId;
	private Integer carTypeId;
	private String carNum;
	private Integer carCapacity;
	private String brandModel;
	private String regTime;
	private String examinationTime;  //出厂时间
	private String factoryNumber;
	private Integer carStatus;
	public Integer getCarId() {
		return carId;
	}
	public void setCarId(Integer carId) {
		this.carId = carId;
	}
	public Integer getCarTypeId() {
		return carTypeId;
	}
	public void setCarTypeId(Integer carTypeId) {
		this.carTypeId = carTypeId;
	}
	public String getCarNum() {
		return carNum;
	}
	public void setCarNum(String carNum) {
		this.carNum = carNum;
	}
	public Integer getCarCapacity() {
		return carCapacity;
	}
	public void setCarCapacity(Integer carCapacity) {
		this.carCapacity = carCapacity;
	}
	public String getBrandModel() {
		return brandModel;
	}
	public void setBrandModel(String brandModel) {
		this.brandModel = brandModel;
	}
	public String getRegTime() {
		return regTime;
	}
	public void setRegTime(String regTime) {
		this.regTime = regTime;
	}
	public String getExaminationTime() {
		return examinationTime;
	}
	public void setExaminationTime(String examinationTime) {
		this.examinationTime = examinationTime;
	}
	public String getFactoryNumber() {
		return factoryNumber;
	}
	public void setFactoryNumber(String factoryNumber) {
		this.factoryNumber = factoryNumber;
	}
	public Integer getCarStatus() {
		return carStatus;
	}
	public void setCarStatus(Integer carStatus) {
		this.carStatus = carStatus;
	}
	@Override
	public String toString() {
		return "CarInfo [carId=" + carId + ", carTypeId=" + carTypeId + ", carNum=" + carNum + ", carCapacity="
				+ carCapacity + ", brandModel=" + brandModel + ", regTime=" + regTime + ", examinationTime="
				+ examinationTime + ", factoryNumber=" + factoryNumber + ", carStatus=" + carStatus + "]";
	}
	
}
                          
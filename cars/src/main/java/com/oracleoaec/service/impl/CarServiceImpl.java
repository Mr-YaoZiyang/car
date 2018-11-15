package com.oracleoaec.service.impl;

import java.util.List;
import java.util.Map;

import com.oracleoaec.mapper.CarMapper;
import com.oracleoaec.pojo.CarInfo;
import com.oracleoaec.service.CarService;

public class CarServiceImpl implements CarService {
	
	private CarMapper cm;
	public CarMapper getCm() {
		return cm;
	}
	public void setCm(CarMapper cm) {
		this.cm = cm;
	}
	
	@Override
	public List<Map<String, Object>> queryAllCar() {
		List<Map<String,Object>> queryAllCar = cm.queryAllCar();
		return queryAllCar;
	}
	
	@Override
	public Map<String, Object> queryCarById(Integer carId) {
		Map<String, Object> queryCarById = cm.queryCarById(carId);
		return queryCarById;
	}
	@Override
	public int insertCar(CarInfo car) {
		int i = cm.insertCar(car);
		return i;
	}
	@Override
	public int deleteCar(Integer carId) {
		int i = cm.deleteCar(carId);
		return i;
	}
	@Override
	public int updateCar(CarInfo car) {
		int i = cm.updateCar(car);
		return i;
	}
	
	
	
}

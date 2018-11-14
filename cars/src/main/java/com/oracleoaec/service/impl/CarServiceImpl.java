package com.oracleoaec.service.impl;

import java.util.List;
import java.util.Map;

import com.oracleoaec.mapper.CarMapper;
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

}

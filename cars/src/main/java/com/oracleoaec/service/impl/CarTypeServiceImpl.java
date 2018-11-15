package com.oracleoaec.service.impl;

import java.util.List;
import java.util.Map;

import com.oracleoaec.mapper.CarTypeMapper;
import com.oracleoaec.service.CarTypeService;

public class CarTypeServiceImpl implements CarTypeService{
	
	private CarTypeMapper ctm;
	public CarTypeMapper getCtm() {
		return ctm;
	}
	public void setCtm(CarTypeMapper ctm) {
		this.ctm = ctm;
	}
	@Override
	public List<Map<String, Object>> queryAllCarType() {
		List<Map<String, Object>> queryAllCarType = ctm.queryAllCarType();
		return queryAllCarType;
	}

}

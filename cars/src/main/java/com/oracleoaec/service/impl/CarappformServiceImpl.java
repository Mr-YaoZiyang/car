package com.oracleoaec.service.impl;

import java.util.List;
import java.util.Map;

import com.oracleoaec.mapper.CarappformMapper;
import com.oracleoaec.pojo.CarAppForm;
import com.oracleoaec.service.CarappformService;

public class CarappformServiceImpl implements CarappformService {
	
	private CarappformMapper cafm;
	public CarappformMapper getCafm() {
		return cafm;
	}
	public void setCafm(CarappformMapper cafm) {
		this.cafm = cafm;
	}

	@Override
	public List<Map<String, Object>> queryCarappForm() {
		List<Map<String, Object>> queryCarappForm = cafm.queryCarappForm();
		return queryCarappForm;
	}

	@Override
	public Map<String, Object> queryCarappFormById(Integer carAppId) {
		Map<String, Object> queryCarappFormById = cafm.queryCarappFormById(carAppId);
		return queryCarappFormById;
	}

	@Override
	public int insertCarAppForm(CarAppForm caf) {
		int i = cafm.insertCarAppForm(caf);
		return i;
	}

	@Override
	public int updateCarAppForm(CarAppForm caf) {
		int i = cafm.updateCarAppForm(caf);
		return i;
	}
	@Override
	public List<Map<String, Object>> queryCarappFormByUserId(Integer userId) {
		List<Map<String,Object>> list = cafm.queryCarappFormByUserId(userId);
		return list;
	}

}

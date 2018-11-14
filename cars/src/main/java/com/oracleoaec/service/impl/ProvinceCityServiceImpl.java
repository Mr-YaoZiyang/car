package com.oracleoaec.service.impl;

import java.util.List;
import java.util.Map;

import com.oracleoaec.mapper.ProvinceCityMapper;
import com.oracleoaec.service.ProvinceCityService;

public class ProvinceCityServiceImpl implements ProvinceCityService {

	private ProvinceCityMapper pcm;
	public ProvinceCityMapper getPcm() {
		return pcm;
	}
	public void setPcm(ProvinceCityMapper pcm) {
		this.pcm = pcm;
	}
	@Override
	public List<Map<String, Object>> queryAllProvince() {
		List<Map<String,Object>> provinceList = pcm.queryAllProvince();
		return provinceList;
	}

	@Override
	public List<Map<String, Object>> queryAllCity(Integer provinceId) {
		List<Map<String, Object>> cityList = pcm.queryAllCity(provinceId);
		return cityList;
	}

}

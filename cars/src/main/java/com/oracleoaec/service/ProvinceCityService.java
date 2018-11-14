package com.oracleoaec.service;

import java.util.List;
import java.util.Map;

public interface ProvinceCityService {
	
	/**
	 * 查询省
	 * @return
	 */
	List<Map<String, Object>> queryAllProvince();
	/**
	 * 查询市
	 * @return
	 */
	List<Map<String, Object>> queryAllCity(Integer provinceId);
}

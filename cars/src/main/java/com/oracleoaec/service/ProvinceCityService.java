package com.oracleoaec.service;

import java.util.List;
import java.util.Map;

public interface ProvinceCityService {
	
	/**
	 * ��ѯʡ
	 * @return
	 */
	List<Map<String, Object>> queryAllProvince();
	/**
	 * ��ѯ��
	 * @return
	 */
	List<Map<String, Object>> queryAllCity(Integer provinceId);
}

package com.oracleoaec.mapper;

import java.util.List;
import java.util.Map;

public interface ProvinceCityMapper {
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

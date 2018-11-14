package com.oracleoaec.mapper;

import java.util.List;
import java.util.Map;

public interface ProvinceCityMapper {
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

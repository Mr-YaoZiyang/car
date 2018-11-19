package com.oracleoaec.mapper;

import java.util.List;
import java.util.Map;

import com.oracleoaec.pojo.CarAppForm;

public interface CarappformMapper {
	
	List<Map<String, Object>> queryCarappForm();
	
	Map<String, Object> queryCarappFormById(Integer carAppId);
	
	int insertCarAppForm(CarAppForm caf);
	
	int updateCarAppForm(CarAppForm caf);
	
	List<Map<String, Object>> queryCarappFormByUserId(Integer userId);
}

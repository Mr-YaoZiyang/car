package com.oracleoaec.mapper;

import java.util.List;
import java.util.Map;

import com.oracleoaec.pojo.Violation;



public interface ViolationMapper {
	/**
	 * �鿴ȫ��Υ����Ϣ
	 * @return
	 */
	public List<Map<String, Object>> queryAllViolation();
	
	
	Map<String, Object> queryViolationById(Integer violationId);
	
	int insertViolation(Violation violation);
	
	int updateViolation(Violation violation);
	
	int deleteViolation(Integer violationId);
}
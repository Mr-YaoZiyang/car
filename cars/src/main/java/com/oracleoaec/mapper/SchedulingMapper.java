package com.oracleoaec.mapper;

import java.util.List;
import java.util.Map;

import com.oracleoaec.pojo.Scheduling;

public interface SchedulingMapper {
	
	List<Map<String, Object>> queryAllScheduling();
	
	Map<String, Object> querySchedulingById(Integer schedulingId);
	
	int insertScheduling(Scheduling scheduling);
	
	/**
	 * ≈…≥µ
	 * @param scheduling
	 * @return
	 */
	int sendCar(Scheduling scheduling);
	
	List<Map<String, Object>> queryAllSendCar();
	
	List<Map<String, Object>> queryPutStorage();
	
	int putStorage(Scheduling scheduling);
	
}

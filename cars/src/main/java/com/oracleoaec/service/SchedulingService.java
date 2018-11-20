package com.oracleoaec.service;

import java.util.List;
import java.util.Map;

import com.oracleoaec.pojo.Scheduling;

public interface SchedulingService {

	List<Map<String, Object>> queryAllScheduling();
	
	Map<String, Object> querySchedulingById(Integer schedulingId);
	
	int insertScheduling(Scheduling scheduling);
	
	int sendCar(Scheduling scheduling);
	
	List<Map<String, Object>> queryAllSendCar();
	
	List<Map<String, Object>> queryPutStorage();
	
	int putStorage(Scheduling scheduling);
}

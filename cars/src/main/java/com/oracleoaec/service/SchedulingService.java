package com.oracleoaec.service;

import java.util.List;
import java.util.Map;

import com.oracleoaec.pojo.Scheduling;

public interface SchedulingService {

	List<Map<String, Object>> queryAllScheduling();
	
	Map<String, Object> querySchedulingById(Integer schedulingId);
	
	int insertScheduling(Scheduling scheduling);
	
	int updateScheduling(Scheduling scheduling);
}

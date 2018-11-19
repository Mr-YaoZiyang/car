package com.oracleoaec.service.impl;

import java.util.List;
import java.util.Map;

import com.oracleoaec.mapper.SchedulingMapper;
import com.oracleoaec.pojo.Scheduling;
import com.oracleoaec.service.SchedulingService;

public class SchedulingServiceImpl implements SchedulingService {

	private SchedulingMapper sm;
	public SchedulingMapper getSm() {
		return sm;
	}
	public void setSm(SchedulingMapper sm) {
		this.sm = sm;
	}

	@Override
	public List<Map<String, Object>> queryAllScheduling() {
		List<Map<String, Object>> queryAllScheduling = sm.queryAllScheduling();
		return queryAllScheduling;
	}

	@Override
	public Map<String, Object> querySchedulingById(Integer schedulingId) {
		Map<String, Object> querySchedulingById = sm.querySchedulingById(schedulingId);
		return querySchedulingById;
	}

	@Override
	public int insertScheduling(Scheduling scheduling) {
		int i = sm.insertScheduling(scheduling);
		return i;
	}

	@Override
	public int updateScheduling(Scheduling scheduling) {
		int i = sm.updateScheduling(scheduling);
		return i;
	}

}

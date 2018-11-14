package com.oracleoaec.service.impl;

import java.util.List;
import java.util.Map;

import com.oracleoaec.mapper.SexMapper;
import com.oracleoaec.service.SexService;

public class SexServiceImpl implements SexService {
	
	private SexMapper sm;
	
	public SexMapper getSm() {
		return sm;
	}

	public void setSm(SexMapper sm) {
		this.sm = sm;
	}

	@Override
	public List<Map<String, Object>> queryAllSex() {
		List<Map<String,Object>> queryAllSex = sm.queryAllSex();
		return queryAllSex;
	}

}

package com.oracleoaec.service.impl;

import java.util.List;
import java.util.Map;

import com.oracleoaec.mapper.DeptMapper;
import com.oracleoaec.service.DeptService;

public class DeptServiceImpl implements DeptService {

	private DeptMapper dm;
	
	public DeptMapper getDm() {
		return dm;
	}

	public void setDm(DeptMapper dm) {
		this.dm = dm;
	}

	@Override
	public List<Map<String, Object>> queryAllDept() {
		List<Map<String,Object>> queryAllDept = dm.queryAllDept();
		return queryAllDept;
	}

}

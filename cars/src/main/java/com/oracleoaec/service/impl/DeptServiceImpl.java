package com.oracleoaec.service.impl;

import java.util.List;
import java.util.Map;

import com.oracleoaec.mapper.DeptMapper;
import com.oracleoaec.pojo.Dept;
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

	@Override
	public Map<String, Object> queryDeptById(Integer deptId) {
		Map<String, Object> queryDeptById = dm.queryDeptById(deptId);
		return queryDeptById;
	}

	@Override
	public int insertDept(Dept dept) {
		int i = dm.insertDept(dept);
		return i;
	}

	@Override
	public int updateDept(Dept dept) {
		int i = dm.updateDept(dept);
		return i;
	}

	@Override
	public int deleteDept(Integer deptId) {
		int i = dm.deleteDept(deptId);
		return i;
	}

	
}

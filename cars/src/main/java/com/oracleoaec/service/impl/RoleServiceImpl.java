package com.oracleoaec.service.impl;

import java.util.List;
import java.util.Map;

import com.oracleoaec.mapper.RoleMapper;
import com.oracleoaec.service.RoleService;

public class RoleServiceImpl implements RoleService {

	private RoleMapper rm;
	
	public RoleMapper getRm() {
		return rm;
	}

	public void setRm(RoleMapper rm) {
		this.rm = rm;
	}

	@Override
	public List<Map<String, Object>> queryAllRole() {
		List<Map<String,Object>> queryAllRole = rm.queryAllRole();
		return queryAllRole;
	}

}

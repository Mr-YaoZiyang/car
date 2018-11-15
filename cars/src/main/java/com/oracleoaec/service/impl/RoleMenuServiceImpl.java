package com.oracleoaec.service.impl;

import java.util.List;
import java.util.Map;

import com.oracleoaec.mapper.RoleMenuMapper;
import com.oracleoaec.service.RoleMenuService;

public class RoleMenuServiceImpl implements RoleMenuService {

	private RoleMenuMapper rmm;
	public RoleMenuMapper getRmm() {
		return rmm;
	}
	public void setRmm(RoleMenuMapper rmm) {
		this.rmm = rmm;
	}
	@Override
	public Map<String, Object> queryFathMenuByUserId(Integer userId) {
		Map<String,Object> list = rmm.queryFathMenuByUserId(userId);
		
		return list;
	}
	@Override
	public List<Map<String, Object>> querySonMenuByUserId(Integer menuId) {
		List<Map<String, Object>> querySonMenuByUserId = rmm.querySonMenuByUserId(menuId);
		return querySonMenuByUserId;
	}

}

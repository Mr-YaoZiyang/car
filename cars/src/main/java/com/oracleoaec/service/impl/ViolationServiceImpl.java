package com.oracleoaec.service.impl;

import java.util.List;
import java.util.Map;

import com.oracleoaec.mapper.ViolationMapper;
import com.oracleoaec.pojo.Violation;
import com.oracleoaec.service.ViolationService;

public class ViolationServiceImpl implements ViolationService {
	
	
	private ViolationMapper vm;
	public ViolationMapper getVm() {
		return vm;
	}
	public void setVm(ViolationMapper vm) {
		this.vm = vm;
	}
	@Override
	public List<Map<String, Object>> queryAllViolation() {
		List<Map<String,Object>> queryAllViolation = vm.queryAllViolation();
		return queryAllViolation;
	}
	@Override
	public Map<String, Object> queryViolationById(Integer violationId) {
		Map<String, Object> map = vm.queryViolationById(violationId);
		return map;
	}
	@Override
	public int insertViolation(Violation violation) {
		int i = vm.insertViolation(violation);
		return i;
	}
	@Override
	public int updateViolation(Violation violation) {
		int i = vm.updateViolation(violation);
		return i;

	}
	@Override
	public int deleteViolation(Integer violationId) {
		int i = vm.deleteViolation(violationId);
		return i;
	}

}

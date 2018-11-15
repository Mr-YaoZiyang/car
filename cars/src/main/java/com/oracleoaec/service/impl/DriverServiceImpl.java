package com.oracleoaec.service.impl;

import java.util.List;
import java.util.Map;

import com.oracleoaec.mapper.DriverMapper;
import com.oracleoaec.pojo.DriverInfo;
import com.oracleoaec.service.DriverService;

public class DriverServiceImpl implements DriverService {

	private DriverMapper dm;
	public DriverMapper getDm() {
		return dm;
	}
	public void setDm(DriverMapper dm) {
		this.dm = dm;
	}
	@Override
	public List<Map<String, Object>> queryAllDriver() {
		List<Map<String, Object>> queryAllDriver = dm.queryAllDriver();
		return queryAllDriver;
	}
	@Override
	public Map<String, Object> queryDriverById(Integer driverId) {
		Map<String, Object> queryDriverById = dm.queryDriverById(driverId);
		return queryDriverById;
	}
	@Override
	public int insertDriver(DriverInfo driver) {
		int i = dm.insertDriver(driver);
		return i;
	}
	@Override
	public int updateDriver(DriverInfo driver) {
		int i = dm.updateDriver(driver);
		return i;
	}
	@Override
	public int deleteDriver(Integer driverId) {
		int i = dm.deleteDriver(driverId);
		return i;
	}

}

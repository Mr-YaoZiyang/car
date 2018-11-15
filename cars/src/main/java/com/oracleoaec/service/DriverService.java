package com.oracleoaec.service;

import java.util.List;
import java.util.Map;

import com.oracleoaec.pojo.DriverInfo;

public interface DriverService {
	
	List<Map<String, Object>> queryAllDriver();
	
	Map<String, Object> queryDriverById(Integer driverId);
	
	int insertDriver(DriverInfo driver);
	
	int updateDriver(DriverInfo driver);
	
	int deleteDriver(Integer driverId);

}

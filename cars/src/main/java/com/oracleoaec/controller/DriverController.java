package com.oracleoaec.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oracleoaec.pojo.CarInfo;
import com.oracleoaec.pojo.DriverInfo;
import com.oracleoaec.service.DriverService;
import com.oracleoaec.service.SexService;

@Controller
public class DriverController {
	
	@Autowired
	@Qualifier("driverService")
	private DriverService ds;
	
	@Autowired
	@Qualifier("sexService")
	private SexService sex;
	
	@RequestMapping("allDirverInfo.do")
	@ResponseBody
	public List<Map<String,Object>> allDriver(HttpServletRequest request) {
		List<Map<String,Object>> queryAllDriver = ds.queryAllDriver();
		
		
		return queryAllDriver;
	}
	@RequestMapping("showAddDriverInfo.do")
	public String showAddCarInfo(HttpServletRequest request) {
		List<Map<String, Object>> queryAllSex = sex.queryAllSex();
		request.setAttribute("sexList", queryAllSex);
		return "AddDriver";
	}
	
	@RequestMapping("AddDriverInfo.do")
	public String AddCarInfo(DriverInfo driver,HttpServletRequest request) {
		int insertDriver = ds.insertDriver(driver);
		return "AddDriver";
	}
	
	@RequestMapping("deleteDriver.do")
	@ResponseBody
	public Map<String, Object> deleteDriver(DriverInfo driver) {
		Map<String, Object> map = new HashMap<>();
		int i = ds.deleteDriver(driver.getDriverId());
		if(i>0) {
			map.put("flag", true);
		}else {
			map.put("flag", false);
		}
		
		return map;
	}
	

	@RequestMapping("showUpdateDriverInfo.do")
	public String showUpdateDriverInfo(DriverInfo driver,HttpServletRequest request) {
		
		Map<String, Object> queryDriverById = ds.queryDriverById(driver.getDriverId());
		request.setAttribute("driverMap", queryDriverById);

		List<Map<String, Object>> queryAllSex = sex.queryAllSex();
		request.setAttribute("sexList", queryAllSex);
		
		return "updateDriver";
	}
	
	@RequestMapping("updateDriverInfo.do")
	public String updateUserInfo(DriverInfo driver,HttpServletRequest request) {
		
		System.out.println(driver.toString());
		
		int i = ds.updateDriver(driver);
		
		return "AddDriver";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

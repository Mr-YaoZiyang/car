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

import com.oracleoaec.pojo.Violation;
import com.oracleoaec.service.CarService;
import com.oracleoaec.service.DriverService;
import com.oracleoaec.service.ViolationService;

@Controller
public class ViolationController {
	
	@Autowired
	@Qualifier("violationService")
	private ViolationService vs;
	
	@Autowired
	@Qualifier("driverService")
	private DriverService ds;
	
	@Autowired
	@Qualifier("carService")
	private CarService cs;
	
	@RequestMapping("allViolationInfo.do")
	@ResponseBody
	public List<Map<String, Object>> allViolationInfo(){
		List<Map<String,Object>> list = vs.queryAllViolation();
		
		return list;
	}
	
	@RequestMapping("showAddViolationInfo.do")
	public String showAddCarInfo(HttpServletRequest request) {
		
		List<Map<String, Object>> queryAllDriver = ds.queryAllDriver();
		request.setAttribute("driverList", queryAllDriver);
		List<Map<String,Object>> queryAllCar = cs.queryAllCar();
		request.setAttribute("carList", queryAllCar);
		
		return "AddViolation";
	}
	
	@RequestMapping("AddViolationInfo.do")
	public String AddViolationInfo(Violation violation, HttpServletRequest request) {
		
		int i = vs.insertViolation(violation);
		
		return "AddViolation";
	}
	@RequestMapping("deleteViolation.do")
	@ResponseBody
	public Map<String, Object> deleteViolation(Violation violation){
		
		int i = vs.deleteViolation(violation.getViolationId());
		Map<String, Object> map = new HashMap<>();
		if(i>0) {
			map.put("flag", true);
		}else {
			map.put("flag", false);
		}
		
		return map;
	}
	
	@RequestMapping("showUpdateViolationInfo.do")
	public String showUpdateViolationInfo(Violation violation,HttpServletRequest request) {
		
		Map<String, Object> violationmap = vs.queryViolationById(violation.getViolationId());
		request.setAttribute("violationmap", violationmap);
		
		List<Map<String, Object>> queryAllDriver = ds.queryAllDriver();
		request.setAttribute("driverList", queryAllDriver);
		List<Map<String,Object>> queryAllCar = cs.queryAllCar();
		request.setAttribute("carList", queryAllCar);
		
		return "updateViolation";
	}
	
	@RequestMapping("updateViolationInfo.do")
	public String updateViolationInfo(Violation violation) {
		System.out.println(violation.toString());
		int i = vs.updateViolation(violation);
		
		return "AddViolation";
	}
	
	
	
}

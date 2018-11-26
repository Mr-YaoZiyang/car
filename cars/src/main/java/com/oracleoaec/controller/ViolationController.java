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

import com.oracleoaec.pojo.PageBean;
import com.oracleoaec.pojo.Violation;
import com.oracleoaec.service.CarService;
import com.oracleoaec.service.DriverService;
import com.oracleoaec.service.PageService;
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
	
	@Autowired
	@Qualifier("pageService")
	private PageService ps;
	
	@RequestMapping("allViolationInfo.do")
	@ResponseBody
	public PageBean allViolationInfo(HttpServletRequest request){
		Integer pageNumber=Integer.parseInt(request.getParameter("page"));
		Integer pageSize=Integer.parseInt(request.getParameter("rows"));
		System.out.println(pageNumber+","+pageSize);
		String sql = "select * from violationInfo v " + 
				"		inner join carInfo c on v.car_id = c.car_id " + 
				"		inner join driverInfo d on d.driver_id = v.driver_id" + 
				"		where violation_status = 1";
		Map<String, Object> pageMap = new HashMap<String, Object>();
		
		pageMap.put("pageNumber", pageNumber);
		pageMap.put("pageSize", pageSize);
		pageMap.put("sql", sql);
		List<Map<String, Object>> rows = ps.queryPageBean(pageMap);
		String sql1= "select count(*) from violationInfo v " + 
				"		inner join carInfo c on v.car_id = c.car_id " + 
				"		inner join driverInfo d on d.driver_id = v.driver_id" + 
				"		where violation_status = 1";
		Integer total = ps.queryTotal(sql1);
		PageBean pageBean = new PageBean();
		pageBean.setRows(rows);
		pageBean.setTotal(total);
		return pageBean;
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

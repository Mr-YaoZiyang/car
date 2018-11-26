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
import com.oracleoaec.pojo.Dept;
import com.oracleoaec.pojo.PageBean;
import com.oracleoaec.service.DeptService;
import com.oracleoaec.service.PageService;

@Controller
public class DeptController {
	
	@Autowired
	@Qualifier("deptService")
	private DeptService ds;
	
	@Autowired
	@Qualifier("pageService")
	private PageService ps;
	
	@RequestMapping("allDept.do")
	@ResponseBody
	public PageBean allDept(HttpServletRequest request){
		Integer pageNumber=Integer.parseInt(request.getParameter("page"));
		Integer pageSize=Integer.parseInt(request.getParameter("rows"));
		System.out.println(pageNumber+","+pageSize);
		String sql = "select * from dept where dept_status = 1";
		Map<String, Object> pageMap = new HashMap<String, Object>();
		
		pageMap.put("pageNumber", pageNumber);
		pageMap.put("pageSize", pageSize);
		pageMap.put("sql", sql);
		List<Map<String, Object>> rows = ps.queryPageBean(pageMap);
		String sql1="select count(*) from dept where dept_status = 1 ";
		Integer total = ps.queryTotal(sql1);
		PageBean pageBean = new PageBean();
		pageBean.setRows(rows);
		pageBean.setTotal(total);
		return pageBean;
	}
	
	@RequestMapping("AddDeptInfo.do")
	public String addDeptInfo(Dept dept,HttpServletRequest request) {
		
		int i = ds.insertDept(dept);
		
		return "AddDept";
	}
	
	@RequestMapping("deleteDept.do")
	@ResponseBody
	public Map<String, Object> deleteCar(Dept dept) {
		Map<String, Object> map = new HashMap<>();
		int i = ds.deleteDept(dept.getDeptId());
		if(i>0) {
			map.put("flag", true);
		}else {
			map.put("flag", false);
		}
		
		return map;
	}
	
	@RequestMapping("showUpdateDeptInfo.do")
	public String showUpdateDeptInfo(Dept dept,HttpServletRequest request) {
		
		Map<String, Object> map = ds.queryDeptById(dept.getDeptId());
		request.setAttribute("map", map);
		
		
		return "updateDept";
	}
	
	@RequestMapping("updateDeptInfo.do")
	public String updateDeptInfo(Dept dept,HttpServletRequest request) {
		
		int i = ds.updateDept(dept);
		
		
		return "AddDept";
	}
	
	
	
}

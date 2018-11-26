package com.oracleoaec.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oracleoaec.pojo.CarAppForm;
import com.oracleoaec.pojo.CarInfo;
import com.oracleoaec.pojo.PageBean;
import com.oracleoaec.service.CarService;
import com.oracleoaec.service.CarappformService;
import com.oracleoaec.service.PageService;

@Controller
public class CarappformController {

	@Autowired
	@Qualifier("carappformService")
	private CarappformService cs;
	
	@Autowired
	@Qualifier("carService")
	private CarService cser;

	@Autowired
	@Qualifier("pageService")
	private PageService ps;
	
	@RequestMapping("applyForCarInfo.do")
	public String applyForCarInfo(HttpServletRequest request) {
		CarAppForm caf = new CarAppForm();
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		caf.setAppTime(sdf.format(date));
		HttpSession session = request.getSession();
		Map userMap = (Map) session.getAttribute("userMap");
		caf.setAppDeptId(new Integer(userMap.get("DEPT_ID").toString()));
		caf.setAppUserId(new Integer(userMap.get("USER_ID").toString()));
		caf.setApproverStatus(1);
		Integer schedulingId = (Integer) request.getAttribute("schedulingId");
		caf.setSchedulingId(schedulingId);
		System.out.println(caf.toString());
		int i = cs.insertCarAppForm(caf);

		return "applyForCarInfo";
	}
	
	@RequestMapping("userApplyFor.do")
	@ResponseBody
	public PageBean userApplyFor(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Map userMap = (Map) session.getAttribute("userMap");
		System.out.println(userMap.get("USER_ID").toString());
		
		
		Integer pageNumber=Integer.parseInt(request.getParameter("page"));
		Integer pageSize=Integer.parseInt(request.getParameter("rows"));
		System.out.println(pageNumber+","+pageSize);
		String sql = "select * from carAppform  c " + 
				"		join scheduling s on c.scheduling_id = s.scheduling_id " + 
				"		where c.appuser_id = "+userMap.get("USER_ID").toString();
		Map<String, Object> pageMap = new HashMap<String, Object>();
		
		pageMap.put("pageNumber", pageNumber);
		pageMap.put("pageSize", pageSize);
		pageMap.put("sql", sql);
		List<Map<String, Object>> rows = ps.queryPageBean(pageMap);
		String sql1="select count(*) from carAppform  c " + 
				"		join scheduling s on c.scheduling_id = s.scheduling_id " + 
				"		where c.appuser_id = "+userMap.get("USER_ID").toString();
		Integer total = ps.queryTotal(sql1);
		PageBean pageBean = new PageBean();
		pageBean.setRows(rows);
		pageBean.setTotal(total);
		return pageBean;
	}
	
	@RequestMapping("allPendingInfo.do")
	@ResponseBody
	public PageBean allPendingInfo(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Map userMap = (Map) session.getAttribute("userMap");
		Integer deptId = new Integer(userMap.get("DEPT_ID").toString());
		Integer pageNumber=Integer.parseInt(request.getParameter("page"));
		Integer pageSize=Integer.parseInt(request.getParameter("rows"));
		System.out.println(pageNumber+","+pageSize);
		String sql = "select * from carAppform c " + 
				"	    join scheduling s on c.scheduling_id = s.scheduling_id " + 
				"	    join carinfo car on car.car_id = s.car_id" + 
				"	    join users u on c.appuser_id = u.user_id " + 
				"	    left join users us on us.user_id = c.approver_id" + 
				"		where c.appDept_id = "+deptId+" and approver_status ="+1;
		Map<String, Object> pageMap = new HashMap<String, Object>();
		
		pageMap.put("pageNumber", pageNumber);
		pageMap.put("pageSize", pageSize);
		pageMap.put("sql", sql);
		List<Map<String, Object>> rows = ps.queryPageBean(pageMap);
		String sql1= "select count(*) from carAppform c " + 
				"	    join scheduling s on c.scheduling_id = s.scheduling_id " + 
				"	    join carinfo car on car.car_id = s.car_id" + 
				"	    join users u on c.appuser_id = u.user_id " + 
				"	    left join users us on us.user_id = c.approver_id" + 
				"		where c.appDept_id = "+deptId+" and approver_status ="+1;
		Integer total = ps.queryTotal(sql1);
		PageBean pageBean = new PageBean();
		pageBean.setRows(rows);
		pageBean.setTotal(total);
		return pageBean;
	}
	
	@RequestMapping("AgreeApproval.do")
	@ResponseBody
	public Map<String, Object> AgreeApproval(CarAppForm caf,HttpServletRequest request) {
		
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		caf.setAppRoverTime(sdf.format(date));
		HttpSession session = request.getSession();
		Map userMap = (Map) session.getAttribute("userMap");
		//caf.setAppDeptId(new Integer(userMap.get("DEPT_ID").toString()));
		//caf.setAppUserId(new Integer(userMap.get("USER_ID").toString()));
		caf.setAppRoverId(new Integer(userMap.get("USER_ID").toString()));
		int i = cs.updateCarAppForm(caf);
		Map<String, Object> map = new HashMap<>();
		if(i>0) {
			map.put("flag", true);
		}else {
			map.put("flag", false);
		}
		
		return map;
	}
	
	@RequestMapping("disapprove.do")
	@ResponseBody
	public Map<String, Object> disapprove(CarAppForm caf,CarInfo car,HttpServletRequest request) {
		
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		caf.setAppRoverTime(sdf.format(date));
		HttpSession session = request.getSession();
		Map userMap = (Map) session.getAttribute("userMap");
		//caf.setAppDeptId(new Integer(userMap.get("DEPT_ID").toString()));
		//caf.setAppUserId(new Integer(userMap.get("USER_ID").toString()));
		caf.setAppRoverId(new Integer(userMap.get("USER_ID").toString()));
		int i = cs.updateCarAppForm(caf);
		Map<String, Object> map = new HashMap<>();
		if(i>0) {
			int freeCar = cser.freeCar(car);
			map.put("flag", true);
		}else {
			map.put("flag", false);
		}
		
		return map;
	}
	
	@RequestMapping("allAfterPendingInfo.do")
	@ResponseBody
	public PageBean allAfterPendingInfo(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Map userMap = (Map) session.getAttribute("userMap");
		Integer deptId = new Integer(userMap.get("DEPT_ID").toString());
		Integer pageNumber=Integer.parseInt(request.getParameter("page"));
		Integer pageSize=Integer.parseInt(request.getParameter("rows"));
		String sql = "select * from carAppform c " + 
				"	    join scheduling s on c.scheduling_id = s.scheduling_id " + 
				"	    join carinfo car on car.car_id = s.car_id" + 
				"	    join users u on c.appuser_id = u.user_id " + 
				"	    left join users us on us.user_id = c.approver_id" + 
				"		where c.appDept_id = "+deptId+" and approver_status >"+1;
		Map<String, Object> pageMap = new HashMap<String, Object>();
		
		pageMap.put("pageNumber", pageNumber);
		pageMap.put("pageSize", pageSize);
		pageMap.put("sql", sql);
		List<Map<String, Object>> rows = ps.queryPageBean(pageMap);
		String sql1= "select count(*) from carAppform c " + 
				"	    join scheduling s on c.scheduling_id = s.scheduling_id " + 
				"	    join carinfo car on car.car_id = s.car_id" + 
				"	    join users u on c.appuser_id = u.user_id " + 
				"	    left join users us on us.user_id = c.approver_id" + 
				"		where c.appDept_id = "+deptId+" and approver_status >"+1;
		Integer total = ps.queryTotal(sql1);
		PageBean pageBean = new PageBean();
		pageBean.setRows(rows);
		pageBean.setTotal(total);
		return pageBean;
	}
	
	@RequestMapping("returnCar.do")
	@ResponseBody
	public Map<String, Object> returnCar(CarAppForm caf,HttpServletRequest request) {
		Map<String, Object> map = new HashMap<>();
		int i = cs.returnCar(caf);
		if(i>0) {
			map.put("flag", true);
		}else {
			map.put("flag", false);
		}
		return map;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

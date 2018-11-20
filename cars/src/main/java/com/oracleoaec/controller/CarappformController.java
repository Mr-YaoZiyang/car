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
import com.oracleoaec.service.CarappformService;

@Controller
public class CarappformController {
	
	@Autowired
	@Qualifier("carappformService")
	private CarappformService cs;
	
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
	public List<Map<String, Object>> userApplyFor(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Map userMap = (Map) session.getAttribute("userMap");
		System.out.println(userMap.get("USER_ID").toString());
		List<Map<String, Object>> myApplyList = cs.queryCarappFormByUserId(new Integer(userMap.get("USER_ID").toString()));
		
		return myApplyList;
	}
	
	@RequestMapping("allPendingInfo.do")
	@ResponseBody
	public List<Map<String, Object>> allPendingInfo(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Map userMap = (Map) session.getAttribute("userMap");
		Integer deptId = new Integer(userMap.get("DEPT_ID").toString());
		Map<String,Object> pendingMap = new HashMap<>();
		pendingMap.put("appDeptId", deptId);
		pendingMap.put("approverStatus", 1);
		List<Map<String, Object>> pendingList = cs.querycarPending(pendingMap);
		
		return pendingList;
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
	public Map<String, Object> disapprove(CarAppForm caf,HttpServletRequest request) {
		
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
	
	@RequestMapping("allAfterPendingInfo.do")
	@ResponseBody
	public List<Map<String, Object>> allAfterPendingInfo(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Map userMap = (Map) session.getAttribute("userMap");
		Integer deptId = new Integer(userMap.get("DEPT_ID").toString());
		Map<String,Object> pendingMap = new HashMap<>();
		pendingMap.put("appDeptId", deptId);
		pendingMap.put("approverStatus", 2);
		List<Map<String, Object>> afterPendingList = new ArrayList<>();
		
		List<Map<String, Object>> AgreeList = cs.querycarPending(pendingMap);
		afterPendingList.addAll(AgreeList);
		pendingMap.put("approverStatus", 3);
		List<Map<String, Object>> disapproveList = cs.querycarPending(pendingMap);
		afterPendingList.addAll(disapproveList);
		return afterPendingList;
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

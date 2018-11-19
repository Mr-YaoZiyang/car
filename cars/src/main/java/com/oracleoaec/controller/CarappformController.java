package com.oracleoaec.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
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
	
	
	
	
	
	
}

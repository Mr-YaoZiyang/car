package com.oracleoaec.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oracleoaec.pojo.Scheduling;
import com.oracleoaec.service.SchedulingService;

@Controller
public class SchedulingController {
	
	@Autowired
	@Qualifier("schedulingService")
	private SchedulingService ss;
	
	@RequestMapping("schedulingInfo.do")
	public String schedulingInfo(Scheduling scheduling,HttpServletRequest request) {
		
		System.out.println(scheduling.toString());
		
		int i = ss.insertScheduling(scheduling);
		Integer schedulingId = scheduling.getSchedulingId();
		System.out.println(schedulingId);
		request.setAttribute("schedulingId", schedulingId);
		if(i>0) {
			return "forward:applyForCarInfo.do";
		}else {
			return "applyForCarInfo";
		}
		
	}
	
}

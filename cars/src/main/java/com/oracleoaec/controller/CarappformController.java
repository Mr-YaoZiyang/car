package com.oracleoaec.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oracleoaec.pojo.CarInfo;
import com.oracleoaec.service.CarappformService;

@Controller
public class CarappformController {
	
	@Autowired
	@Qualifier("carappformService")
	private CarappformService cafs;
	
	@RequestMapping("applyForCarInfo.do")
	public String applyForCarInfo(CarInfo car,HttpServletRequest request) {
		
		request.setAttribute("carId", car.getCarId());
		
		
		
		return "applyForCarInfo";
	}
	
	
	
	
	
	
	
	
}

package com.oracleoaec.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oracleoaec.service.CarService;

@Controller
public class CarController {
	
	@Autowired
	@Qualifier("carService")
	private CarService cs;
	
	@RequestMapping("allCarInfo.do")
	@ResponseBody
	public List<Map<String, Object>> AllCarInfo(){
		
		List<Map<String, Object>> queryAllCar = cs.queryAllCar();
		return queryAllCar;
	}
	
}

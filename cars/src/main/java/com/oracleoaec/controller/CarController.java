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
import com.oracleoaec.service.CarService;
import com.oracleoaec.service.CarTypeService;

@Controller
public class CarController {
	
	@Autowired
	@Qualifier("carService")
	private CarService cs;
	@Autowired
	@Qualifier("carTypeService")
	private CarTypeService cts;
	
	@RequestMapping("allCarInfo.do")
	@ResponseBody
	public List<Map<String, Object>> AllCarInfo(){
		
		List<Map<String, Object>> queryAllCar = cs.queryAllCar();
		return queryAllCar;
	}
	
	@RequestMapping("showAddCarInfo.do")
	public String showAddCarInfo(HttpServletRequest request) {
		List<Map<String,Object>> queryAllCarType = cts.queryAllCarType();
		request.setAttribute("catTypeList", queryAllCarType);
		return "AddCar";
	}
	
	@RequestMapping("AddCarInfo.do")
	public String AddCarInfo(CarInfo car,HttpServletRequest request) {
		System.out.println(car.toString());
		int i = cs.insertCar(car);
		return "AddCar";
	}
	
	@RequestMapping("deleteCar.do")
	@ResponseBody
	public Map<String, Object> deleteCar(CarInfo car) {
		Map<String, Object> map = new HashMap<>();
		int i = cs.deleteCar(car.getCarId());
		if(i>0) {
			map.put("flag", true);
		}else {
			map.put("flag", false);
		}
		
		return map;
	}
	

	@RequestMapping("showUpdateCarInfo.do")
	public String showUpdateUserInfo(CarInfo car,HttpServletRequest request) {
		
		Map<String, Object> queryCarById = cs.queryCarById(car.getCarId());
		request.setAttribute("carMap", queryCarById);
		System.out.println(queryCarById);
		List<Map<String,Object>> queryAllCarType = cts.queryAllCarType();
		request.setAttribute("catTypeList", queryAllCarType);
		
		return "updateCar";
	}
	
	@RequestMapping("updateCarInfo.do")
	public String updateUserInfo(CarInfo car,HttpServletRequest request) {
		
		System.out.println(car.toString());
		
		int i = cs.updateCar(car);
		
		return "AddCar";
	}
	
	@RequestMapping("showApplyForCarInfo.do")
	public String showApplyForCarInfo(CarInfo car,HttpServletRequest request) {
		
		request.setAttribute("carId", car.getCarId());
		
		
		
		return "applyForCarInfo";
	}
	
	
	
	
	
	
	
	
	
}

package com.oracleoaec.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oracleoaec.service.RoleMenuService;

@Controller
public class RoleMenuController {
	
	@Autowired
	@Qualifier("roleMenuService")
	private RoleMenuService rms;
	
	@RequestMapping("queryMenu.do")
	public String fatherMenu(HttpServletRequest request) {
		Map<String, Object> userMap = (Map<String, Object>) request.getSession().getAttribute("userMap");
		Map<String, Object> fatherMap = rms.queryFathMenuByUserId(Integer.parseInt(userMap.get("USER_ID").toString()));
		request.setAttribute("fatherMap", fatherMap);
		
		List<Map<String, Object>> sonList = rms.querySonMenuByUserId(Integer.parseInt(fatherMap.get("MENU_ID").toString()));
		request.setAttribute("sonList", sonList);
		
		return "AdminIndex";
	}
	
}

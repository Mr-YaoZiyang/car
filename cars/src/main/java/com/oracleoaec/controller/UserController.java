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

import com.oracleoaec.pojo.User;
import com.oracleoaec.service.DeptService;
import com.oracleoaec.service.ProvinceCityService;
import com.oracleoaec.service.RoleService;
import com.oracleoaec.service.SexService;
import com.oracleoaec.service.UserService;

@Controller
public class UserController {

	@Autowired
	@Qualifier("userService")
	private UserService us;
	
	@Autowired
	@Qualifier("deptService")
	private DeptService ds;
	
	@Autowired
	@Qualifier("roleService")
	private RoleService rs;
	
	@Autowired
	@Qualifier("sexService")
	private SexService sexs;
	
	@Autowired
	@Qualifier("provinceCityService")
	private ProvinceCityService pcs;
	
	@RequestMapping("login.do")
	@ResponseBody
	public Map<String, Object> login(User user,HttpServletRequest request) {
		Map<String, Object> userMap = new HashMap<>();
		Map<String, Object> map = new HashMap<>();
		userMap.put("userAccount", user.getUserAccount());
		userMap.put("userPwd", user.getUserPwd());
		
		Map<String, Object> login = us.login(userMap);
		
		if(login!=null) {
			request.getSession().setAttribute("userMap", login);
			map.put("flag", true);
		}else {
			map.put("flag", false);
		}
		return map;
	}
	@RequestMapping("logout.do")
	public String logout(HttpServletRequest request) {
		
		request.getSession().setAttribute("userMap", null);
		
		return "login";
	}
	
	
	
	@RequestMapping("allUserInfo.do")
	@ResponseBody
	public List<Map<String,Object>> AllUserInfo(HttpServletRequest request) {
		
		List<Map<String,Object>> queryAllUsers = us.queryAllUsers();
		/*for (Map<String, Object> map : queryAllUsers) {
			System.out.println(map.toString());
		}*/
		return queryAllUsers;
		/*Integer pageNo=Integer.parseInt(request.getParameter("page"));
		Integer pageSize = Integer.parseInt(request.getParameter("rows"));
		return us.findByPage(pageNo, pageSize);
*/
	}
	
	@RequestMapping("showAddUserInfo.do")
	public String showAddUserInfo(HttpServletRequest request) {
		
		List<Map<String,Object>> provinceList = pcs.queryAllProvince();
		request.setAttribute("provinceList", provinceList);
		
		List<Map<String,Object>> roleList = rs.queryAllRole();
		request.setAttribute("roleList", roleList);
		
		List<Map<String, Object>> deptList = ds.queryAllDept();
		request.setAttribute("deptList", deptList);
		
		List<Map<String, Object>> sexList = sexs.queryAllSex();
		request.setAttribute("sexList", sexList);
		
		return "AddUser";
	}
	
	@RequestMapping("city.do")
	@ResponseBody
	public List<Map<String, Object>> cityInfo(HttpServletRequest request) {
		Integer provinceId = Integer.parseInt(request.getParameter("provinceId")) ;
		List<Map<String,Object>> cityList = pcs.queryAllCity(provinceId);
		return cityList;
	}
	
	@RequestMapping("AddUserInfo.do")
	public String AddUserInfo(User user,HttpServletRequest request) {
		int i = us.insertUser(user);
		if(i>0) {
			return "forward:allUserInfo.do";
		}else {
			return "redirect:showAddUserInfo.do";
		}
	}
	
	@RequestMapping("deleteUser.do")
	@ResponseBody
	public Map<String, Object> deleteUser(User user,HttpServletRequest request) {
		int i = us.deleteUser(user.getUserId());
		Map<String, Object> map = new HashMap<>();
		if(i>0) {
			map.put("flag", true);
		}else {
			map.put("flag", false);
		}
		return map;
	}
	
	@RequestMapping("showUpdateUserInfo.do")
	public String showUpdateUserInfo(User user,HttpServletRequest request) {
		
		Map<String, Object> queryUserById = us.queryUserById(user.getUserId());
		request.setAttribute("userMap", queryUserById);

		List<Map<String,Object>> provinceList = pcs.queryAllProvince();
		request.setAttribute("provinceList", provinceList);
		
		List<Map<String,Object>> roleList = rs.queryAllRole();
		request.setAttribute("roleList", roleList);
		
		List<Map<String, Object>> deptList = ds.queryAllDept();
		request.setAttribute("deptList", deptList);
		
		List<Map<String, Object>> sexList = sexs.queryAllSex();
		request.setAttribute("sexList", sexList);
		
		return "UpdateUser";
	}
	
	@RequestMapping("UpdateUserInfo.do")
	public String UpdateUserInfo(User user,HttpServletRequest request) {
		System.out.println(user.toString());
		int i = us.updateUser(user);
		if(i>0) {
			return "forward:allUserInfo.do";
		}else {
			return "redirect:showUpdateUserInfo.do";
		}
	}
		
	
}

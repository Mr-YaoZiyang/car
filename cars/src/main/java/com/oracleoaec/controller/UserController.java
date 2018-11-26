package com.oracleoaec.controller;

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

import com.oracleoaec.pojo.PageBean;
import com.oracleoaec.pojo.User;
import com.oracleoaec.service.DeptService;
import com.oracleoaec.service.PageService;
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
	
	@Autowired
	@Qualifier("pageService")
	private PageService ps;
	
	
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
	public PageBean AllUserInfo(HttpServletRequest request) {
		
		//List<Map<String,Object>> queryAllUsers = us.queryAllUsers();
		
		Integer pageNumber=Integer.parseInt(request.getParameter("page"));
		Integer pageSize=Integer.parseInt(request.getParameter("rows"));
		System.out.println(pageNumber+","+pageSize);
		/*String sql = "select * from users u " + 
				"		inner join roles r on r.role_id = u.role_id" + 
				"		inner join sex s on s.sex_id = u.sex_id" + 
				"		inner join dept d on d.dept_id = u.dept_id " + 
				"		inner join province p on p.province_id = u.province_id" + 
				"		inner join city c on c.city_id = u.city_id" + 
				"		where u.user_status = 1";*/
		Map<String, Object> pageMap = new HashMap<String, Object>();
		
		pageMap.put("pageNumber", pageNumber);
		pageMap.put("pageSize", pageSize);
		//pageMap.put("sql", sql);
		PageBean pageBean = us.findByPage(pageMap);
		System.out.println(pageBean.toString());
		return pageBean;
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
		return "AddUser";
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
	
	@RequestMapping("personalCenter.do")
	public String personalCenter(HttpServletRequest request) {

		List<Map<String,Object>> provinceList = pcs.queryAllProvince();
		request.setAttribute("provinceList", provinceList);
		
		List<Map<String,Object>> roleList = rs.queryAllRole();
		request.setAttribute("roleList", roleList);
		
		List<Map<String, Object>> deptList = ds.queryAllDept();
		request.setAttribute("deptList", deptList);
		
		List<Map<String, Object>> sexList = sexs.queryAllSex();
		request.setAttribute("sexList", sexList);
		
		return "personalCenter";
	}
	@RequestMapping("UpdateUserInfo.do")
	public String UpdateUserInfo(User user,HttpServletRequest request) {
		System.out.println(user.toString());
		int i = us.updateUser(user);
		return "AddUser";
	}
	@RequestMapping("deptEmployeesInfo.do")
	@ResponseBody
	public List<Map<String,Object>> deptEmployeesInfo(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Map userMap = (Map) session.getAttribute("userMap");
		Integer deptId = new Integer(userMap.get("DEPT_ID").toString());
		List<Map<String,Object>> list = us.queryDeptEmployees(deptId);
		
		return list;

	}
	@RequestMapping("editPersonalCenter.do")
	public String editPersonalCenter(User user,HttpServletRequest request) {
		System.out.println(user.toString());
		int i = us.editPersonalCenter(user);
		return "carInfo";
	}
	@RequestMapping("checkPwd.do")
	@ResponseBody
	public Map<String,Object> checkPwd(User user,HttpServletRequest request) {
		Map<String, Object> userMap = us.queryUserById(user.getUserId());
		Map<String, Object> map = new HashMap<>();
		if(user.getUserPwd().equals(userMap.get("USER_PWD"))) {
			map.put("flag", true);
		}else {
			map.put("flag", false);
		}
		return map;
	}
	@RequestMapping("updatePwd.do")
	@ResponseBody
	public Map<String,Object> updatePwd(User user,HttpServletRequest request) {
		int i = us.updateUserPwd(user);
		Map<String, Object> map = new HashMap<>();
		if(i>0) {
			map.put("flag", true);
		}else {
			map.put("flag", false);
		}
		return map;
	}
}

package com.oracleoaec.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.oracleoaec.mapper.UserMapper;
import com.oracleoaec.pojo.User;
import com.oracleoaec.service.UserService;

public class UserServiceImpl implements UserService {

	private UserMapper um;
	public UserMapper getUm() {
		return um;
	}
	public void setUm(UserMapper um) {
		this.um = um;
	}
	
	@Override
	public Map<String, Object> login(Map<String, Object> userMap) {
		Map<String, Object> login = um.login(userMap);
		return login;
	}
	
	@Override
	public List<Map<String, Object>> queryAllUsers() {
		List<Map<String, Object>> queryAllUsers = um.queryAllUsers();
		
		return queryAllUsers;
	}
	@Override
	public List<Map<String, Object>> findByPage(int pageNo, int pageSize) {
		Map<String, Object> map=new HashMap<String,Object>();
		map.put("pageNo", pageNo);
		map.put("pageSize", pageSize);
		return um.findByPage(map);
		//baseDao.findAll(UserInfo.class, map,"findByPage");
		
	}
	@Override
	public int insertUser(User user) {
		int i = um.insertUser(user);
		return i;
	}
	@Override
	public int deleteUser(Integer userId) {
		int i = um.deleteUser(userId);
		return i;
	}
	@Override
	public Map<String, Object> queryUserById(Integer userId) {
		Map<String, Object> queryUserById = um.queryUserById(userId);
		return queryUserById;
	}
	@Override
	public int updateUser(User user) {
		int i = um.updateUser(user);
		return i;
	}
	@Override
	public List<Map<String, Object>> queryDeptEmployees(Integer deptId) {
		List<Map<String,Object>> employeesList = um.queryDeptEmployees(deptId);
		return employeesList;
	}

}

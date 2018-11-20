package com.oracleoaec.service;

import java.util.List;
import java.util.Map;

import com.oracleoaec.pojo.User;

public interface UserService {
	/**
	 * 用户登录
	 * @param userMap
	 * @return
	 */
	Map<String, Object> login(Map<String, Object> userMap);
	/**
	 * 查找所有用户
	 * @return
	 */
	List<Map<String, Object>> queryAllUsers();
	/**
	 * 分页
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public List<Map<String, Object>> findByPage(int pageNo,int pageSize);
	/**
	 * 添加用户
	 * @param user
	 * @return
	 */
	int insertUser(User user);
	/**
	 * 删除用户
	 * @param userId
	 * @return
	 */
	int deleteUser(Integer userId);
	/**
	 * 根据用户id查找用户
	 * @param userId
	 * @return
	 */
	Map<String, Object> queryUserById(Integer userId);
	/**
	 * 修改用户
	 * @param user
	 * @return
	 */
	int updateUser(User user);
	
	List<Map<String, Object>> queryDeptEmployees(Integer deptId);
}

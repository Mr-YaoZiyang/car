package com.oracleoaec.service;

import java.util.List;
import java.util.Map;

import com.oracleoaec.pojo.User;

public interface UserService {
	/**
	 * �û���¼
	 * @param userMap
	 * @return
	 */
	Map<String, Object> login(Map<String, Object> userMap);
	/**
	 * ���������û�
	 * @return
	 */
	List<Map<String, Object>> queryAllUsers();
	/**
	 * ��ҳ
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public List<Map<String, Object>> findByPage(int pageNo,int pageSize);
	/**
	 * ����û�
	 * @param user
	 * @return
	 */
	int insertUser(User user);
	/**
	 * ɾ���û�
	 * @param userId
	 * @return
	 */
	int deleteUser(Integer userId);
	/**
	 * �����û�id�����û�
	 * @param userId
	 * @return
	 */
	Map<String, Object> queryUserById(Integer userId);
	/**
	 * �޸��û�
	 * @param user
	 * @return
	 */
	int updateUser(User user);
	
	List<Map<String, Object>> queryDeptEmployees(Integer deptId);
}

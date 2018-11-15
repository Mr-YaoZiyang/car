package com.oracleoaec.service;

import java.util.List;
import java.util.Map;

public interface RoleMenuService {

	Map<String, Object> queryFathMenuByUserId(Integer userId);
	
	List<Map<String, Object>> querySonMenuByUserId(Integer menuId);
}

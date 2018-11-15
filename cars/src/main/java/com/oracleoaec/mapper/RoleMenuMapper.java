package com.oracleoaec.mapper;

import java.util.List;
import java.util.Map;

public interface RoleMenuMapper {
	
	Map<String, Object> queryFathMenuByUserId(Integer userId);
	
	List<Map<String, Object>> querySonMenuByUserId(Integer menuId);
}

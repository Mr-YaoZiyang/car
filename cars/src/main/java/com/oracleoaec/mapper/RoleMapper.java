package com.oracleoaec.mapper;

import java.util.List;
import java.util.Map;

public interface RoleMapper {
	/**
	 * 查询所有的角色
	 * @return
	 */
	List<Map<String, Object>> queryAllRole();
}

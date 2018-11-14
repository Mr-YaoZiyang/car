package com.oracleoaec.service;

import java.util.List;
import java.util.Map;

public interface RoleService {
	/**
	 * 查询所有的角色
	 * @return
	 */
	List<Map<String, Object>> queryAllRole();
}

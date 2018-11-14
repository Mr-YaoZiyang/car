package com.oracleoaec.service;

import java.util.List;
import java.util.Map;

public interface DeptService {
	
	/**
	 * 查询所有的部门
	 * @return
	 */
	List<Map<String, Object>> queryAllDept();
}

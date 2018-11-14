package com.oracleoaec.mapper;

import java.util.List;
import java.util.Map;

public interface DeptMapper {
	/**
	 * 查询所有的部门
	 * @return
	 */
	List<Map<String, Object>> queryAllDept();
	
}

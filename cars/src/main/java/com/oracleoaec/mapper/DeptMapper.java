package com.oracleoaec.mapper;

import java.util.List;
import java.util.Map;

import com.oracleoaec.pojo.Dept;

public interface DeptMapper {
	/**
	 * 查询所有的部门
	 * @return
	 */
	List<Map<String, Object>> queryAllDept();
	
	Map<String, Object> queryDeptById(Integer deptId);
	
	int insertDept(Dept dept);
	
	int updateDept(Dept dept);
	
	int deleteDept(Integer deptId);
	
	
	
}

package com.oracleoaec.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.oracleoaec.pojo.PageBean;

public interface PageMapper {
	/**
	 * 查询分页数据
	 * @param pageMap
	 * @return
	 */
	List<Map<String, Object>> queryPageBean(Map<String, Object> pageMap);
	/**
	 * 查询总数
	 * @param sql
	 * @return
	 */
	Integer queryTotal(String sql1);
}

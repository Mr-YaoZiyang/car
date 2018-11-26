package com.oracleoaec.service;

import java.util.List;
import java.util.Map;

import com.oracleoaec.pojo.PageBean;

public interface PageService {
	/**
	 * 查询PageBean   rows
	 * @param pageMap
	 * @return
	 */
	List<Map<String, Object>> queryPageBean(Map<String, Object> pageMap);
	
	/**
	 * 查询总数
	 * @param sql
	 * @return
	 */
	Integer queryTotal(String sql);
}

package com.oracleoaec.service;

import java.util.List;
import java.util.Map;

import com.oracleoaec.pojo.PageBean;

public interface PageService {
	/**
	 * ��ѯPageBean   rows
	 * @param pageMap
	 * @return
	 */
	List<Map<String, Object>> queryPageBean(Map<String, Object> pageMap);
	
	/**
	 * ��ѯ����
	 * @param sql
	 * @return
	 */
	Integer queryTotal(String sql);
}

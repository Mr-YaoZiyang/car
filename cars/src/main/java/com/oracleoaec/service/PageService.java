package com.oracleoaec.service;

import java.util.Map;

import com.oracleoaec.pojo.PageBean;

public interface PageService {
	/**
	 * 
	 * @param pageMap
	 * @return
	 */
	PageBean queryPageBean(Map<String, Object> pageMap);
}

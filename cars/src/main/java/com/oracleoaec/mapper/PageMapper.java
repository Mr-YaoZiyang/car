package com.oracleoaec.mapper;

import java.util.Map;

import com.oracleoaec.pojo.PageBean;

public interface PageMapper {
	
	PageBean queryPageBean(Map<String, Object> pageMap);
	
}

package com.oracleoaec.service.impl;

import java.util.List;
import java.util.Map;

import com.oracleoaec.mapper.PageMapper;
import com.oracleoaec.pojo.PageBean;
import com.oracleoaec.service.PageService;

public class PageServiceImpl implements PageService {

	private PageMapper pm;	
	public PageMapper getPm() {
		return pm;
	}
	public void setPm(PageMapper pm) {
		this.pm = pm;
	}
	
	@Override
	public List<Map<String, Object>> queryPageBean(Map<String, Object> pageMap) {
		List<Map<String, Object>> queryPageBean = pm.queryPageBean(pageMap);
		return queryPageBean;
	}
	@Override
	public Integer queryTotal(String sql) {
		Integer queryTotal = pm.queryTotal(sql);
		return queryTotal;
	}

}

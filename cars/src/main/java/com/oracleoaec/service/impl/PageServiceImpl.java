package com.oracleoaec.service.impl;

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
	public PageBean queryPageBean(Map<String, Object> pageMap) {
		PageBean queryPageBean = pm.queryPageBean(pageMap);
		return queryPageBean;
	}

}

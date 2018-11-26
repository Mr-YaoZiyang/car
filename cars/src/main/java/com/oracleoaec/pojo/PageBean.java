package com.oracleoaec.pojo;

import java.util.List;
import java.util.Map;

public class PageBean {
	
	private List<Map<String, Object>> rows;
	private Integer total;
	
	public List<Map<String, Object>> getRows() {
		return rows;
	}
	public void setRows(List<Map<String, Object>> rows) {
		this.rows = rows;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	@Override
	public String toString() {
		return "PageBean [rows=" + rows + ", total=" + total + "]";
	}
	public PageBean(List<Map<String, Object>> rows, Integer total) {
		super();
		this.rows = rows;
		this.total = total;
	}
	public PageBean() {
		super();
	}
	
	
}

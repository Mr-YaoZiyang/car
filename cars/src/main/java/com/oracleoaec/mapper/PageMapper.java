package com.oracleoaec.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.oracleoaec.pojo.PageBean;

public interface PageMapper {
	/**
	 * ��ѯ��ҳ����
	 * @param pageMap
	 * @return
	 */
	List<Map<String, Object>> queryPageBean(Map<String, Object> pageMap);
	/**
	 * ��ѯ����
	 * @param sql
	 * @return
	 */
	Integer queryTotal(String sql1);
}

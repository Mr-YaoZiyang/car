package com.oracleoaec.mapper;

import java.util.List;
import java.util.Map;

public interface SexMapper {
	/**
	 * 查询所有的性别
	 * @return
	 */
	List<Map<String, Object>> queryAllSex();
}

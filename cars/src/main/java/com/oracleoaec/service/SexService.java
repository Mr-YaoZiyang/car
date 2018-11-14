package com.oracleoaec.service;

import java.util.List;
import java.util.Map;

public interface SexService {

	/**
	 * 查询所有的性别
	 * @return
	 */
	List<Map<String, Object>> queryAllSex();
}

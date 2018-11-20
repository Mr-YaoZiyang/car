package com.oracleoaec.service;

import java.util.List;
import java.util.Map;

import com.oracleoaec.pojo.CarAppForm;

public interface CarappformService {
	
	List<Map<String, Object>> queryCarappForm();
	
	Map<String, Object> queryCarappFormById(Integer carAppId);
	
	int insertCarAppForm(CarAppForm caf);
	
	int updateCarAppForm(CarAppForm caf);
	
	List<Map<String, Object>> queryCarappFormByUserId(Integer userId);
	/**
	 * ��ѯ�����������������ĳ���
	 * @param pendingMap  map���������벿�ź�����״̬
	 * @return
	 */
	List<Map<String, Object>> querycarPending(Map<String, Object> pendingMap);
	
	int sendedCar(CarAppForm caf);
	
	int returnCar(CarAppForm caf);
	
	int putStorage(CarAppForm caf);
}

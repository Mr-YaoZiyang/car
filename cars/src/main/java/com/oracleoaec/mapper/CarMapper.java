package com.oracleoaec.mapper;

import java.util.List;
import java.util.Map;

import com.oracleoaec.pojo.CarInfo;

public interface CarMapper {
	
	List<Map<String, Object>> queryAllCar();
	
	Map<String, Object> queryCarById(Integer carId);
	
	int insertCar(CarInfo car);
	
	int deleteCar(Integer carId);
	
	int updateCar(CarInfo car);
	/**
	 * ����ռ�ã��������ʱ����³���״̬
	 * @param car
	 * @return
	 */
	int takeUpcar(CarInfo car);
	/**
	 * �����У����ռ��    ������ʱ�����״̬
	 * @param car
	 * @return
	 */
	int freeCar(CarInfo car);
	/**
	 * �����û�չʾ�ĳ���
	 * @return
	 */
	List<Map<String, Object>> queryAllUserCar();
}

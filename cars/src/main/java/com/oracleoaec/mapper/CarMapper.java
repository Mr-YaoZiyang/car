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
	 * 车已占用，当申请的时候更新车的状态
	 * @param car
	 * @return
	 */
	int takeUpcar(CarInfo car);
	/**
	 * 车空闲，解除占用    还车的时候更新状态
	 * @param car
	 * @return
	 */
	int freeCar(CarInfo car);
	/**
	 * 对于用户展示的车辆
	 * @return
	 */
	List<Map<String, Object>> queryAllUserCar();
}

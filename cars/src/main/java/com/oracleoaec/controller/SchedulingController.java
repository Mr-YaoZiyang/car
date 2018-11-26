package com.oracleoaec.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oracleoaec.pojo.CarAppForm;
import com.oracleoaec.pojo.CarInfo;
import com.oracleoaec.pojo.PageBean;
import com.oracleoaec.pojo.Scheduling;
import com.oracleoaec.service.CarService;
import com.oracleoaec.service.CarappformService;
import com.oracleoaec.service.PageService;
import com.oracleoaec.service.SchedulingService;

@Controller
public class SchedulingController {
	
	@Autowired
	@Qualifier("schedulingService")
	private SchedulingService ss;
	
	@Autowired
	@Qualifier("carappformService")
	private CarappformService cs;
	
	@Autowired
	@Qualifier("carService")
	private CarService cser;

	@Autowired
	@Qualifier("pageService")
	private PageService ps;
	
	@RequestMapping("schedulingInfo.do")
	public String schedulingInfo(Scheduling scheduling,HttpServletRequest request) {
		int i = ss.insertScheduling(scheduling);
		Integer schedulingId = scheduling.getSchedulingId();
		request.setAttribute("schedulingId", schedulingId);
		if(i>0) {
			CarInfo car = new CarInfo();
			car.setCarId(scheduling.getCarId());
			cser.takeUpcar(car);
			return "forward:applyForCarInfo.do";
		}else {
			return "applyForCarInfo";
		}
		
	}
	@RequestMapping("allSchedulingInfo.do")
	@ResponseBody
	public PageBean allSchedulingInfo(Scheduling scheduling,HttpServletRequest request) {
		Integer pageNumber=Integer.parseInt(request.getParameter("page"));
		Integer pageSize=Integer.parseInt(request.getParameter("rows"));
		System.out.println(pageNumber+","+pageSize);
		String sql = "select * from scheduling s" + 
				"	    join users u on u.user_id = s.user_id" + 
				"	    join carInfo c on c.car_id = s.car_id";
		Map<String, Object> pageMap = new HashMap<String, Object>();
		
		pageMap.put("pageNumber", pageNumber);
		pageMap.put("pageSize", pageSize);
		pageMap.put("sql", sql);
		List<Map<String, Object>> rows = ps.queryPageBean(pageMap);
		String sql1= "select count(*) from scheduling s" + 
				"	    join users u on u.user_id = s.user_id" + 
				"	    join carInfo c on c.car_id = s.car_id";
		Integer total = ps.queryTotal(sql1);
		PageBean pageBean = new PageBean();
		pageBean.setRows(rows);
		pageBean.setTotal(total);
		return pageBean;
	}
	
	@RequestMapping("readySendCar.do")
	@ResponseBody
	public PageBean readySendCar(HttpServletRequest request) {
		
		Integer pageNumber=Integer.parseInt(request.getParameter("page"));
		Integer pageSize=Integer.parseInt(request.getParameter("rows"));
		System.out.println(pageNumber+","+pageSize);
		String sql = "select * from scheduling s" + 
				"      join users u on u.user_id = s.user_id" + 
				"      join carInfo c on c.car_id = s.car_id " + 
				"      join carappform caf on caf.scheduling_id = s.scheduling_id" + 
				"	    where caf.approver_status = 2";
		Map<String, Object> pageMap = new HashMap<String, Object>();
		
		pageMap.put("pageNumber", pageNumber);
		pageMap.put("pageSize", pageSize);
		pageMap.put("sql", sql);
		List<Map<String, Object>> rows = ps.queryPageBean(pageMap);
		String sql1=  "select count(*) from scheduling s" + 
				"      join users u on u.user_id = s.user_id" + 
				"      join carInfo c on c.car_id = s.car_id " + 
				"      join carappform caf on caf.scheduling_id = s.scheduling_id" + 
				"	    where caf.approver_status = 2";
		Integer total = ps.queryTotal(sql1);
		PageBean pageBean = new PageBean();
		pageBean.setRows(rows);
		pageBean.setTotal(total);
		return pageBean;
	}
	
	@RequestMapping("showSchedulingInfo.do")
	public String showSchedulingInfo(Scheduling scheduling,HttpServletRequest request) {
		
		request.setAttribute("schedulingId", scheduling.getSchedulingId());
		
		
		return "sendCarInfo";
	}
	@RequestMapping("sendCar.do")
	public String sendCar(Scheduling scheduling,HttpServletRequest request) {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		scheduling.setActualLeavingDate(sdf.format(date));
		System.out.println(scheduling.toString());
		int i = ss.sendCar(scheduling);
		CarAppForm caf = new CarAppForm();
		caf.setSchedulingId(scheduling.getSchedulingId());
		
		
		int sendedCar = cs.sendedCar(caf);
		
		
		return "sendCarInfo";
	}
	
	@RequestMapping("readyPutStorage.do")
	@ResponseBody
	public PageBean readyPutStorage(HttpServletRequest request) {
		
		Integer pageNumber=Integer.parseInt(request.getParameter("page"));
		Integer pageSize=Integer.parseInt(request.getParameter("rows"));
		System.out.println(pageNumber+","+pageSize);
		String sql = "select * from scheduling s" + 
				"      join users u on u.user_id = s.user_id" + 
				"      join carInfo c on c.car_id = s.car_id " + 
				"      join carappform caf on caf.scheduling_id = s.scheduling_id" + 
				"	    where caf.approver_status = 5";
		Map<String, Object> pageMap = new HashMap<String, Object>();
		
		pageMap.put("pageNumber", pageNumber);
		pageMap.put("pageSize", pageSize);
		pageMap.put("sql", sql);
		List<Map<String, Object>> rows = ps.queryPageBean(pageMap);
		String sql1=  "select count(*) from scheduling s" + 
				"      join users u on u.user_id = s.user_id" + 
				"      join carInfo c on c.car_id = s.car_id " + 
				"      join carappform caf on caf.scheduling_id = s.scheduling_id" + 
				"	    where caf.approver_status = 5";
		Integer total = ps.queryTotal(sql1);
		PageBean pageBean = new PageBean();
		pageBean.setRows(rows);
		pageBean.setTotal(total);
		return pageBean;
		
	}
	@RequestMapping("showPutStorage.do")
	public String showPutStorage(Scheduling scheduling,HttpServletRequest request) {
		
		request.setAttribute("schedulingId", scheduling.getSchedulingId());
		
		
		return "putStorageInfo";
	}
	
	@RequestMapping("putStorage.do")
	public String putStorage(Scheduling scheduling,HttpServletRequest request) {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		scheduling.setStoragetime(sdf.format(date));
		System.out.println(scheduling.toString());
		int i = ss.putStorage(scheduling);
		//根据scheduling的id获取map
		Map<String, Object> schedulingMap = ss.querySchedulingById(scheduling.getSchedulingId());
		System.out.println(schedulingMap.toString());
		//在根据scheduling的map获取carId
		CarInfo car = new CarInfo();
		car.setCarId(new Integer(schedulingMap.get("CAR_ID").toString()));
		//获得carid将车的状态做改变
		int freeCar = cser.freeCar(car);
		//将申请表的状态改为   已入库
		CarAppForm caf = new CarAppForm();
		caf.setSchedulingId(scheduling.getSchedulingId());

		int putStorage = cs.putStorage(caf);
		
		
		return "putStorageInfo";
	}
		
}

package com.oracleoaec.interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


public class LoginInterceptor implements HandlerInterceptor {
	/**
	 * controller ִ��֮�� ������ͼ����ô˷���
	 * 
	 * ��¼��־ ������Դ
	 */
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}
	/**
	 * controller ִ��֮�� ������ͼ֮ǰ���ô˷���
	 * 
	 * ����ͼ��ȾһЩ����
	 */
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	/**
	 * controller ִ��֮ǰ
	 * 
	 * 
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) throws Exception {
		
		HttpSession session = request.getSession();
		
		Map <String,Object> userMap =(Map) session.getAttribute("userMap");
		
		if(userMap == null) {
			String contextPath = request.getContextPath();
			response.sendRedirect(contextPath+"/login.jsp");
			return false;
		}else {
			return true;
		}
		
		
		
		
		
	}

}

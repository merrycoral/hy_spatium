package com.urban.spatium.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class LoginInterceptor implements HandlerInterceptor{
	
	
	private static final Logger log = LoggerFactory.getLogger(LoginInterceptor.class);

	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
	
		HttpSession session = request.getSession();
		//세션 값 가져오기
		String sessionId 	= (String) session.getAttribute("SID");
		System.out.println("로그인 인터셉터 세션 아이디 : "+sessionId);
		String sessionLevel = (String) session.getAttribute("SLEVEL");
		System.out.println("로그인 인터셉터 세션 레벨 : "+sessionLevel);
		String requestUri	= request.getRequestURI();
		
		//관리자1 판매자2 구매자3
		if(sessionId == null) {
			if(		requestUri.indexOf("/addUser") 		> -1 || requestUri.indexOf("/index") > -1
				||  requestUri.indexOf("/storeInfo") 	> -1 ||	requestUri.indexOf("/searchAll") > -1
				||	requestUri.indexOf("/imsilogin") 	> -1) {//requestUri 에 "/addmember"가 존재한다면
				return true;
			}else {
				response.sendRedirect("/login");
				return false;
			}
		}else {
			if(sessionLevel != null && "2".equals(sessionLevel)){ //판매자가 접근하면 안되는곳들
				if( //회원 관련 경로
					  requestUri.indexOf("/userList") 	> -1	|| requestUri.indexOf("/restUser") 	> -1
				   || requestUri.indexOf("/blackUser") 	> -1 	|| requestUri.indexOf("/deleteUser") 	> -1
				   || requestUri.indexOf("/pointList") 	> -1 	|| requestUri.indexOf("/bookMarkList") 	> -1
				   //예약 관련 경로
				   || requestUri.indexOf("/rsvStoreList") 	> -1 	|| requestUri.indexOf("/rsvListAdmin") 	> -1
				   || requestUri.indexOf("/rsvDetailListAdmin")> -1 || requestUri.indexOf("/rsvListExtendAdmin") 	> -1
				   || requestUri.indexOf("/rsvInsertAdmin")> -1 || requestUri.indexOf("/rsvInsertDayAdmin") 	> -1
				   || requestUri.indexOf("/rsvStatAdmin") 	> -1 ) {
					response.sendRedirect("/");
					return false;
				}
			}
			if(sessionLevel != null && ("3".equals(sessionLevel)||"6".equals(sessionLevel))){ //구매자, 불량회원이 접근하면 안되는곳들
				if( //회원 관련 경로  
					   requestUri.indexOf("/userList") 		> -1	|| requestUri.indexOf("/restUser") 	> -1
					|| requestUri.indexOf("/blackUser") 	> -1 	|| requestUri.indexOf("/deleteUser") 	> -1
					|| requestUri.indexOf("/pointList") 	> -1 	|| requestUri.indexOf("/bookMarkList") 	> -1
					|| requestUri.indexOf("/admin") 	> -1 
					//예약 관련 경로
					|| requestUri.indexOf("/rsvStoreList") 	> -1 	 || requestUri.indexOf("/rsvListAdmin") 	> -1
				    || requestUri.indexOf("/rsvDetailListAdmin")> -1 || requestUri.indexOf("/rsvListExtendAdmin") 	> -1
				    || requestUri.indexOf("/rsvInsertAdmin")> -1	 || requestUri.indexOf("/rsvInsertDayAdmin") 	> -1
					|| requestUri.indexOf("/rsvStatAdmin") 	> -1 	) {
					response.sendRedirect("/");
					return false;
				}				
			}
		}
		
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}
}

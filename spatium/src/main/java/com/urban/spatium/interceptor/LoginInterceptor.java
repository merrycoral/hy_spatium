package com.urban.spatium.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class LoginInterceptor implements HandlerInterceptor{
	
	
	//private static final Logger log = LoggerFactory.getLogger(LoginInterceptor.class);
	
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
		if(sessionId == null) {//비로그인시 접근 가능한곳
			if(		requestUri.indexOf("/userJoin") 		> -1 || requestUri.indexOf("/index") > -1
				||  requestUri.indexOf("/storeInfo") 	> -1 ||	requestUri.indexOf("/searchAll") > -1
				||	requestUri.indexOf("/imsilogin") 	> -1 ||	requestUri.indexOf("/adressAjax") > -1
				||	requestUri.indexOf("/addbookMark") > -1	 ||	requestUri.indexOf("/idCheck") > -1
				||	requestUri.indexOf("/idChk") > -1		 ||	requestUri.indexOf("/findId") > -1
				) {
				return true;
			}else {
				response.sendRedirect("/login");
				return false;
			}
		}else {//로그인시
			//판매자가 접근하면 안되는곳들
			if(sessionLevel != null && "2".equals(sessionLevel)){//판매자에게 추가적으로 허락된곳
				if(requestUri.indexOf("/admin/") 	> -1) {
					response.sendRedirect("/");
					return false;
				}
			}

			//구매자, 불량회원이 접근하면 안되는곳들
			if(sessionLevel != null && ("3".equals(sessionLevel)||"6".equals(sessionLevel))){ 
				if( //회원 관련 경로  
					   requestUri.indexOf("/admin/")	> -1	|| requestUri.indexOf("/seller/") 	> -1
					   || requestUri.equals("/admin")
					) {
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

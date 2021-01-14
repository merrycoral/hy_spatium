package com.urban.spatium;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

public class URLgetter {
	public static String getURL(HttpServletRequest request) {
		// 어떤분이 작성하신 코드 들고왔습니다.
		// http://theeye.pe.kr/archives/442 
	    Enumeration<?> param = request.getParameterNames();

	    StringBuffer strParam = new StringBuffer();
	    StringBuffer strURL = new StringBuffer();

	    if (param.hasMoreElements()) {
	      strParam.append("?");
	    }

	    while (param.hasMoreElements()) {
	      String name = (String) param.nextElement();
	      String value = request.getParameter(name);

	      strParam.append(name + "=" + value);

	      if (param.hasMoreElements())
	      {
	        strParam.append("&");
	      }
	  }

	  strURL.append(request.getRequestURI());
	  strURL.append(strParam);

	  return strURL.toString();
	}
}

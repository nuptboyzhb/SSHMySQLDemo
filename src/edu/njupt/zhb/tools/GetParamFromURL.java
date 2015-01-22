/*
 *@author: ZhengHaibo  
 *web:     http://blog.csdn.net/nuptboyzhb
 *mail:    zhb931706659@126.com
 *2013-10-26  Nanjing,njupt,China
 */

package edu.njupt.zhb.tools;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import javax.servlet.http.HttpServletRequest;

public class GetParamFromURL {
	
	public static String getParam(HttpServletRequest request, String paramName) {
		String param = request.getParameter(paramName);
		if (param != null && param.trim().length() > 0) {
			try {
				param = URLDecoder.decode(param, "UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		if (param == null) {
			param = "";
		}
		return param;
	}

}

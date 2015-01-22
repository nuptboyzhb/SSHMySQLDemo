/*
 * $filename: BaseAction.java,v $
 * $Date: Sep 7, 2013  $
 * Copyright (C) ZhengHaibo, Inc. All rights reserved.
 * This software is Made by Zhenghaibo.
 */
package edu.njupt.zhb.action;

/*
 * @author: ZhengHaibo web: http://blog.csdn.net/nuptboyzhb mail:
 * zhb931706659@126.com Sep 7, 2013 Nanjing,njupt,China
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import edu.njupt.zhb.model.Userinfo;
import edu.njupt.zhb.utils.TipsMsg;
public class BaseAction extends ActionSupport implements ServletResponseAware, ServletRequestAware {
	private static final long serialVersionUID = -4680147793230090261L;

	private static final String CURRENTUSER = "user";

	public static HttpServletRequest getRequest(){
		return ServletActionContext.getRequest();
	}

	public static HttpSession getSession() {
		return getRequest().getSession();
	}

	public static HttpServletResponse getResponse() {
		HttpServletResponse response = ServletActionContext.getResponse();
		if(getRequest().getHeader("mobile") == null){
			response.setContentType("text/html;charset=UTF-8");//浏览器
			return response;
		}
		//android
		response.setContentType("application/json;charset=utf-8");
		return response;
	}
	
	public String getBasePath(){
		ActionContext ac = ActionContext.getContext();
        ServletContext sc = (ServletContext) ac.get(ServletActionContext.SERVLET_CONTEXT);
        String basePath = sc.getRealPath("/");
        return basePath;
	}
	
	public static PrintWriter getPrintWriter() {
		PrintWriter pw = null;
		try {
			pw = getResponse().getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return pw;
	}

	public static String getUUID() {
		return UUID.randomUUID().toString();
	}

	public static void setCurrentUser(Userinfo entity) {
		getSession().setAttribute(CURRENTUSER, entity);
	};

	public static Userinfo getCurrentUser(){
		return (Userinfo)getSession().getAttribute(CURRENTUSER);
	}

	public static void removeCurrentUser() {
		getSession().removeAttribute(CURRENTUSER);
	}

	public static void removeSession(String name) {
		getSession().removeAttribute(name);
	}

	public static void clearSession() {
		getSession().invalidate();
	}

	public void WriterNull() {
		getPrintWriter().write("[]");
	}

	public void WriterHTML(String html) {
		getPrintWriter().write(html);
	}
	
	public void writeStr(String str){
		this.getWriter().write(str);
	}
	
	public PrintWriter getWriter(){
		try {
			return getResponse().getWriter();
		} catch (IOException e) {
		}
		return null;
	}
	
	public String getServerPath(){
		String resultString = "http://"+getRequest().getServerName()+":"+getRequest().getServerPort()+"/"+getRequest().getContextPath()+"//";
		return resultString;
	}
	
	/**
     * 添加cookie 
     * 注意：一次性只能添加小于4K字节的文件
     * 编码方法：UTF-8
     * 有效时间：1小时
     * @return
     * @throws Exception
     */
    public void addCookie(String name,String value){
    	try {
			value = URLEncoder.encode(value,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        Cookie cookie = new Cookie(name, value);
        cookie.setMaxAge(60*60);//一个小时
        servletResponse.addCookie(cookie);
    }
    /**
     * Cookie
     * @return
     * @throws Exception
     */
    public String getCookie(String name){
        Cookie[] cookies = servletRequest.getCookies();
        for(Cookie cookie : cookies)
        {
            if(cookie.getName().equals(name))
            {
            	String value=cookie.getValue();
				try {
					value = URLDecoder.decode(value, "UTF-8");
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                return value;
            }
        }
        return null;
    }
    
    public String ObjectToJson(Object obj){
    	return JSONObject.fromObject(obj).toString();
    }
    protected HttpServletResponse servletResponse;
	@Override
	public void setServletResponse(HttpServletResponse servletResponse) {
		// TODO Auto-generated method stub
		this.servletResponse = servletResponse;
	}

	protected HttpServletRequest servletRequest;
	@Override
	public void setServletRequest(HttpServletRequest servletRequest) {
		// TODO Auto-generated method stub
		this.servletRequest = servletRequest;
	}
	public int page;//DataGrid中的页数
	public int rows;//DataGrid中的每页的条数

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}
	
	public boolean isLogin(){
		if(getCurrentUser() == null){
			TipsMsg tips = new TipsMsg();
			tips.setId("-1");
			tips.setMsg("not login");
			getPrintWriter().write(JSONArray.fromObject(tips).toString());
			return false;
		}
		return true;
	}
	
	public boolean isMobile(){
		if(getRequest().getHeader("mobile") != null){
			return true;
		}
		return false;
	}
	
	public void writeTips(String id,String msg){
		TipsMsg tips = new TipsMsg();
		tips.setId(id);
		tips.setMsg(msg);
		writeStr(JSONObject.fromObject(tips).toString());
	}
	
}

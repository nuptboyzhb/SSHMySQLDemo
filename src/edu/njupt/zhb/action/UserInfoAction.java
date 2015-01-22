/*
 * $filename: VideoInfoAction.java,v $
 * $Date: 2014-1-2  $
 * Copyright (C) ZhengHaibo, Inc. All rights reserved.
 * This software is Made by Zhenghaibo.
 */
package edu.njupt.zhb.action;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.UUID;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import edu.njupt.zhb.model.Userinfo;
import edu.njupt.zhb.service.UserInfoService;
import edu.njupt.zhb.utils.MyConstants;
import edu.njupt.zhb.utils.TipsMsg;
import edu.njupt.zhb.utils.Utils;

/*
 *@author: ZhengHaibo  
 *web:     http://blog.csdn.net/nuptboyzhb
 *GitHub   https://github.com/nuptboyzhb
 *mail:    zhb931706659@126.com
 *2014-1-2  Nanjing,njupt,China
 */
public class UserInfoAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3321845277376234101L;
	private Userinfo userinfo;
	private String userId;
	private String username;
	private String password;
	private String reserve1;
	private String reserve2;
	public String getReserve1() {
		return reserve1;
	}

	public void setReserve1(String reserve1) {
		this.reserve1 = reserve1;
	}

	public String getReserve2() {
		return reserve2;
	}

	public void setReserve2(String reserve2) {
		this.reserve2 = reserve2;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Userinfo getUserinfo() {
		return userinfo;
	}

	public void setUserinfo(Userinfo userinfo) {
		this.userinfo = userinfo;
	}

	private UserInfoService userInfoService;

	public UserInfoService getUserInfoService() {
		return userInfoService;
	}

	public void setUserInfoService(UserInfoService userInfoService) {
		this.userInfoService = userInfoService;
	}

	public void getUserInfoList() {

		String jsonResult = userInfoService.getUserInfoList(page, rows);
		if(MyConstants.LOG_DEBUG){
			System.out.println(jsonResult);
		}
		super.writeStr(jsonResult);
	}

	/**
	 * 添加用户
	 * 
	 * @return
	 */
	public void addUser() {
		if (userinfo == null) {
			TipsMsg tips = new TipsMsg();
			tips.setMsg("添加失败！对象为空");
			getPrintWriter().write(JSONArray.fromObject(tips).toString());
			return;
		}
		userinfo.setUuid(UUID.randomUUID() + "");
		userinfo.setRegistertime(Utils.getNowTime());
		String jsonResult = userInfoService.addUser(userinfo);
		writeStr(jsonResult);
	}
	
	public void register() throws UnsupportedEncodingException{
		if(null == username || password ==null){
			writeTips("-1","用户名或密码为空！");
			return;
		}
		Userinfo user = new Userinfo();
		user.setUuid(UUID.randomUUID().toString());
		user.setUsername(URLDecoder.decode(username,"UTF-8"));
		user.setPassword(password);
		user.setImageheadurl("");
		user.setLevel(new Integer(1));
		user.setRegistertime(Utils.getNowTime());
		user.setReserve1(reserve1);
		user.setReserve2(reserve2);
		String jsonResult  = userInfoService.addUser(user);
		writeStr(jsonResult);
	}

	/**
	 * 删除用户
	 * 
	 * @return
	 */
	public void deleteUser() {
		
		if (userId == null) {
			TipsMsg tips = new TipsMsg();
			tips.setMsg("删除失败！学号无效");
			getPrintWriter().write(JSONArray.fromObject(tips).toString());
			return;
		}
		String jsonResult = userInfoService.deleteUser(userId);
		writeStr(jsonResult);
	}

	/**
	 * 编辑用户
	 * 
	 * @return
	 */
	public void editUser() {
		if (userinfo == null) {
			TipsMsg tips = new TipsMsg();
			tips.setMsg("编辑失败！对象为空");
			getPrintWriter().write(JSONArray.fromObject(tips).toString());
			return;
		}
		userinfo.setUuid(userId);
		String jsonResult = userInfoService.editUser(userinfo);
		writeStr(jsonResult);
	}

	public void login() {
		TipsMsg tipsMsg = new TipsMsg();
		if(username==null){
			tipsMsg.setId("1");
			tipsMsg.setMsg("用户名为空！");
			String result = JSONObject.fromObject(tipsMsg).toString();
			super.writeStr(result);
			return;
		}
		Userinfo userinfo = userInfoService.getUserInfoByName(username);
		if(userinfo==null){
			tipsMsg.setId("1");
			tipsMsg.setMsg("用户名不存在");
			String result = JSONObject.fromObject(tipsMsg).toString();
			super.writeStr(result);
			return;
		}
		if(!userinfo.getPassword().equals(password)){
			tipsMsg.setId("1");
			tipsMsg.setMsg("用户名或密码错误");
			String result = JSONObject.fromObject(tipsMsg).toString();
			super.writeStr(result);
			return;
		}
		super.setCurrentUser(userinfo);
		tipsMsg.setId("2");
		tipsMsg.setMsg("登录成功");
		String result = JSONObject.fromObject(tipsMsg).toString();
		super.writeStr(result);
		return;
	}
}

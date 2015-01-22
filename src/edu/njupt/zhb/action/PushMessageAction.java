/*
 * $filename: VideoInfoAction.java,v $
 * $Date: 2014-1-2  $
 * Copyright (C) ZhengHaibo, Inc. All rights reserved.
 * This software is Made by Zhenghaibo.
 */
package edu.njupt.zhb.action;

import java.io.UnsupportedEncodingException;
import java.util.UUID;

import net.sf.json.JSONObject;
import edu.njupt.zhb.model.Bbsmessage;
import edu.njupt.zhb.model.Userinfo;
import edu.njupt.zhb.service.BbsMessageService;
import edu.njupt.zhb.utils.MyConstants;
import edu.njupt.zhb.utils.TipsMsg;
import edu.njupt.zhb.utils.Utils;

/*
 *@author: ZhengHaibo  
 *web:     http://blog.csdn.net/nuptboyzhb
 *GitHub   https://github.com/nuptboyzhb
 *mail:    zhb931706659@126.com
 *2015-1-12  Nanjing,njupt,China
 */
public class PushMessageAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4402580705005350089L;
	private BbsMessageService bbsMessageService;
	private String uuid;
	private String username;
	private String content;
	private String imageheadurl;
	private String address;
	private String phonemodel;
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

	public BbsMessageService getBbsMessageService() {
		return bbsMessageService;
	}

	public void setBbsMessageService(BbsMessageService bbsMessageService) {
		this.bbsMessageService = bbsMessageService;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getImageheadurl() {
		return imageheadurl;
	}

	public void setImageheadurl(String imageheadurl) {
		this.imageheadurl = imageheadurl;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhonemodel() {
		return phonemodel;
	}

	public void setPhonemodel(String phonemodel) {
		this.phonemodel = phonemodel;
	}

	public void getBbsMessageList() {
		String jsonResult = bbsMessageService.getBbsmessageList(page, rows);
		if(MyConstants.LOG_DEBUG){
			System.out.println(jsonResult);
		}
		super.writeStr(jsonResult);
	}

	public void addBbsMessage() throws UnsupportedEncodingException {
		if (!isLogin()) {
			return;
		}
		if (!isMobile()) {
			return;
		}
		Userinfo user = getCurrentUser();
		if (Utils.isNull(content) || Utils.isNull(user.getUsername())) {
			TipsMsg tips = new TipsMsg();
			tips.setId("-1");
			tips.setMsg("null content or name");
			writeStr(JSONObject.fromObject(tips).toString());
			return;
		}
		Bbsmessage bbsmessage = new Bbsmessage();
		bbsmessage.setUuid(UUID.randomUUID().toString());
		bbsmessage.setUsername(user.getUsername());
		bbsmessage.setContent(Utils.decodeUTF8(content));
		bbsmessage.setImageheadurl(Utils.decodeUTF8(imageheadurl));
		bbsmessage.setAgree(new Integer(0));
		bbsmessage.setDisagree(new Integer(0));
		bbsmessage.setShare(new Integer(0));
		bbsmessage.setAddress(Utils.decodeUTF8(address));
		bbsmessage.setDate(Utils.getNowTime());
		bbsmessage.setTop(new Integer(0));
		bbsmessage.setPhonemodel(Utils.decodeUTF8(phonemodel));
		bbsmessage.setReserve1(Utils.decodeUTF8(reserve1));
		bbsmessage.setReserve2(Utils.decodeUTF8(reserve2));
		String tips = bbsMessageService.addBbsmessage(bbsmessage);
		writeStr(tips);
	}
}

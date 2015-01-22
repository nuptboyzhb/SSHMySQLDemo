/*
 * $filename: DataGridDemoService.java,v $
 * $Date: 2013-10-26  $
 * Copyright (C) ZhengHaibo, Inc. All rights reserved.
 * This software is Made by Zhenghaibo.
 */
package edu.njupt.zhb.service;

import edu.njupt.zhb.model.Bbsmessage;

/*
 *@author: ZhengHaibo  
 *web:     http://blog.csdn.net/nuptboyzhb
 *mail:    zhb931706659@126.com
 *2013-10-26  Nanjing,njupt,China
 */
public interface BbsMessageService {
	public String getBbsmessageList(int page, int rows);
	public String addBbsmessage(Bbsmessage bbsmessage);
	public String deleteBbsmessage(String bbsmessageid);
	public String editBbsmessage(Bbsmessage bbsmessage);
}

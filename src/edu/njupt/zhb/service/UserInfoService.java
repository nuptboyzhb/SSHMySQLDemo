/*
 * $filename: VideoInfoService.java,v $
 * $Date: 2014-1-2  $
 * Copyright (C) ZhengHaibo, Inc. All rights reserved.
 * This software is Made by Zhenghaibo.
 */
package edu.njupt.zhb.service;

import edu.njupt.zhb.model.Userinfo;

/*
 *@author: ZhengHaibo  
 *web:     http://blog.csdn.net/nuptboyzhb
 *GitHub   https://github.com/nuptboyzhb
 *mail:    zhb931706659@126.com
 *2014-1-2  Nanjing,njupt,China
 */
public interface UserInfoService {

	String getUserInfoList(int page, int rows);

	String addUser(Userinfo userinfo);

	String deleteUser(String userId);

	String editUser(Userinfo userinfo);

	Userinfo getUserInfoByName(String username);


}

/*
 * $filename: Utils.java,v $
 * $Date: 2014-5-11  $
 * Copyright (C) ZhengHaibo, Inc. All rights reserved.
 * This software is Made by Zhenghaibo.
 */
package edu.njupt.zhb.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 *@author: ZhengHaibo  
 *web:     http://blog.csdn.net/nuptboyzhb
 *GitHub   https://github.com/nuptboyzhb
 *mail:    zhb931706659@126.com
 *2014-5-11  Nanjing,njupt,China
 */
public class Utils {
	/**
	 * 获取当前时间
	 * @return
	 */
	public static String getNowTime(){
		Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");
        String time = simpleDateFormat.format(date);
        return time;
	}
	
	public static boolean isNull(String str){
		if(null == str || str.length()<=0){
			return true;
		}
		return false;
	}
	
	public static String decodeUTF8(String string){
		if(string == null || string.length()<=0){
			return " ";
		}else{
			try {
				return URLDecoder.decode(string,"UTF-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return " ";
		}
	}
}

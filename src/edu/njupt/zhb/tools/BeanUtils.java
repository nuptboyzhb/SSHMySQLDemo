/*
 * $filename: BeanUtils.java,v $
 * $Date: 2013-12-9  $
 * Copyright (C) ZhengHaibo, Inc. All rights reserved.
 * This software is Made by Zhenghaibo.
 */
package edu.njupt.zhb.tools;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/*
 *@author: ZhengHaibo  
 *web:     http://blog.csdn.net/nuptboyzhb
 *mail:    zhb931706659@126.com
 *2013-12-9  Nanjing,njupt,China
 */
public class BeanUtils {
	/**
	 * 获取Spring中注入的Bean
	 * @param beanId：id
	 * @return
	 */
	public static Object getSpringBean(String beanId){
		//Spring配置文件的路径
		//String xmlRealPath = ServletActionContext.getServletContext().getRealPath("/WEB-INF/classes/applicationContext.xml");
		String xmlRealPath = BeanUtils.class.getResource("/").getPath()+"applicationContext.xml";
		System.out.println("xmlRealPath = "+xmlRealPath);
		xmlRealPath = xmlRealPath.replaceAll("%20", " ");//替换空格
		ApplicationContext ac = new FileSystemXmlApplicationContext(xmlRealPath);
		return ac.getBean(beanId);
	}
}

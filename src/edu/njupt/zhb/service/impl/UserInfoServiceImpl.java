/*
 * $filename: VideoInfoServiceImpl.java,v $
 * $Date: 2014-1-2  $
 * Copyright (C) ZhengHaibo, Inc. All rights reserved.
 * This software is Made by Zhenghaibo.
 */
package edu.njupt.zhb.service.impl;

import java.util.List;

import net.sf.json.JSONObject;
import edu.njupt.zhb.dao.BaseDao;
import edu.njupt.zhb.model.Userinfo;
import edu.njupt.zhb.service.UserInfoService;
import edu.njupt.zhb.tools.DataGrid;
import edu.njupt.zhb.utils.MyConstants;
import edu.njupt.zhb.utils.TipsMsg;

/*
 *@author: ZhengHaibo  
 *web:     http://blog.csdn.net/nuptboyzhb
 *GitHub   https://github.com/nuptboyzhb
 *mail:    zhb931706659@126.com
 *2014-1-2  Nanjing,njupt,China
 */
public class UserInfoServiceImpl implements UserInfoService{
	private BaseDao<Userinfo> userinfoBaseDao;
	public BaseDao<Userinfo> getUserBaseDao() {
		return userinfoBaseDao;
	}
	public void setUserBaseDao(BaseDao<Userinfo> userinfoBaseDao) {
		this.userinfoBaseDao = userinfoBaseDao;
	}
	@Override
	public String getUserInfoList(int page, int rows) {
		// TODO Auto-generated method stub
		if(MyConstants.LOG_DEBUG){
			System.out.println("page="+page+",rows="+rows);
		}
		String hql = "from Userinfo";
		try {
			List<Userinfo> list = userinfoBaseDao.find(hql,page,rows);
			DataGrid<Userinfo> dataGrid = new DataGrid<Userinfo>();
			dataGrid.setRows(list);
			dataGrid.setTotal(userinfoBaseDao.total(hql));
			String result = JSONObject.fromObject(dataGrid).toString();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public String addUser(Userinfo userinfo) {
		// TODO Auto-generated method stub
		TipsMsg tips = new TipsMsg();
		String hql = "from Userinfo where username = '"+userinfo.getUsername()+"'";
		try {
			List<Userinfo> list =  userinfoBaseDao.find(hql);
			if(list!=null&&list.size()>0){
				tips.setMsg("添加失败!用户名已经存在！");
				tips.setId("-2");
				return JSONObject.fromObject(tips).toString();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			userinfoBaseDao.save(userinfo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			tips.setMsg("添加失败");
			tips.setId("-1");
			return JSONObject.fromObject(tips).toString();
		}
		tips.setMsg("添加成功");
		tips.setId("0");
		return JSONObject.fromObject(tips).toString();
	}
	public String deleteUser(String userid) {
		// TODO Auto-generated method stub
		TipsMsg tips = new TipsMsg();
		try {
			userinfoBaseDao.executeHql("delete from Userinfo where id = '"+userid+"'");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			tips.setMsg("删除失败");
			return JSONObject.fromObject(tips).toString();
		}
		tips.setMsg("删除成功");
		return JSONObject.fromObject(tips).toString();
	}
	public String editUser(Userinfo userinfo) {
		// TODO Auto-generated method stub
		TipsMsg tips = new TipsMsg();
		String hql = "from Userinfo where username = '"+userinfo.getUsername()+"'";
		try {
			List<Userinfo> list =  userinfoBaseDao.find(hql);
			if(list!=null&&list.size()>0){
				tips.setMsg("更新失败!用户名已经存在！");
				return JSONObject.fromObject(tips).toString();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			userinfoBaseDao.update(userinfo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			tips.setMsg("编辑失败");
			return JSONObject.fromObject(tips).toString();
		}
		tips.setMsg("编辑成功");
		return JSONObject.fromObject(tips).toString();
	}
	@Override
	public Userinfo getUserInfoByName(String username) {
		// TODO Auto-generated method stub
		Userinfo  userinfo = null;
		String hql = "from Userinfo where username = '"+username+"'";
		try {
			List<Userinfo> list =  userinfoBaseDao.find(hql);
			if(list == null || list.size()==0){
				return null;
			}
			userinfo = list.get(0);
			return userinfo;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}

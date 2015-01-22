/*
 * $filename: DataGridDemoService.java,v $
 * $Date: 2013-10-26  $
 * Copyright (C) ZhengHaibo, Inc. All rights reserved.
 * This software is Made by Zhenghaibo.
 */
package edu.njupt.zhb.service.impl;

import java.util.List;

import net.sf.json.JSONObject;
import edu.njupt.zhb.dao.BaseDao;
import edu.njupt.zhb.model.Bbsmessage;
import edu.njupt.zhb.service.BbsMessageService;
import edu.njupt.zhb.tools.DataGrid;
import edu.njupt.zhb.utils.TipsMsg;

/*
 *@author: ZhengHaibo  
 *web:     http://blog.csdn.net/nuptboyzhb
 *mail:    zhb931706659@126.com
 *2013-10-26  Nanjing,njupt,China
 */
public class BbsMessageServiceImpl implements BbsMessageService {
	private BaseDao baseDao;

	@Override
	public String addBbsmessage(Bbsmessage bbsmessage) {
		TipsMsg tips = new TipsMsg();
		try {
			baseDao.save(bbsmessage);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			tips.setMsg("添加失败");
			tips.setId("-1");
			return JSONObject.fromObject(tips).toString();
		}
		tips.setId("0");
		tips.setMsg("添加成功");
		return JSONObject.fromObject(tips).toString();
	}

	public BaseDao getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}

	@Override
	public String deleteBbsmessage(String bbsmessageid) {
		// TODO Auto-generated method stub
		TipsMsg tips = new TipsMsg();
		try {
			baseDao.executeHql("delete from Bbsmessage where uuid = '"
					+ bbsmessageid + "'");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			tips.setId("-1");
			tips.setMsg("删除失败");
			return JSONObject.fromObject(tips).toString();
		}
		tips.setMsg("删除成功");
		tips.setId("0");
		return JSONObject.fromObject(tips).toString();
	}

	@Override
	public String editBbsmessage(Bbsmessage bbsmessage) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getBbsmessageList(int page, int rows) {
		// TODO Auto-generated method stub
		String hql = "from Bbsmessage order by date desc";
		try {
			List<Bbsmessage> list = baseDao.find(hql, page, rows);
			DataGrid<Bbsmessage> dataGrid = new DataGrid<Bbsmessage>();
			dataGrid.setRows(list);
			dataGrid.setTotal(baseDao.total(hql));
			String result = JSONObject.fromObject(dataGrid).toString();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		DataGrid<Bbsmessage> dataGrid = new DataGrid<Bbsmessage>();
		dataGrid.setRows(null);
		dataGrid.setTotal(0);
		String result = JSONObject.fromObject(dataGrid).toString();
		return result;
	}

}

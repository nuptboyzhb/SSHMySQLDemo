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
import edu.njupt.zhb.model.Student;
import edu.njupt.zhb.service.DataGridDemoService;
import edu.njupt.zhb.tools.DataGrid;
import edu.njupt.zhb.utils.MyConstants;
import edu.njupt.zhb.utils.TipsMsg;

/*
 *@author: ZhengHaibo  
 *web:     http://blog.csdn.net/nuptboyzhb
 *mail:    zhb931706659@126.com
 *2013-10-26  Nanjing,njupt,China
 */
public class DataGridDemoServiceImpl implements DataGridDemoService {
	private BaseDao baseDao;

	public BaseDao getBaseDao() {
		return baseDao;
	}
	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}
	public String getStudentList(int page, int rows) {
		// TODO Auto-generated method stub
		if(MyConstants.LOG_DEBUG){
			System.out.println("page="+page+",rows="+rows);
		}
		String hql = "from Student";
		try {
			List<Student> list = baseDao.find(hql,page,rows);
			DataGrid<Student> dataGrid = new DataGrid<Student>();
			dataGrid.setRows(list);
			dataGrid.setTotal(baseDao.total(hql));
			String result = JSONObject.fromObject(dataGrid).toString();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public String addStudent(Student student) {
		// TODO Auto-generated method stub
		TipsMsg tips = new TipsMsg();
		try {
			baseDao.save(student);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			tips.setMsg("添加失败");
			return JSONObject.fromObject(tips).toString();
		}
		tips.setMsg("添加成功");
		return JSONObject.fromObject(tips).toString();
	}
	public String deleteStudent(String studentid) {
		// TODO Auto-generated method stub
		TipsMsg tips = new TipsMsg();
		try {
			baseDao.executeHql("delete from Student where id = '"+studentid+"'");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			tips.setMsg("删除失败");
			return JSONObject.fromObject(tips).toString();
		}
		tips.setMsg("删除成功");
		return JSONObject.fromObject(tips).toString();
	}
	public String editStudent(Student student) {
		// TODO Auto-generated method stub
		TipsMsg tips = new TipsMsg();
		try {
			baseDao.update(student);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			tips.setMsg("编辑失败");
			return JSONObject.fromObject(tips).toString();
		}
		tips.setMsg("编辑成功");
		return JSONObject.fromObject(tips).toString();
	}
}

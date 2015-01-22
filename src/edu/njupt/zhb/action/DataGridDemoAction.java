/*
 * $filename: ZTreeDemoAction.java,v $
 * $Date: Sep 27, 2013  $
 * Copyright (C) ZhengHaibo, Inc. All rights reserved.
 * This software is Made by Zhenghaibo.
 */
package edu.njupt.zhb.action;

import net.sf.json.JSONArray;
import edu.njupt.zhb.model.Student;
import edu.njupt.zhb.service.DataGridDemoService;
import edu.njupt.zhb.utils.TipsMsg;

/*
 *@author: ZhengHaibo  
 *web:     http://blog.csdn.net/nuptboyzhb
 *mail:    zhb931706659@126.com
 *Sep 27, 2013  Nanjing,njupt,China
 */
public class DataGridDemoAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3318989776253565435L;
	private Student student;// 用于添加学生时接收前台的数据

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	private String studentId;// 用户删除时，根据ID删除

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	private DataGridDemoService dataGridDemoService;

	public DataGridDemoService getDataGridDemoService() {
		return dataGridDemoService;
	}

	public void setDataGridDemoService(DataGridDemoService dataGridDemoService) {
		this.dataGridDemoService = dataGridDemoService;
	}

	/**
	 * 获取数据库的中的学生列表
	 * 
	 * @return
	 */
	public void getStudentList() {
		String jsonResult = dataGridDemoService.getStudentList(page, rows);
		getPrintWriter().write(jsonResult);
	}

	/**
	 * 添加学生
	 * 
	 * @return
	 */
	public void addStudent() {
		if (student == null) {
			TipsMsg tips = new TipsMsg();
			tips.setMsg("添加失败！对象为空");
			getPrintWriter().write(JSONArray.fromObject(tips).toString());
			return;
		}
		String jsonResult = dataGridDemoService.addStudent(student);
		getPrintWriter().write(jsonResult);
		return;
	}

	/**
	 * 删除学生
	 * 
	 * @return
	 */
	public String deleteStudent() {
		if (studentId == null) {
			TipsMsg tips = new TipsMsg();
			tips.setMsg("删除失败！学号无效");
			getPrintWriter().write(JSONArray.fromObject(tips).toString());
			return ERROR;
		}
		String jsonResult = dataGridDemoService.deleteStudent(studentId);
		getPrintWriter().write(jsonResult);
		return SUCCESS;
	}

	/**
	 * 编辑学生
	 * 
	 * @return
	 */
	public String editStudent() {
		if (student == null) {
			TipsMsg tips = new TipsMsg();
			tips.setMsg("编辑失败！对象为空");
			getPrintWriter().write(JSONArray.fromObject(tips).toString());
			return ERROR;
		}
		String jsonResult = dataGridDemoService.editStudent(student);
		getPrintWriter().write(jsonResult);
		return SUCCESS;
	}
}

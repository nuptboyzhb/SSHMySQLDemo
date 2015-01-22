package edu.njupt.zhb.model;

/**
 * Student entity. @author MyEclipse Persistence Tools
 */

public class Student implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -6459245849743863930L;
	private String id;
	private String name;
	private String course;
	private Integer score;
	private String remarks;

	// Constructors

	/** default constructor */
	public Student() {
	}

	/** minimal constructor */
	public Student(String name, String course, Integer score) {
		this.name = name;
		this.course = course;
		this.score = score;
	}

	/** full constructor */
	public Student(String name, String course, Integer score, String remarks) {
		this.name = name;
		this.course = course;
		this.score = score;
		this.remarks = remarks;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCourse() {
		return this.course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public Integer getScore() {
		return this.score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}
package edu.njupt.zhb.model;

/**
 * Userinfo entity. @author MyEclipse Persistence Tools
 */

public class Userinfo implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -1496732180293413262L;
	private String uuid;
	private String username;
	private String password;
	private String imageheadurl;
	private Integer level;
	private String registertime;
	private String reserve1;
	private String reserve2;

	// Constructors

	/** default constructor */
	public Userinfo() {
	}

	/** minimal constructor */
	public Userinfo(String username, String password, Integer level,
			String registertime) {
		this.username = username;
		this.password = password;
		this.level = level;
		this.registertime = registertime;
	}

	/** full constructor */
	public Userinfo(String username, String password, String imageheadurl,
			Integer level, String registertime, String reserve1, String reserve2) {
		this.username = username;
		this.password = password;
		this.imageheadurl = imageheadurl;
		this.level = level;
		this.registertime = registertime;
		this.reserve1 = reserve1;
		this.reserve2 = reserve2;
	}

	// Property accessors

	public String getUuid() {
		return this.uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getImageheadurl() {
		return this.imageheadurl;
	}

	public void setImageheadurl(String imageheadurl) {
		this.imageheadurl = imageheadurl;
	}

	public Integer getLevel() {
		return this.level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public String getRegistertime() {
		return this.registertime;
	}

	public void setRegistertime(String registertime) {
		this.registertime = registertime;
	}

	public String getReserve1() {
		return this.reserve1;
	}

	public void setReserve1(String reserve1) {
		this.reserve1 = reserve1;
	}

	public String getReserve2() {
		return this.reserve2;
	}

	public void setReserve2(String reserve2) {
		this.reserve2 = reserve2;
	}

}
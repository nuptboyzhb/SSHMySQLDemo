package edu.njupt.zhb.model;

/**
 * Bbscomment entity. @author MyEclipse Persistence Tools
 */

public class Bbscomment implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1067682308974147251L;
	private String uuid;
	private String messageid;
	private String username;
	private String content;
	private String touser;
	private Integer agree;
	private Integer disagree;
	private String date;
	private Integer top;
	private String reserve1;
	private String reserve2;

	// Constructors

	/** default constructor */
	public Bbscomment() {
	}

	/** minimal constructor */
	public Bbscomment(String messageid, String username, String content,
			String date) {
		this.messageid = messageid;
		this.username = username;
		this.content = content;
		this.date = date;
	}

	/** full constructor */
	public Bbscomment(String messageid, String username, String content,
			String touser, Integer agree, Integer disagree, String date,
			Integer top, String reserve1, String reserve2) {
		this.messageid = messageid;
		this.username = username;
		this.content = content;
		this.touser = touser;
		this.agree = agree;
		this.disagree = disagree;
		this.date = date;
		this.top = top;
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

	public String getMessageid() {
		return this.messageid;
	}

	public void setMessageid(String messageid) {
		this.messageid = messageid;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTouser() {
		return this.touser;
	}

	public void setTouser(String touser) {
		this.touser = touser;
	}

	public Integer getAgree() {
		return this.agree;
	}

	public void setAgree(Integer agree) {
		this.agree = agree;
	}

	public Integer getDisagree() {
		return this.disagree;
	}

	public void setDisagree(Integer disagree) {
		this.disagree = disagree;
	}

	public String getDate() {
		return this.date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Integer getTop() {
		return this.top;
	}

	public void setTop(Integer top) {
		this.top = top;
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
package edu.njupt.zhb.model;

/**
 * Bbsmessage entity. @author MyEclipse Persistence Tools
 */

public class Bbsmessage implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -5435827612341756293L;
	private String uuid;
	private String username;
	private String content;
	private String imageheadurl;
	private Integer agree;
	private Integer disagree;
	private Integer share;
	private String address;
	private String date;
	private Integer top;
	private String phonemodel;
	private String reserve1;
	private String reserve2;

	// Constructors

	/** default constructor */
	public Bbsmessage() {
	}

	/** minimal constructor */
	public Bbsmessage(String username, String content, String date) {
		this.username = username;
		this.content = content;
		this.date = date;
	}

	/** full constructor */
	public Bbsmessage(String username, String content, String imageheadurl,
			Integer agree, Integer disagree, Integer share, String address,
			String date, Integer top, String phonemodel, String reserve1,
			String reserve2) {
		this.username = username;
		this.content = content;
		this.imageheadurl = imageheadurl;
		this.agree = agree;
		this.disagree = disagree;
		this.share = share;
		this.address = address;
		this.date = date;
		this.top = top;
		this.phonemodel = phonemodel;
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

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getImageheadurl() {
		return this.imageheadurl;
	}

	public void setImageheadurl(String imageheadurl) {
		this.imageheadurl = imageheadurl;
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

	public Integer getShare() {
		return this.share;
	}

	public void setShare(Integer share) {
		this.share = share;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public String getPhonemodel() {
		return this.phonemodel;
	}

	public void setPhonemodel(String phonemodel) {
		this.phonemodel = phonemodel;
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
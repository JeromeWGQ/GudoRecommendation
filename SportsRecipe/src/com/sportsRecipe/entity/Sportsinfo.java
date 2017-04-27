package com.sportsRecipe.entity;

/**
 * Sportsinfo entity. @author MyEclipse Persistence Tools
 */

public class Sportsinfo implements java.io.Serializable {

	// Fields

	private String sportsId;
	private Userlogininfo userlogininfo;
	private String length;
	private Double caloria;
	private Integer bupin;
	private Integer bufu;
	private Integer steps;
	private Double avgspeed;

	// Constructors

	/** default constructor */
	public Sportsinfo() {
	}

	/** minimal constructor */
	public Sportsinfo(Userlogininfo userlogininfo) {
		this.userlogininfo = userlogininfo;
	}

	/** full constructor */
	public Sportsinfo(Userlogininfo userlogininfo, String length,
			Double caloria, Integer bupin, Integer bufu, Integer steps,
			Double avgspeed) {
		this.userlogininfo = userlogininfo;
		this.length = length;
		this.caloria = caloria;
		this.bupin = bupin;
		this.bufu = bufu;
		this.steps = steps;
		this.avgspeed = avgspeed;
	}

	// Property accessors

	public String getSportsId() {
		return this.sportsId;
	}

	public void setSportsId(String sportsId) {
		this.sportsId = sportsId;
	}

	public Userlogininfo getUserlogininfo() {
		return this.userlogininfo;
	}

	public void setUserlogininfo(Userlogininfo userlogininfo) {
		this.userlogininfo = userlogininfo;
	}

	public String getLength() {
		return this.length;
	}

	public void setLength(String length) {
		this.length = length;
	}

	public Double getCaloria() {
		return this.caloria;
	}

	public void setCaloria(Double caloria) {
		this.caloria = caloria;
	}

	public Integer getBupin() {
		return this.bupin;
	}

	public void setBupin(Integer bupin) {
		this.bupin = bupin;
	}

	public Integer getBufu() {
		return this.bufu;
	}

	public void setBufu(Integer bufu) {
		this.bufu = bufu;
	}

	public Integer getSteps() {
		return this.steps;
	}

	public void setSteps(Integer steps) {
		this.steps = steps;
	}

	public Double getAvgspeed() {
		return this.avgspeed;
	}

	public void setAvgspeed(Double avgspeed) {
		this.avgspeed = avgspeed;
	}

}
/**
 * Project Name:qqtest
 * File Name:User.java
 * Package Name:com.jyd.test
 * Date:2017年9月16日上午6:35:55
 * Copyright (c) 2017
 *
 */
package com.jyd.domain;

import java.util.Arrays;

/**
 * 类名: User
 * 备注:
 * 时间: 2017年9月16日 上午6:35:55
 * 作者:sylar
 * @version 
 * @since JDK 1.8
 */
public class User {
	private String userid;
	private String name;
	private String english_name;
	private String mobile;
	private Integer[] department;
	private Integer[] order;
	private String position;
	private String gender;
	private String email;
	private Integer isleader;
	private Integer enable;
	private String avatar_mediaid;
	private String telephone;
	private String hobby;
	private String cardno;
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEnglish_name() {
		return english_name;
	}
	public void setEnglish_name(String english_name) {
		this.english_name = english_name;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	public Integer[] getDepartment() {
		return department;
	}
	public void setDepartment(Integer[] department) {
		this.department = department;
	}
	public Integer[] getOrder() {
		return order;
	}
	public void setOrder(Integer[] order) {
		this.order = order;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getIsleader() {
		return isleader;
	}
	public void setIsleader(Integer isleader) {
		this.isleader = isleader;
	}
	public Integer getEnable() {
		return enable;
	}
	public void setEnable(Integer enable) {
		this.enable = enable;
	}
	public String getAvatar_mediaid() {
		return avatar_mediaid;
	}
	public void setAvatar_mediaid(String avatar_mediaid) {
		this.avatar_mediaid = avatar_mediaid;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public String getCardno() {
		return cardno;
	}
	public void setCardno(String cardno) {
		this.cardno = cardno;
	}
	@Override
	public String toString() {
		return "User [userid=" + userid + ", name=" + name + ", english_name="
				+ english_name + ", mobile=" + mobile + ", department="
				+ Arrays.toString(department) + ", order="
				+ Arrays.toString(order) + ", position=" + position
				+ ", gender=" + gender + ", email=" + email + ", isleader="
				+ isleader + ", enable=" + enable + ", avatar_mediaid="
				+ avatar_mediaid + ", telephone=" + telephone + ", hobby="
				+ hobby + ", cardno=" + cardno + "]";
	}
}

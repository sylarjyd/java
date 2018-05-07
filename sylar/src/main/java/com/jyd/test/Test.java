/**
 * Project Name:qqtest
 * File Name:Test.java
 * Package Name:com.jyd.test
 * Date:2017年9月15日下午10:25:47
 * Copyright (c) 2017
 *
 */
package com.jyd.test;

import com.jyd.domain.User;
import com.jyd.domain.WeixinDepartment;
import com.jyd.util.HttpClient;

/**
 * 类名: Test
 * 备注:
 * 时间: 2017年9月15日 下午10:25:47
 * 作者:sylar
 * @version 
 * @since JDK 1.8
 */
public class Test {
	public static void main(String[] args) {
		String access_token = HttpClient.getToken();
		System.out.println(access_token);
		WeixinDepartment dept = new WeixinDepartment();
		Object createDept = HttpClient.createDept(access_token,dept);
		System.out.println(createDept);
	}
	
	public void create(){
		User u = new User();
		u.setUserid("zhangsan");
		u.setName("张三");
		u.setEnglish_name("jack");
		u.setMobile("13971372965");
		u.setDepartment(new Integer[]{1,2});
		u.setOrder(new Integer[]{10,40});
		u.setPosition("武汉");
		u.setGender("1");
		u.setEmail("zhangsan@gzdev.com");
		u.setIsleader(1);
		u.setEnable(1);
		u.setAvatar_mediaid("2-G6nrLmr5EC3MNb_-zL1dDdzkd0p7cNliYu9V5w7o8K0");
		u.setTelephone("020-123456");
		u.setHobby("旅游");
		u.setCardno("1234567234");
		
	}
	@org.junit.Test
	public void getDeptList(){
		String access_token = HttpClient.getToken();
		Object deptList = HttpClient.getDeptList(access_token);
		System.out.println(deptList);
	}
}

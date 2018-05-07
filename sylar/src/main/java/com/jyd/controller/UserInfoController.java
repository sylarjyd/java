/**
 * Project Name:sylar
 * File Name:UserInfoController.java
 * Package Name:com.jyd.controller
 * Date:2018年4月21日下午11:19:49
 * Copyright (c) 2018
 */
package com.jyd.controller;

import java.util.HashMap;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jyd.entity.User;
import com.jyd.service.UserInfoService;

/**
 * ClassName: UserInfoController
 * Comment:
 * Time: 2018年4月21日 下午11:19:49
 * Author:sylar
 * @Version 
 * @Since JDK 1.8
 */
@Controller
@RequestMapping(value="/userInfo")
public class UserInfoController {
	@Autowired
	private UserInfoService userInfoService;
	
	
	/**
	 * 跳转页面
	 */
	@RequestMapping(value="/{path}",method=RequestMethod.GET)
	public String loadBillListUI(@PathVariable("path") String path){
		return path;
	}
	
//	@RequestMapping("/addIndex")
//	public String addIndex() {
//		return "addIndex";
//	}
	
	
	@RequestMapping("/add")
	@ResponseBody
	public String addUserInfo(User user) {
		user.setId("12345l");
		userInfoService.insert(user);
		HashMap<String,String> hashMap = new HashMap<>();
		hashMap.put("msg", "success");
		return "index";
	}
	
	
}

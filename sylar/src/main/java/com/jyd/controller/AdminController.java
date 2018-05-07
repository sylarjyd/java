/**
 * Project Name:weixin
 * File Name:adminController.java
 * Package Name:com.jyd.controller
 * Date:2017年9月16日下午11:22:09
 * Copyright (c) 2017
 *
 */
package com.jyd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 类名: adminController
 * 备注:
 * 时间: 2017年9月16日 下午11:22:09
 * 作者:sylar
 * @version 
 * @since JDK 1.8
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
	/**
	 * 跳转页面
	 */
	@RequestMapping(value="/{path}",method=RequestMethod.GET)
	public String loadBillListUI(@PathVariable("path") String path){
		return path;
	}
}

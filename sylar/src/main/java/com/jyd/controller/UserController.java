package com.jyd.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jyd.domain.User;
import com.jyd.service.UserService;
import com.jyd.util.HttpClient;

/**
 * @author yyl
 * EmpController.java
 * 2017-7-21
 */
@Controller
@RequestMapping("/user")
public class UserController {
	 
	@Autowired
	private UserService userService;
	
	//获取某个部门下的成员
	@RequestMapping("/loadUserList")
	@ResponseBody
	public List<User> loadUserList(Integer id){
		List<User> list = null;
		if(null==id)
			id = 1 ;
		list = userService.loadUserListById(HttpClient.getToken(), id);
		return list;
	}
	
	//获取某个部门下的成员
	@RequestMapping("/loadUserList2")
	@ResponseBody
	public List<User> loadUserList2(Integer id){
		List<User> list = null;
		if(null==id)
			id = 1 ;
		list = userService.loadUserListById(HttpClient.getToken(), id);
		for (User user : list) {
			System.out.println(user);
		}
		return list;
	}
	
	@RequestMapping("/addUser")
	@ResponseBody
	public Map<String,String> addUser(User user){
		Map<String,String> map = new HashMap<String,String>();
		try {
			userService.addUserService(user);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("errorMsg", e.getMessage());
		}
		return map;
	}
	
	@RequestMapping("/destroyUser")
	@ResponseBody
	public Map<String,String> destroyUser(User user){
		Map<String,String> map = new HashMap<String,String>();
		try {
			userService.deleteUser(HttpClient.getToken(),user.getUserid());
		} catch (Exception e) {
			e.printStackTrace();
			map.put("errorMsg", e.getMessage());
		}
		return map;
	}
	
	@RequestMapping("/updateUser")
	@ResponseBody
	public Map<String,String> updateUser(User user){
		Map<String,String> map = new HashMap<String,String>();
		try {
			userService.updateUser(HttpClient.getToken(),user);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("errorMsg", e.getMessage());
		}
		return map;
	}
	
	@RequestMapping("/getPerson")
	@ResponseBody
	public User getPerson(User user){
		return userService.getPerson(HttpClient.getToken(),user.getUserid());
	}
}



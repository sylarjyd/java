/**
 * Project Name:bill
 * File Name:BillTypeService.java
 * Package Name:com.bjsxt.service
 * Date:2017年7月30日下午7:49:09
 * Copyright (c) 2017
 *
 */
package com.jyd.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import com.jyd.domain.User;
import com.jyd.entity.UserExample;

/**
 * 类名: BillTypeService
 * 备注:
 * 时间: 2017年7月30日 下午7:49:09
 * 作者:sylar
 * @version 
 * @since JDK 1.8
 */
public interface UserService {
	//获取某个部门的用户
	public List<User> loadUserListById(String access_token,int id);
	//添加用户
	public int addUserService(User user);
	//修改用户
	public int updateUser(String access_token,User user);
	//删除用户
	public int deleteUser(String accesstoken , String userid);
	//获取成员
	public User getPerson(String accesstoken,String userId);
	
	
	
}

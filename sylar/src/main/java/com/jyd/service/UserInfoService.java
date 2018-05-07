/**
 * Project Name:sylar
 * File Name:UserInfoService.java
 * Package Name:com.jyd.service
 * Date:2018年4月21日下午11:15:22
 * Copyright (c) 2018
 */
package com.jyd.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import com.jyd.entity.User;
import com.jyd.entity.UserExample;

/**
 * ClassName: UserInfoService
 * Comment:
 * Time: 2018年4月21日 下午11:15:22
 * Author:sylar
 * @Version 
 * @Since JDK 1.8
 */
public interface UserInfoService {
	int countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(String id);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExampleWithRowbounds(UserExample example, RowBounds rowBounds);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}

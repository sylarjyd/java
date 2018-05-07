/**
 * Project Name:sylar
 * File Name:UserInfoServiceImpl.java
 * Package Name:com.jyd.service.impl
 * Date:2018年4月21日下午11:15:51
 * Copyright (c) 2018
 */
package com.jyd.service.impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jyd.entity.User;
import com.jyd.entity.UserExample;
import com.jyd.mapper.UserMapper;
import com.jyd.service.UserInfoService;

/**
 * ClassName: UserInfoServiceImpl
 * Comment:
 * Time: 2018年4月21日 下午11:15:51
 * Author:sylar
 * @Version 
 * @Since JDK 1.8
 */
@Service
@SuppressWarnings(value= {"unchecked","deprecation"})
public class UserInfoServiceImpl implements UserInfoService {

	@Autowired
	private UserMapper userMapper; 
	
	
	/**
	 * TODO 
	 * @see com.jyd.service.UserInfoService#countByExample(com.jyd.entity.UserExample)
	 */
	@Override
	public int countByExample(UserExample example) {
		return 0;
	}

	/**
	 * TODO 
	 * @see com.jyd.service.UserInfoService#deleteByExample(com.jyd.entity.UserExample)
	 */
	@Override
	public int deleteByExample(UserExample example) {
		return 0;
	}

	/**
	 * TODO 
	 * @see com.jyd.service.UserInfoService#deleteByPrimaryKey(java.lang.String)
	 */
	@Override
	public int deleteByPrimaryKey(String id) {
		return 0;
	}

	/**
	 * TODO 
	 * @see com.jyd.service.UserInfoService#insert(com.jyd.domain.User)
	 */
	@Override
	public int insert(User record) {
		return userMapper.insert(record);
	}

	/**
	 * TODO 
	 * @see com.jyd.service.UserInfoService#insertSelective(com.jyd.domain.User)
	 */
	@Override
	public int insertSelective(User record) {
		return 0;
	}

	/**
	 * TODO 
	 * @see com.jyd.service.UserInfoService#selectByExampleWithRowbounds(com.jyd.entity.UserExample, org.apache.ibatis.session.RowBounds)
	 */
	@Override
	public List<User> selectByExampleWithRowbounds(UserExample example, RowBounds rowBounds) {
		return null;
	}

	/**
	 * TODO 
	 * @see com.jyd.service.UserInfoService#selectByExample(com.jyd.entity.UserExample)
	 */
	@Override
	public List<User> selectByExample(UserExample example) {
		return null;
	}

	/**
	 * TODO 
	 * @see com.jyd.service.UserInfoService#selectByPrimaryKey(java.lang.String)
	 */
	@Override
	public User selectByPrimaryKey(String id) {
		return null;
	}

	/**
	 * TODO 
	 * @see com.jyd.service.UserInfoService#updateByExampleSelective(com.jyd.domain.User, com.jyd.entity.UserExample)
	 */
	@Override
	public int updateByExampleSelective(User record, UserExample example) {
		return 0;
	}

	/**
	 * TODO 
	 * @see com.jyd.service.UserInfoService#updateByExample(com.jyd.domain.User, com.jyd.entity.UserExample)
	 */
	@Override
	public int updateByExample(User record, UserExample example) {
		return 0;
	}

	/**
	 * TODO 
	 * @see com.jyd.service.UserInfoService#updateByPrimaryKeySelective(com.jyd.domain.User)
	 */
	@Override
	public int updateByPrimaryKeySelective(User record) {
		return 0;
	}

	/**
	 * TODO 
	 * @see com.jyd.service.UserInfoService#updateByPrimaryKey(com.jyd.domain.User)
	 */
	@Override
	public int updateByPrimaryKey(User record) {
		return 0;
	}

}

/**
 * Project Name:weixin
 * File Name:TagService.java
 * Package Name:com.jyd.service
 * Date:2017年9月18日下午3:26:17
 * Copyright (c) 2017
 *
 */
package com.jyd.service;

import java.util.List;

import com.jyd.domain.Tag;

/**
 * 类名: TagService
 * 备注:
 * 时间: 2017年9月18日 下午3:26:17
 * 作者:sylar
 * @version 
 * @since JDK 1.8
 */
public interface TagService {
	//获取标签列表
	public List<Tag> loadTagList(String access_token);

	/**
	 * 方法名:addTagService
	 * 备注:
	 * 作者:sylar
	 * 时间:2017年9月18日下午4:37:56
	 * @param token
	 * @param tag
	 * @since JDK 1.8
	 */
	public int addTagService(String token, Tag tag);

	/**
	 * 方法名:deleteTagService
	 * 备注:
	 * 作者:sylar
	 * 时间:2017年9月18日下午4:48:34
	 * @param token
	 * @param tagid
	 * @since JDK 1.8
	 */
	public int deleteTagService(String token, Integer tagid);
}

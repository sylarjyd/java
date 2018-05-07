/**
 * Project Name:weixin
 * File Name:TagController.java
 * Package Name:com.jyd.controller
 * Date:2017年9月18日下午4:19:36
 * Copyright (c) 2017
 *
 */
package com.jyd.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jyd.domain.Tag;
import com.jyd.service.TagService;
import com.jyd.util.HttpClient;

/**
 * 类名: TagController
 * 备注:
 * 时间: 2017年9月18日 下午4:19:36
 * 作者:sylar
 * @version 
 * @since JDK 1.8
 */
@Controller
@RequestMapping("/tag")
public class TagController {
	@Autowired
	private TagService tagService;
	
	@RequestMapping("/loadTagList")
	@ResponseBody
	public List<Tag> loadTagList(){
		List<Tag> tagList = null;
		try {
			tagList = tagService.loadTagList(HttpClient.getToken());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tagList;
	}
	@RequestMapping("/addTag")
	@ResponseBody
	public Map<String,String> addTag(Tag tag){
		Map<String,String> map = new HashMap<String,String>();
		try {
			tagService.addTagService(HttpClient.getToken(),tag);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("errorMsg", e.getMessage());
		}
		return map;
	}
	@RequestMapping("/destroyTag")
	@ResponseBody
	public Map<String,String> destroyTag(Tag tag){
		Map<String,String> map = new HashMap<String,String>();
		try {
			tagService.deleteTagService(HttpClient.getToken(), tag.getTagid());
		} catch (Exception e) {
			e.printStackTrace();
			map.put("errorMsg", e.getMessage());
		}
		return map;
	}
}

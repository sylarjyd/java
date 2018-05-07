/**
 * Project Name:weixin
 * File Name:TagServiceImpl.java
 * Package Name:com.jyd.service.impl
 * Date:2017年9月18日下午3:28:10
 * Copyright (c) 2017
 *
 */
package com.jyd.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.jyd.domain.Tag;
import com.jyd.service.TagService;
import com.jyd.util.Constant;
import com.jyd.util.HttpClient;

/**
 * 类名: TagServiceImpl
 * 备注:
 * 时间: 2017年9月18日 下午3:28:10
 * 作者:sylar
 * @version 
 * @since JDK 1.8
 */
@Service
public class TagServiceImpl implements TagService {
	private static Logger log = LoggerFactory.getLogger(TagServiceImpl.class);
	/**
	 * TODO 简单描述该方法的实现功能（可选）.
	 * @see com.jyd.service.TagService#loadTagList()
	 */
	@Override
	public List<Tag> loadTagList(String access_token) {
		List<Tag> taglist = null;
		String requestUrl = Constant.TAG_GETLIST_URL.replace("ACCESS_TOKEN", access_token);
		JSONObject jsonObject = HttpClient.httpsRequest(requestUrl, "GET", null);
		if(jsonObject.getInt("errcode")==0){
			log.info("获取标签列表成功！");
			taglist = JSONArray.toList(jsonObject.getJSONArray("taglist"),Tag.class);
		}else{
			int errCode=jsonObject.getInt("errcode");
			String errMsg=jsonObject.getString("errmsg");
			log.error("获取部门下用户失败  errorcode:{} errmsg:{}",errCode,errMsg);	
		}
		return taglist;
	}
	/**
	 * TODO 简单描述该方法的实现功能（可选）.
	 * @see com.jyd.service.TagService#addTagService(java.lang.String, com.jyd.domain.Tag)
	 */
	@Override
	public int addTagService(String token, Tag tag) {
		int errCode=0;  
		String requestUrl = Constant.TAG_CREATE_URL.replace("ACCESS_TOKEN", token);
		Map<String,Object> map = new HashMap<>();
		map.put("tagid", tag.getTagid());
		map.put("tagname", tag.getTagname());
		String outputStr = JSONObject.fromObject(map).toString();
		JSONObject jsonObject = HttpClient.httpsRequest(requestUrl, "POST", outputStr);
		if(jsonObject.getInt("errcode")==0){
			log.info("添加标签成功！");
		}else{
			errCode=jsonObject.getInt("errcode");  
            String errMsg=jsonObject.getString("errmsg");  
            log.error("创建标签失败  errorcode:{} errmsg:{}",errCode,errMsg);  
		}
		return errCode;		
	}
	@Override
	public int deleteTagService(String token, Integer tagid) {
		int errCode=0;  
		String requestUrl = Constant.TAG_DELETE_URL.replace("ACCESS_TOKEN", token)
				.replace("tagid", String.valueOf(tagid));
		JSONObject jsonObject = HttpClient.httpsRequest(requestUrl, "POST", null);
		if(jsonObject.getInt("errcode")==0){
			log.info("删除标签成功！");
		}else{
			errCode=jsonObject.getInt("errcode");  
            String errMsg=jsonObject.getString("errmsg");  
            log.error("删除标签失败  errorcode:{} errmsg:{}",errCode,errMsg);  
		}
		return errCode;		
	}

}

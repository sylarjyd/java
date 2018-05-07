/**
 * Project Name:bill
 * File Name:BillTypeServiceImpl.java
 * Package Name:com.bjsxt.service.impl
 * Date:2017年7月30日下午7:50:30
 * Copyright (c) 2017
 *
 */
package com.jyd.service.impl;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.jyd.domain.WeixinDepartment;
import com.jyd.service.DeptService;
import com.jyd.util.Constant;
import com.jyd.util.HttpClient;

/**
 * 类名: BillTypeServiceImpl
 * 备注:
 * 时间: 2017年7月30日 下午7:50:30
 * 作者:sylar
 * @version 
 * @since JDK 1.8
 */
@Service
public class DeptServiceImpl implements DeptService {
	private static Logger log = LoggerFactory.getLogger(DeptServiceImpl.class);

	/**
	 * 创建部门 id不指定
	 *  部门名称 长度限制为1~64个字符
	 * @see com.jyd.service.DeptService#CreateByParentid(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public int createByParentid(String access_token, String name,
			String parentid) {
		int errCode=0;
		//拼接请求地址
		String requestUrl=Constant.CREATE_URL+access_token;
		//需要提交的数据
		String postJson = "{\"name\":\" %s\",\"parentid\": %s}";
		String outputStr=String.format(postJson, name,parentid);
		//创建部门
		JSONObject jsonObject=HttpClient.httpsRequest(requestUrl, "POST", outputStr);
		
		if(null!=jsonObject){
			if(0==jsonObject.getInt("errcode")){
				log.info("创建部门成功");
			}else{
				errCode=jsonObject.getInt("errcode");
				String errMsg=jsonObject.getString("errmsg");
				log.error("创建部门失败  errorcode:{} errmsg:{}",errCode,errMsg);
			}
		}
		return errCode;
	}

	/**
	 * 创建部门 指定id
	 * @see com.jyd.service.DeptService#CreateByCustomid(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public int createByCustomid(String access_token, String name,
			String parentid, String id) {
		int errCode=0;
		//拼接请求地址
		String requestUrl=Constant.CREATE_URL+access_token;
		//需要提交的数据
		String postJson = "{\"name\":\"%s\",\"parentid\": %s,\"id\": %s}";
		String outputStr=String.format(postJson, name,parentid,id);
		//创建部门
		JSONObject jsonObject=HttpClient.httpsRequest(requestUrl, "POST", outputStr);
		
		if(null!=jsonObject){
			if(0==jsonObject.getInt("errcode")){
				log.info("创建部门成功");
			}else{
				errCode=jsonObject.getInt("errcode");
				String errMsg=jsonObject.getString("errmsg");
				log.error("创建部门失败  errorcode:{} errmsg:{}",errCode,errMsg);
			}
		}
		return errCode;
	}

	/**
	 * 更新部门
	 * @see com.jyd.service.DeptService#Update(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public int updateDept(String accesstoken, String id, String name) {
		int errCode=0;
		//拼接请求地址
		StringBuffer sb = new StringBuffer();
		sb.append(Constant.UPDATE_URL).append(accesstoken);
		String requestUrl = sb.toString();
		//需要提交的数据
		String postJson = "{\"id\":\" %s\",\"name\":\"%s\"}";
		String outputStr=String.format(postJson, id, name);
		//创建部门
		JSONObject jsonObject=HttpClient.httpsRequest(requestUrl, "POST", outputStr);
		
		if(null!=jsonObject){
			if(0==jsonObject.getInt("errcode")){
				log.info("更新部门成功");
			}else{
				errCode=jsonObject.getInt("errcode");
				String errMsg=jsonObject.getString("errmsg");
				log.error("更新部门失败  errorcode:{} errmsg:{}",errCode,errMsg);
			}
		}
		return errCode;
	}

	/**
	 * 删除部门
	 * @see com.jyd.service.DeptService#Delete(java.lang.String, java.lang.String)
	 */
	@Override
	public int deleteDept(String accesstoken, String id) {
		int errCode=0;
		//拼接请求地址
		StringBuffer sb = new StringBuffer();
		sb.append(Constant.DELETE_URL);
		sb.append(accesstoken);
		sb.append("&id=");
		sb.append(id);
		String requestUrl = sb.toString();
		//删除部门
		JSONObject jsonObject=HttpClient.httpsRequest(requestUrl, "GET", null);
		if(null!=jsonObject){
			if(0==jsonObject.getInt("errcode")){
				log.info("删除部门成功");	
			}else{
				errCode=jsonObject.getInt("errcode");
				String errMsg=jsonObject.getString("errmsg");
				log.error("删除部门失败  errorcode:{} errmsg:{}",errCode,errMsg);
			}
		}
		return errCode;
	}

	/**
	 * 获取所有部门
	 * @see com.jyd.service.DeptService#GetList(java.lang.String)
	 */
	@Override
	public List<WeixinDepartment> getDeptList(String access_token) {
		List<WeixinDepartment> wxdlist = null;
		StringBuffer sb = new StringBuffer();
		sb.append(Constant.GETLIST_URL);
		sb.append(access_token);
		String url = sb.toString();
		//获取部门列表
		JSONObject jsonObject = HttpClient.httpsRequest(url, "GET", null);
		//JSONObject jsonObject = HttpClient.getDeptList(access_token);
		if(null!=jsonObject){
			if(0==jsonObject.getInt("errcode")){
				log.info("获取部门列表成功");
				wxdlist=JSONArray.toList
						(jsonObject.getJSONArray("department"),WeixinDepartment.class);
			}else{
				int errCode=jsonObject.getInt("errcode");
				String errMsg=jsonObject.getString("errmsg");
				log.error("获取部门列表失败  errorcode:{} errmsg:{}",errCode,errMsg);	
			}
		}
		return wxdlist;
	}

	@Override
	public List<WeixinDepartment> getDeptById(String access_token, String id) {
		List<WeixinDepartment> weixinDepartment=null;
		StringBuffer sb = new StringBuffer();
		sb.append(Constant.GETLIST_URL);
		sb.append(access_token);
		sb.append("&id=");
		sb.append(id);
		String url = sb.toString();
		//获取部门列表
		JSONObject jsonObject = HttpClient.httpsRequest(url, "GET", null);
		//JSONObject jsonObject = HttpClient.getDeptList(access_token);
		if(null!=jsonObject){
			if(0==jsonObject.getInt("errcode")){
				log.info("获取部门列表成功");
				weixinDepartment=JSONArray.toList
						(jsonObject.getJSONArray("department"),WeixinDepartment.class);
			}else{
				weixinDepartment=null;
				int errCode=jsonObject.getInt("errcode");
				String errMsg=jsonObject.getString("errmsg");
				log.error("获取部门列表失败  errorcode:{} errmsg:{}",errCode,errMsg);	
			}
		}
		return weixinDepartment;
	}
	
}

/**
 * Project Name:weixin
 * File Name:UserServiceImpl.java
 * Package Name:com.jyd.service.impl
 * Date:2017年9月16日下午11:56:43
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

import com.jyd.domain.User;
import com.jyd.service.UserService;
import com.jyd.util.Constant;
import com.jyd.util.HttpClient;

/**
 * 类名: UserServiceImpl
 * 备注:
 * 时间: 2017年9月16日 下午11:56:43
 * 作者:sylar
 * @version 
 * @since JDK 1.8
 */
@Service
public class UserServiceImpl implements UserService {
	private static Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
	/**
	 * 获取某个部门下的用户
	 * @see com.jyd.service.UserService#loadUserListById(int)
	 */
	@Override
	public List<User> loadUserListById(String access_token,int id) {
		List<User> userList = null;
		//拼接请求地址
		String requestUrl=Constant.USER_GETLIST_URL.replace("ACCESS_TOKEN", access_token).
				replace("DEPARTMENT_ID", String.valueOf(id)).replace("FETCH_CHILD", "1");
		JSONObject jsonObject=HttpClient.httpsRequest(requestUrl, "GET", null);	
		if(null!=jsonObject){
			if(0==jsonObject.getInt("errcode")){
				log.info("获取部门下用户成功！");
				userList=JSONArray.toList
						(jsonObject.getJSONArray("userlist"),User.class);
			}else{
				int errCode=jsonObject.getInt("errcode");
				String errMsg=jsonObject.getString("errmsg");
				log.error("获取部门下用户失败  errorcode:{} errmsg:{}",errCode,errMsg);	
			}
		}
		return userList;
	}
	/**
	 * @see com.jyd.service.UserService#addUserService(com.jyd.domain.User)
	 */
	@Override
	public int addUserService(User user) {
		int errCode=0;  
		String access_token = HttpClient.getToken();
		String requestUrl = Constant.USER_CREATE_URL.replace("ACCESS_TOKEN", access_token);
		  //需要提交的数据  
//        String postJson = "{\"userid\":\"%s\",\"name\":\"%s\",\"department\": [%s],\"position\": \"%s\",\"mobile\": \"%s\",\"gender\": \"%s\",\"tel\":\"%s\",\"email\":\"%s\"}";   
//        String outputStr=String.format(postJson, user.getUserid(),user.getName(),user.getDepartment()[0],user.getPosition(),user.getMobile()
//        		,user.getGender(),user.getTelephone(),user.getEmail());  
//        System.out.println(outputStr);
		Map<String,Object> map = new HashMap<>();
		map.put("userid", user.getUserid());
		map.put("name", user.getName());
		map.put("mobile", user.getMobile());
		map.put("department", user.getDepartment());
		map.put("position", user.getPosition());
		map.put("gender", user.getGender());
		map.put("email", user.getEmail());
		JSONObject fromObject = JSONObject.fromObject(map);
		String outputStr = fromObject.toString();
        //创建成员  
        JSONObject jsonObject=HttpClient.httpsRequest(requestUrl, "POST", outputStr);  
        if(null!=jsonObject){  
            if(0==jsonObject.getInt("errcode")){  
                log.info("创建成员成功");  
            }else{  
                errCode=jsonObject.getInt("errcode");  
                String errMsg=jsonObject.getString("errmsg");  
                log.error("创建成员失败  errorcode:{} errmsg:{}",errCode,errMsg);   
            }  
        }  
        return errCode;  
	}
	 /** 
     * 更新成员 
     * @param userid 员工UserID。对应管理端的帐号，企业内必须唯一。长度为1~64个字符 
     * @param name 成员名称。长度为1~64个字符 
     * @param department 成员所属部门id列表 格式： "department": [x] 
     * @param position 职位信息 
     * @param mobile 手机号码。企业内必须唯一，mobile/weixinid/email三者不能同时为空 
     * @param gender 性别。gender=0表示男，=1表示女。默认gender=0 
     * @param tel 办公电话。长度为0~64个字符 
     * @param email 邮箱。长度为0~64个字符。企业内必须唯一 
     * @param weixinid 微信号。企业内必须唯一 
     * @param enable 启用/禁用成员。1表示启用成员，0表示禁用成员 
     * */  
    public int updateUser(String access_token,User user){
        int errCode=0;  
        //拼接请求地址  
		String requestUrl = Constant.USER_CREATE_URL.replace("ACCESS_TOKEN", access_token);
        //需要提交的数据  
        String postJson = "{\"userid\":\"%s\",\"name\":\"%s\",\"department\": [1],\"position\":\"%s\",\"mobile\":\"%s\",\"gender\":\"%s\",\"tel\":\"%s\",\"email\":\"%s\",\"enable\":\"%s\"}";    
        String outputStr=String.format(postJson, user.getUserid(),user.getName(),user.getPosition()
        		,user.getMobile(),user.getGender(),user.getTelephone(),user.getEmail(),
        		user.getEnable());  
        //更新成员  
        JSONObject jsonObject=HttpClient.httpsRequest(requestUrl, "POST", outputStr);  
        if(null!=jsonObject){  
            if(0==jsonObject.getInt("errcode")){  
                log.info("更新成员成功");  
            }else{  
                errCode=jsonObject.getInt("errcode");  
                String errMsg=jsonObject.getString("errmsg");  
                log.error("更新成员失败  errorcode:{} errmsg:{}",errCode,errMsg);  
            }  
        }  
        return errCode;  
    }  
  
    /** 
     * 删除成员 
     * @param accesstoken  
     * @param userid 员工UserID。对应管理端的帐号 
     * */  
    public int deleteUser(String accesstoken , String userid){  
        int errCode=0;  
        //拼接请求地址  
        String requestUrl=Constant.USER_DELETE_URL.replace("ACCESS_TOKEN", accesstoken).replace("USERID", userid);  
        //删除成员  
        JSONObject jsonObject=HttpClient.httpsRequest(requestUrl, "GET", null);  
        if(null!=jsonObject){  
            if(0==jsonObject.getInt("errcode")){  
                log.info("删除成员成功");   
            }else{  
                errCode=jsonObject.getInt("errcode");  
                String errMsg=jsonObject.getString("errmsg");  
                log.error("删除成员失败  errorcode:{} errmsg:{}",errCode,errMsg);  
            }  
        }  
        return errCode;  
    }  
    /** 
     * 获取成员 
     * @param accesstoken  
     * */  
    public User getPerson(String accesstoken,String userId){  
        User u = new User(); 
        //拼接请求地址  
        String requestUrl=Constant.USER_GET_URL.replace("ACCESS_TOKEN", accesstoken).replace("USERID", userId);  
        //获取成员  
        JSONObject jsonObject=HttpClient.httpsRequest(requestUrl, "GET", null);   
        if(null!=jsonObject){  
            if(0==jsonObject.getInt("errcode")){  
                log.info("获取成员成功");  
                u.setUserid(jsonObject.getString("userid"));  
                u.setName(jsonObject.getString("name")); 
                JSONArray jsonarray = (JSONArray)jsonObject.get("department");
                int size = jsonarray.size();
                Integer[] depts = new Integer[size];
                for (int i = 0; i < jsonarray.size(); i++) {
                	depts[i] = jsonarray.getInt(i);
				}
                u.setDepartment(depts);  
            }else{  
                int errCode=jsonObject.getInt("errcode");  
                String errMsg=jsonObject.getString("errmsg");  
                log.error("获取成员失败  errorcode:{} errmsg:{}",errCode,errMsg);   
            }  
        }  
        return u;  
    }  
}

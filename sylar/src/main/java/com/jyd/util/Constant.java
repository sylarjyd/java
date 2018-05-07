/**
 * Project Name:weixin
 * File Name:Constant.java
 * Package Name:com.jyd.util
 * Date:2017年9月16日下午11:40:04
 * Copyright (c) 2017
 *
 */
package com.jyd.util;

/**
 * 类名: Constant
 * 备注:
 * 时间: 2017年9月16日 下午11:40:04
 * 作者:sylar
 * @version 
 * @since JDK 1.8
 */
public interface Constant {
	public static final String url = "https://qyapi.weixin.qq.com/cgi-bin/gettoken";
	public static final String corpid = "wx013610f0809c2f4c";
	public static final String corpsecret = "uGml2PlUIVhqFwgR6i2LcGdA5HomvgqqpxWFCKcog4TcPurHgq1NKGXZb3iu5faG";
	// 创建部门地址  
    public static final String CREATE_URL = "https://qyapi.weixin.qq.com/cgi-bin/department/create?access_token=";  
    // 更新部门地址  
    public static final String UPDATE_URL = "https://qyapi.weixin.qq.com/cgi-bin/department/update?access_token=";  
    // 删除部门地址  
    public static final String DELETE_URL = "https://qyapi.weixin.qq.com/cgi-bin/department/delete?access_token=";  
    // 获取部门列表地址  
    public static final String GETLIST_URL = "https://qyapi.weixin.qq.com/cgi-bin/department/list?access_token="; 
   
    //获取部门成员详情
    public static final String DEPT_DETAIL_URL= "https://qyapi.weixin.qq.com/cgi-bin/user/list?access_token=ACCESS_TOKEN&department_id=DEPARTMENT_ID&fetch_child=FETCH_CHILD";
    
    //创建成员
    public static final String USER_CREATE_URL= "https://qyapi.weixin.qq.com/cgi-bin/user/create?access_token=ACCESS_TOKEN";
    //获取某个部门下的用户
    public static final String USER_GETLIST_URL = "https://qyapi.weixin.qq.com/cgi-bin/user/simplelist?access_token=ACCESS_TOKEN&department_id=DEPARTMENT_ID&fetch_child=FETCH_CHILD";
    //更新用户
    public static final String USER_UPDATE_URL ="https://qyapi.weixin.qq.com/cgi-bin/user/update?access_token=ACCESS_TOKEN";
    //
    public static final String USER_GET_URL="https://qyapi.weixin.qq.com/cgi-bin/user/get?access_token=ACCESS_TOKEN&userid=USERID";
    //删除用户
    public static final String USER_DELETE_URL = "https://qyapi.weixin.qq.com/cgi-bin/user/delete?access_token=ACCESS_TOKEN&userid=USERID";
    //批量删除用户
    public static final String USER_BATCHDELETE_URL = "https://qyapi.weixin.qq.com/cgi-bin/user/batchdelete?access_token=ACCESS_TOKEN";
    /**
     * userid转openid
	 *该接口使用场景为微信支付、微信红包和企业转账，
	 *企业号用户在使用微信支付的功能时，需要自行将企业号的userid转成openid。
	 *在使用微信红包功能时，需要将应用id和userid转成appid和openid才能使用。
     */
    public static final String CONVERT_TO_OPENID=" https://qyapi.weixin.qq.com/cgi-bin/user/convert_to_openid?access_token=ACCESS_TOKEN";
    //二次验证
    public static final String SECOND_AUTH="https://qyapi.weixin.qq.com/cgi-bin/user/authsucc?access_token=ACCESS_TOKEN&userid=USERID";
    
    //标签创建
    public static final String TAG_CREATE_URL="https://qyapi.weixin.qq.com/cgi-bin/tag/create?access_token=ACCESS_TOKEN";
    //获取标签列表
    public static final String TAG_GETLIST_URL="https://qyapi.weixin.qq.com/cgi-bin/tag/list?access_token=ACCESS_TOKEN";
    //更新标签
    public static final String TAG_UPDATE_URL="https://qyapi.weixin.qq.com/cgi-bin/tag/update?access_token=ACCESS_TOKEN";
    //删除标签
    public static final String TAG_DELETE_URL = "https://qyapi.weixin.qq.com/cgi-bin/tag/delete?access_token=ACCESS_TOKEN&tagid=TAGID";
    //获取标签成员
    public static final String TAG_GETUSER_URL="https://qyapi.weixin.qq.com/cgi-bin/tag/get?access_token=ACCESS_TOKEN&tagid=TAGID";
    //增加标签成员
    public static final String TAG_ADDUSER_URL = "https://qyapi.weixin.qq.com/cgi-bin/tag/addtagusers?access_token=ACCESS_TOKEN";
    //删除标签成员
    public static final String TAG_DELETEUSER_URL = "https://qyapi.weixin.qq.com/cgi-bin/tag/deltagusers?access_token=ACCESS_TOKEN";
}

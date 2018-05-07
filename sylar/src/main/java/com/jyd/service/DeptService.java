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

import com.jyd.domain.WeixinDepartment;



/**
 * 类名: BillTypeService
 * 备注:
 * 时间: 2017年7月30日 下午7:49:09
 * 作者:sylar
 * @version 
 * @since JDK 1.8
 */
public interface DeptService {
	//创建部门
    public int createByParentid(String access_token , String name , String parentid); 
    public int createByCustomid(String access_token , String name , String parentid,String id);
    //修改部门
    public  int updateDept(String accesstoken , String id , String name);
    //删除部门
    public  int deleteDept(String accesstoken , String id);
    //部门列表
    public  List<WeixinDepartment> getDeptList(String accesstoken);
	//获取单个部门
	public List<WeixinDepartment> getDeptById(String access_token, String id);
	
}

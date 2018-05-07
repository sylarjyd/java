package com.jyd.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jyd.domain.WeixinDepartment;
import com.jyd.service.DeptService;
import com.jyd.util.HttpClient;

/**
 * @author yyl
 * EmpController.java
 * 2017-7-21
 */
@Controller
@RequestMapping("/dept")
public class DeptController {
	 
	@Autowired
	private DeptService deptService;
	/**
	 * 
	 * 方法名:loadDeptList
	 * 备注:加载所有部门
	 * 作者:sylar
	 * 时间:2017年9月17日上午11:22:31
	 * @return
	 * @since JDK 1.8
	 */
	@RequestMapping("/loadDeptList")
	@ResponseBody
	public List<WeixinDepartment> loadDeptList(){
		String access_token = HttpClient.getToken();
		List<WeixinDepartment> list = deptService.getDeptList(access_token);
		return list;
	}
	@RequestMapping("/getDeptById")
	@ResponseBody
	public WeixinDepartment getDeptById(WeixinDepartment dept){
		WeixinDepartment wxd = deptService.getDeptById(HttpClient.getToken(),
				String.valueOf(dept.getParentid())).get(0);
		return wxd;
	}
	/**
	 * 方法名:addDept
	 * 备注:添加部门
	 * 作者:sylar
	 * 时间:2017年9月17日上午11:22:46
	 * @param dept
	 * @return
	 * @since JDK 1.8
	 */
	@RequestMapping("/addDept")
	@ResponseBody
	public Map<String,String> addDept(WeixinDepartment dept){
		Map<String,String> map = new HashMap<String,String>();
		try {
			deptService.createByCustomid(HttpClient.getToken(), dept.getName(), 
					String.valueOf(dept.getParentid()), String.valueOf(dept.getId()));
			//HttpClient.createDept(HttpClient.getToken(), dept);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("errorMsg", e.getMessage());
		}
		return map;
	}
	/**
	 * 
	 * 方法名:deleteDept
	 * 备注:删除部门
	 * 作者:sylar
	 * 时间:2017年9月17日上午11:22:15
	 * @param dept
	 * @return
	 * @since JDK 1.8
	 */
	@RequestMapping("/deleteDept")
	@ResponseBody
	public Map<String,String> deleteDept(WeixinDepartment dept){
		Map<String,String> map = new HashMap<String,String>();
		try {
			deptService.deleteDept(HttpClient.getToken(), String.valueOf(dept.getId()));
		} catch (Exception e) {
			e.printStackTrace();
			map.put("errorMsg", e.getMessage());
		}
		return map;
	}
	/**
	 * 
	 * 方法名:updateDept
	 * 备注:修改部门
	 * 作者:sylar
	 * 时间:2017年9月17日上午11:37:06
	 * @param dept
	 * @return
	 * @since JDK 1.8
	 */
	@RequestMapping("/updateDept")
	@ResponseBody
	public Map<String,String> updateDept(WeixinDepartment dept){
		Map<String,String> map = new HashMap<String,String>();
		try {
			deptService.updateDept(HttpClient.getToken(), String.valueOf(dept.getId())
					, String.valueOf(dept.getName()));
		} catch (Exception e) {
			e.printStackTrace();
			map.put("errorMsg", e.getMessage());
		}
		return map;
	}
	/**
	 * 
	 * 方法名:deleteDepts
	 * 备注:批量删除
	 * 作者:sylar
	 * 时间:2017年9月17日上午11:38:28
	 * @param ids
	 * @return
	 * @since JDK 1.8
	 */
	@RequestMapping("/deleteDepts")
	@ResponseBody
	public Map<String,String> deleteDepts(Integer[] ids){
		Map<String,String> map = new HashMap<String,String>();
		try {
			for (Integer id : ids) {
				deptService.deleteDept(HttpClient.getToken(), String.valueOf(id));
			}
		} catch (Exception e) {
			e.printStackTrace();
			map.put("errorMsg", e.getMessage());
		}
		return map;
	}
}



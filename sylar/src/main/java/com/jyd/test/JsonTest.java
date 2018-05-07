/**
 * Project Name:weixin
 * File Name:JsonTest.java
 * Package Name:com.jyd.test
 * Date:2017年9月18日下午2:23:52
 * Copyright (c) 2017
 *
 */
package com.jyd.test;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import net.sf.json.JSONObject;

/**
 * 类名: JsonTest
 * 备注:
 * 时间: 2017年9月18日 下午2:23:52
 * 作者:sylar
 * @version 
 * @since JDK 1.8
 */
public class JsonTest {
	public static void main(String[] args) {
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("uid", UUID.randomUUID().toString());
		map.put("name", "JYD");
		Map<String,Object> map2 = new HashMap<String, Object>();
		map2.put("hobby", "蓝球");
		map2.put("cardno", Math.random());
		map.put("extra", map2);
		System.out.println(MapToJson(map));
	}
	
	public static JSONObject MapToJson(Map<String,Object> map){
		return JSONObject.fromObject(map);
	}
}

package com.jyd.mybatis;
/**
 * Project Name:ssms
 * File Name:MybatisGenerator.java
 * Package Name:com.jyd.mybatis
 * Date:2018年4月1日上午12:14:07
 * Copyright (c) 2018
 */


import org.mybatis.generator.api.ShellRunner;

/**
 * ClassName: MybatisGenerator
 * Comment:
 * Time: 2018年4月1日 上午12:14:07
 * Author:sylar
 * @Version 
 * @Since JDK 1.8
 */
public class MybatisGenerator {
	public static void main(String[] args) {
		 args = new String[] { "-configfile", "src\\main\\resources\\mybatis-generator-config.xml", "-overwrite" };
	     ShellRunner.main(args);
	}
}

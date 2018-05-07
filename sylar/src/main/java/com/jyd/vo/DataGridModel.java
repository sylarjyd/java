/**
 * Project Name:bill
 * File Name:DataGridModel.java
 * Package Name:com.bjsxt.vo
 * Date:2017年7月30日下午5:22:43
 * Copyright (c) 2017
 *
 */
package com.jyd.vo;

import java.util.List;

/**
 * 类名: DataGridModel
 * 备注:
 * 时间: 2017年7月30日 下午5:22:43
 * 作者:sylar
 * @version 
 * @since JDK 1.8
 */
public class DataGridModel {
	private Integer total;
	private List rows;
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public List getRows() {
		return rows;
	}
	public void setRows(List rows) {
		this.rows = rows;
	}
	
}

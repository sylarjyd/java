<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
<script src="/js/add.js"></script>
</head>
<body>
	<div id="app">
		<template>
			<h1>添加用户信息</h1>
			<input id="username" name="username" v-model="userInfo.username">
			<input id="password" name="password" v-model="userInfo.password">
			<a @click="addUser();">添加</a>
		</template>
	</div>
	
</body>
</html>
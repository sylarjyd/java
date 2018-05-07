<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
<script type="text/javascript" src="/js/upload.js"></script>
<link  rel="stylesheet" type="text/css" href="/css/upload.css" />

<!-- 百度编辑器 -->
<script type="text/javascript" charset="utf-8" src="/plugins/ueditor/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8" src="/plugins/ueditor/ueditor.all.min.js"> </script>
<script type="text/javascript" charset="utf-8" src="/plugins/ueditor/lang/zh-cn/zh-cn.js"></script>
<title>Insert title here</title>
</head>
<body>
	<h1>ueditor</h1>
	 <form method="post" name="form">  
	<div id="editor" name="editor" class="upload">
		
	</div>
	 </form>  
	<div><input type="button" value="提交" onclick="t()"></input></div>  
</body>
</html>
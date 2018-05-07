<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%><!-- ${pageContext.request.contextPath} -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/easyui/themes/default/easyui.css" type="text/css"></link>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/easyui/themes/icon.css" type="text/css"></link>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/easyui/themes/color.css" type="text/css"></link>
  
  <script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery.min.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery.easyui.min.js"></script></head>
  

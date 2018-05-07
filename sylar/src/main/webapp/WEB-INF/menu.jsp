<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="commons.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'menu.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
<%-- 	<link rel="stylesheet" href="${pageContext.request.contextPath}/ztree/css/zTreeStyle/zTreeStyle.css" type="text/css"></link> --%>
<%-- 	<script type="text/javascript" src="${pageContext.request.contextPath}/ztree/js/jquery.ztree.core.js"></script> --%>
	
	<link rel="stylesheet" href="/plugins/ztree/css/zTreeStyle/zTreeStyle.css" type="text/css"></link>
	<script type="text/javascript" src="/plugins/ztree/js/jquery.ztree.core.js"></script>
  </head>
  <script type="text/javascript">

	var setting = {
		 view: {
			  selectedMulti: true, //设置是否能够同时选中多个节点
			  showIcon: true, //设置是否显示节点图标
			  showLine: true, //设置是否显示节点与节点之间的连线
			  showTitle: true, //设置是否显示节点的title提示信息
			  },
		  check:{
			  enable: true  //设置是否显示checkbox复选框
			  },
		data: {
			simpleData: {
				enable: true,
				idKey : "id", //指定树节点的id
				pIdKey : "parentid", //指定树节点的父id
			},
			key:{
				name: "name", //指定树节点的名称
			}
		},
		callback: {
			onClick: zTreeOnClick
		}
	};
	$(document).ready(function(){
		$.post("loadDeptList.action",function(zNodes){
			$.fn.zTree.init($("#menuTree"), setting, zNodes);
// 			var treeObj = $.fn.zTree.getZTreeObj("ztree");
// 			var nodes = treeObj.getNodes();
		});
	});
	function zTreeOnClick(event, treeId, treeNode) {
		$("#cc").empty();
		$("#cc").append("<tr height='3px'><th><span>用户ID</span></th><th><span>用户姓名</span></th><th><span>所属部门</span></th><th><span>操作</span></th></tr>");
// 		window.location.href="loadUserList2.action?id="+treeNode.id
 	    $.post("loadUserList2.action","id="+treeNode.id,function(data){
 	    	for (var x = 0; x < data.length; x++) {
 	    		$("#cc").append("<tr align='center'><td>"+data[x].userid+
 	    				"</td><td>"+data[x].name+"</td><td>"+data[x].department[0]+
 	    				"</td><td>"+"<a href='destroyUser.action?userid='"+data[x].userid+">删除</a>&nbsp&nbsp&nbsp"+
 	    				"<a href='updateUser.action?userid='"+data[x].userid+">修改</a>"+
 	    				"</td></tr>");
			}
 	    });
	};
</script>
  <body bgcolor="#e5f4fd" style="margin: 0">
	<div>
		<div style="float:left;width: 300px; height:700px; border-right:#000 solid 1px"">
			<TABLE border=0 width="250" style="border-collapse: collapse;">
				<TR>
					<TD width=340px align=center valign=top>
					<div class="zTreeDemoBackground">
						<ul id="menuTree" class="ztree"></ul>
					</div>
					</TD>
				</TR>
			</TABLE>
		</div>
			<div>
				<table id="cc" border="1px" style="border-collapse: collapse;width: 800px">
			   		<tr height="3px" align="center">
			   			<th><span>用户ID</span></th>
			   			<th><span>用户姓名</span></th>
			   			<th><span>所属部门</span></th>
			   			<th><span>操作</span></th>
			   		</tr>
			   	</table>
			</div>
		</div>
	</div>
</body>
</html>

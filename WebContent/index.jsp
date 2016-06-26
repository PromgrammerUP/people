<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>欢迎页面</title>
</head>
<body>
	<a href="<%=request.getContextPath()%>/action?act=listall">展示所有商品</a>
	<a href="<%=request.getContextPath()%>/action?act=getAddPage">增加人员</a>
</body>
</html>
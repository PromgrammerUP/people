<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<font color="blue" size="6" >增加人员</font>
	<hr color="red">
	<form action="<%=request.getContextPath()%>/action" method="post">
		<input type="hidden" name="act" value="adddo">
		<table>
			<tr><td>姓名</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr><td>年龄</td>
				<td><input type="text" name="age"></td>
			</tr>
			<tr><td>生日</td>
				<td><input type="text" name="birth"></td>
			</tr>
			<tr><td>薪水</td>
				<td><input type="text" name="salary"></td>
			</tr>
			<tr>
				<td colspan="2" align="right">
				<input type="submit" value="增加人员">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>
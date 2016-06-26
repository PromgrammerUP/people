<%@page import="org.javachina.people.dto.PeopleDto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>展示所有人员</title>
<script type="text/javascript">
	function deletePeople(id){
		//alert(id);
		if(window.confirm("确定删除此id？"+id)){
			window.location="<%=request.getContextPath()%>/action?act=del&id=" +id;
		}
	}
</script>
</head>
<body>
	<font color="blue" size="6" >人员列表</font>
	<hr color="red">
	<table width="80%" border="1" cellspacing="0" cellpadding="5">
		<tr><td>ID</td><td>姓名</td><td>年龄</td><td>生日</td><td>薪水</td></tr>
		<%
			ArrayList<PeopleDto> list = (ArrayList)request.getAttribute("list");
			for(PeopleDto dto:list){
			%>
			<tr ondblclick="deletePeople(<%=dto.getId()%>)">
			<td><%=dto.getId() %></td>
			<td><%=dto.getName() %></td>
			<td><%=dto.getAge()%></td>
			<td><%=dto.getBirth() %></td>
			<td><%=dto.getSalary() %></td>
			</tr>
			<%
			}
		%>
	</table>
	<a href="<%=request.getContextPath()%>/action?act=getAddPage">增加人员</a>
</body>
</html>
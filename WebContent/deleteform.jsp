<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String no=request.getParameter("no");
	String msg=(String)request.getAttribute("msg");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>방명록</title>
</head>
<body>
	<%
		if(msg!=null){
	%>
		<h1><%=msg %></h1>
	<%
		}
	%>
	<form method="post" action="/guestbook/gb">
	<input type='hidden' name="a" value="delete">
	<input type='hidden' name="no" value="<%=no%>">
	<table>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" name="password"></td>
			<td><input type="submit" value="확인"></td>
			<td><a href="/guestbook">메인으로 돌아가기</a></td>
		</tr>
	</table>
	</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%--     
<% 
String delnum = request.getParameter("delnum");
%> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>방명록</title>
</head>
<body>

	<form action="/emaillist5/gb/delete" method="post" >
	<tr>
	<table>
		<tr>
			<td><input type="hidden" name="no" value="${param.no}"/></td>
			<td>비밀번호 </td>			
			<td><input type="password" name="password"></td>
			<td><input type="submit" value="확인"></td>
			<td><a href="/emaillist5/gb/list">인덱스로 돌아갑니다.</a></td>
		</tr>
	</table>
	</tr>
	</form>
</body>
</html>
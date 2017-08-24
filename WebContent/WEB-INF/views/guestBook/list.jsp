<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<link href="/emaillist5/assets/css/guestbook.css" rel="stylesheet" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>방명록</title>
</head>
<body>





	<div id="wrapper">
		<div id="content">
			<div id="guestbook">
				<form action="/guestBook3/add" method="post">
					<table border=1 width=800 >
						<tr>
							<td>이름</td>
							<td><input type="text" name="name" value=""></td>
							<td>비밀번호</td><td><input type="password" name="password"value=""></td>
						</tr>
						<tr>
							<td colspan=4><textarea name="content" cols=60 rows=5 value=""></textarea></td>
						</tr>
						<tr>
							<td colspan=4 align=right><input type="submit" VALUE=" 확인 "></td>
						</tr>
					</table>
				</form>
	
				<c:forEach items="${list}" var="vo">
					<table width=800 border=1>
						<tr>
							<td id = number>[${vo.no}]</td>
							<td >이름 :</td>
							<td >${vo.name}</td>
							<td> 작성 날짜 :</td>
							<td>${vo.regDate}</td>
							<td><a href="/emaillist5/gb/deleteform?no=${vo.no}" >삭제</a></td>
						</tr>
						<tr>
							<td colspan=4>${vo.content}</td>
						</tr>
					</table>
					<br>
				</c:forEach>
				
			
				</div>
			</div>
		</div>
	
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="vo.Member" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	Member loginMember = (Member) session.getAttribute("loginMember");

	if(loginMember == null){
%>
		<a href="loginForm.do">로그인</a><br/>
		<a href="joinForm.do">회원가입</a>
<%
	} else {
%>
		<a href="logout.do">로그아웃</a>
<%
	}
%>
</body>
</html>
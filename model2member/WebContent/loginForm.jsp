<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
<style>
	#loginFormArea {
		margin: auto;
		width: 400px;
		border: 1px solid gray;
	}
	table {
		width: 380px;
		margin: auto;
		text-align: center;
	}
</style>
</head>
<body>
	<section id="loginFormArea">
		<form name="loginForm"  action="./memberLoginPro.do" method="post">
			<table>
				<tr>
					<td colspan="2">
						<h1>로그인 페이지</h1>
					</td>
				</tr>
				<tr><td><label for="id">아이디 : </label></td><td><input type="text" name="id" id="id" /></td></tr>
				<tr><td><label for="pw">비밀번호 : </label></td><td><input type="password" name="pw" id="pw" /></td></tr>
				<tr>
					<td colspan="2">
						<a href="javascript:loginForm.submit()">로그인</a>&nbsp;&nbsp;
						<a href="memberJoin.do">회원 가입</a>
					</td>
				</tr>
			</table>
		</form>
	</section>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="vo.Member" %>
<%
	Member loginMember = (Member)session.getAttribute("loginMember");
	if (loginMember != null) {
		out.println("<script>history.back();</script>");
	}
%>
<!DOCTYPE html>
<html>
<head>
		<!-- Required meta tags -->
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
		<!-- Bootstrap CSS -->
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" />
<style>
	body {
		background: fixed no-repeat url("img/budapest.jpg");
	}
	.card {
		margin-top: auto;
		margin-bottom: auto;
		width: 440px;
		background-color: rgba(0,0,0,0.5) !important;
	}
</style>		

<title>Join</title>
</head>
<body>
	<div class="container mt-5 pt-5">
		<div class="d-flex justify-content-center mt-2">
			<div class="card text-white bg-dark rounded">
				<div class="card-header justify-content-start">
					<h3>Sign In</h3>
				</div>
				<div class="card-body bg-transparent">
					<form action="join.do" method="post">
						<div class="input-group input-group-lg flex-nowrap mb-2">
						  <div class="input-group-prepend">
						    <span class="input-group-text" id="addon-wrapping">@</span>
						  </div>
						  <input type="text" class="form-control" placeholder="UserID" name="id"/>
						</div>
						<div class="input-group input-group-lg flex-nowrap mb-2">
						  <div class="input-group-prepend">
						    <span class="input-group-text" id="addon-wrapping">@</span>
						  </div>
						  <input type="password" class="form-control" placeholder="Password" name="passwd"/>
						</div>
						<hr />
						<div class="input-group input-group-lg flex-nowrap mb-2">
						  <div class="input-group-prepend">
						    <span class="input-group-text" id="addon-wrapping">@</span>
						  </div>
						  <input type="text" class="form-control" placeholder="Address" name="addr"/>
						</div>
						<div class="input-group input-group-lg flex-nowrap mb-2">
						  <div class="input-group-prepend">
						    <span class="input-group-text" id="addon-wrapping">@</span>
						  </div>
						  <input type="text" class="form-control" placeholder="Age" name="age"/>
						</div>
						<div class="input-group input-group-lg flex-nowrap mb-2">
						  <div class="input-group-prepend">
						    <span class="input-group-text" id="addon-wrapping">@</span>
						  </div>
						  <input type="text" class="form-control" placeholder="Email" name="email"/>
						</div>
						<hr />
						<div class="btn-group btn-group-toggle mb-2 float-right" data-toggle="buttons">
						  <label class="btn btn-success active">
						    <input type="radio" name="gender"  value="M" checked /> Male
						  </label>
						  <label class="btn btn-info">
						    <input type="radio" name="gender" value="F" /> Female
						  </label>
						</div>
						<div class="input-group input-group-lg flex-nowrap mb-2">
						  <div class="input-group-prepend">
						    <span class="input-group-text" id="addon-wrapping">@</span>
						  </div>
						  <input type="text" class="form-control" placeholder="Name" name="name"/>
						</div>
						<div class="input-group input-group-lg flex-nowrap mb-2">
						  <div class="input-group-prepend">
						    <span class="input-group-text" id="addon-wrapping">@</span>
						  </div>
						  <input type="text" class="form-control" placeholder="Nation" name="nation"/>
						</div>
						<div class="form-group">
							<input type="reset" value="다시 작성" class="btn btn-secondary float-right mt-5 mx-2">
							<input type="submit" value="가입" class="btn btn-warning float-right mt-5">
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>


		<!-- Optional JavaScript; -->
		<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js"></script>
</body>
</html>
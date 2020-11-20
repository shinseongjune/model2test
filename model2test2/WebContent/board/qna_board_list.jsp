<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="vo.PageInfo, vo.BoardBean, java.util.*, java.text.SimpleDateFormat" %>
<%
	ArrayList<BoardBean> articleList = (ArrayList<BoardBean>)request.getAttribute("articleList");
	PageInfo pageInfo = (PageInfo)request.getAttribute("pageInfo");
	int listCount = pageInfo.getListCount();
	int nowPage = pageInfo.getPage();
	int maxPage = pageInfo.getMaxPage();
	int startPage = pageInfo.getStartPage();
	int endPage = pageInfo.getEndPage();
%>
<!DOCTYPE html>
<html>
<head>
		<!-- Required meta tags -->
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
		<!-- Bootstrap CSS -->
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" />
		
		<title>MVC 게시판</title>
	</head>
<body>
	<!-- 게시판 리스트 -->
	<div class="container mt-5">
		<h2><mark>자유</mark>게시판</h2>
		<table class="table">
			<%
			if(articleList != null && listCount > 0) {
			%>
			<thead class="thead-dark">
				<tr>
					<th scope="col">번호</th>
					<th scope="col">제목</th>
					<th scope="col">작성자</th>
					<th scope="col">날짜</th>
					<th scope="col">조회수</th>
				</tr>
			</thead>
			<tbody>
				<%
				for(int i=0;i<articleList.size();i++) {
					
				%>
				<tr>
					<th scope="row"><%=articleList.get(i).getBoard_num() %></th>
					<td>
					
				<%if(articleList.get(i).getBoard_re_lev()!=0) { %>
				<%for(int a=0;a<=articleList.get(i).getBoard_re_lev(
						)*2;a++){ %>
						&nbsp;
						<%} %> └
						<%}else{ %>■<%} %>
							<a href="boardDetail.do?board_num=<%=articleList.get(i).getBoard_num() %>&page=<%=nowPage %>">
							<%=articleList.get(i).getBoard_subject() %>
							</a>
					</td>
					<td><%=articleList.get(i).getBoard_name() %></td>
					<td><%=articleList.get(i).getBoard_date() %></td>
					<td><%=articleList.get(i).getBoard_readcount() %></td>
				</tr>
				<%} %></tbody>
		</table>
			<%
			}
			else
			{
	%>
		<div class="container">등록된 글이 없습니다.</div>
	<%
			}
	%>
	<nav aria-label="Page navigation example">
	  <ul class="pagination pagination-sm justify-content-center">
<%
		if (nowPage <= 1) {
%>
	    <li class="page-item disabled"><a class="page-link" href="boardList.do?page=<%=nowPage-1 %>">Previous</a></li>
<%
		} else {
%>
	    <li class="page-item"><a class="page-link" href="boardList.do?page=<%=nowPage-1 %>">Previous</a></li>
<%
		}
		for(int a = startPage;a<=endPage;a++){
			if(a==nowPage){
%>
	    <li class="page-item active"><a class="page-link" href="boardList.do?page=<%=a %>"><%=a %></a></li>
<%
		} else {
%>
		<li class="page-item"><a class="page-link" href="boardList.do?page=<%=a %>"><%=a %></a></li>
<%
		}
		}
		
		if(nowPage>=endPage) {
%>
	    <li class="page-item disabled"><a class="page-link" href="boardList.do?page=<%=nowPage+1 %>">Next</a></li>
<%
		} else {
%>
	    <li class="page-item"><a class="page-link" href="boardList.do?page=<%=nowPage+1 %>">Next</a></li>
<%
		}
%>	    
	  </ul>
	</nav>
	<div class="row">
		<div class="col-2 ml-auto"><a href="boardWriteForm.do"><input type="button" class="btn btn-info" value="글쓰기"/></a></div>
	</div>
	</div>
	
	

	
	<!-- Optional JavaScript; -->
		<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js"></script>
</body>
</html>
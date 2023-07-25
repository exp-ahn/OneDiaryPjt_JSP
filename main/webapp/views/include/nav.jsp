<%@page import="com.office.diary.member.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<link href="./css/include/nav.css" rel="stylesheet" type="text/css">

<nav>
	
	<div id="nav_wrap">
		
		<%
			MemberDto logined_memberDto = (MemberDto) session.getAttribute("logined_memberDto");
			if (logined_memberDto == null) {
		%>
			<a href="<%= request.getContextPath()%>/">홈</a>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="<%= request.getContextPath()%>/member_regist_form.mem">계정생성</a>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="<%= request.getContextPath()%>/member_login_form.mem">로그인</a>
		<%
			} else {
			
		%>
			<a href="<%= request.getContextPath()%>/">홈</a>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="<%= request.getContextPath()%>/member_modify_form.mem">계정수정</a>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="<%= request.getContextPath()%>/member_delete_confirm.mem">회원탈퇴</a>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="<%= request.getContextPath()%>/member_logout_confirm.mem">로그아웃</a>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="<%= request.getContextPath()%>/diary_list.dir">일기 작성 및 리스트</a>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="<%= request.getContextPath()%>/diary_search_form.dir">일기 검색</a>
		<%
				
			}
		%>
		
	</div>

</nav>
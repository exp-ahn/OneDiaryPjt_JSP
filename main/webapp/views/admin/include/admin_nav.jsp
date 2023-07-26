<%@page import="com.office.diary.member.MemberDto"%>
<%@page import="com.office.diary.admin.AdminDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<link href="./css/include/nav.css" rel="stylesheet" type="text/css">

<nav>
	
	<div id="nav_wrap">
		
		<%
			AdminDto logined_adminDto = (AdminDto) session.getAttribute("logined_adminDto");
			if (logined_adminDto == null) {
		%>
			<a href="<%= request.getContextPath()%>/admin_index_form.mem">홈</a>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="<%= request.getContextPath()%>/admin_regist_form.adm">계정생성</a>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="<%= request.getContextPath()%>/admin_login_form.adm">로그인</a>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="<%= request.getContextPath()%>/">사용자 모드</a>
		<%
			} else {
			
		%>
			<a href="<%= request.getContextPath()%>/admin_index_form.mem">홈</a>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="<%= request.getContextPath()%>/admin_modify_form.adm">계정수정</a>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="<%= request.getContextPath()%>/admin_delete_confirm.adm">회원탈퇴</a>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="<%= request.getContextPath()%>/admin_logout_confirm.adm">로그아웃</a>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="<%= request.getContextPath()%>/admin_list.adm">관리자 리스트</a>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="<%= request.getContextPath()%>/user_list.adm">사용자 리스트</a>
		<%
				
			}
		%>
		
	</div>

</nav>
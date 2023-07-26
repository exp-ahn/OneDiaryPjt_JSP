<%@page import="java.util.ArrayList"%>
<%@page import="com.office.diary.member.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<%@ include file="../../include/title.jsp"%>

<link href="./css/member/member_modify_form.css" rel="stylesheet" type="text/css">
<script src="./admin/js/member/user_modify_form.js" type="text/javascript"></script>

</head>
<body>

	<%@ include file="../../include/header.jsp"%>

	<%@ include file="../include/admin_nav.jsp"%>

	<section>

		<div id="section_wrap">

			<div class="article">

				<form action="<%=request.getContextPath()%>/user_modify_confirm.adm" method="post" name="user_modify_form">
					<%
						MemberDto memberDto = (MemberDto)request.getAttribute("memberDto");
					%>
						<input type="hidden" name="m_no" value="<%=memberDto.getM_no()%>">
						<input type="hidden" name="m_pw" value="<%=memberDto.getM_pw()%>">
						<br> 
						<input type="text" name="m_id" value="<%=memberDto.getM_id()%>" readonly="readonly" disabled="disabled"> 
						<br> 
						<input type="password" name="m_pw" value="<%=memberDto.getM_pw()%>" readonly="readonly" disabled="disabled"> 
						<br> 
						<input type="text" name="m_mail" value="<%=memberDto.getM_mail()%>" placeholder="INPUT MEMBER MAIL."> 
						<br> 
						<input type="text" name="m_phone" value="<%=memberDto.getM_phone()%>" placeholder="INPUT MEMBER PHONE."> 
						<br> 
						<input type="button" value="정보수정" onclick="userModifyForm();"> 
						<input type="reset" value="초기화">

				</form>

			</div>

		</div>

	</section>

	<%@ include file="../../include/footer.jsp"%>

</body>
</html>
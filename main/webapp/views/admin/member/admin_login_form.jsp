<%@page import="com.office.diary.member.MemberDto" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<%@ include file="../../include/title.jsp" %>

<link href="./css/member/member_login_form.css" rel="stylesheet" type="text/css">
<script src="./admin/js/member/admin_login_form.js" type="text/javascript"></script>

</head>
<body>

	<%@ include file="../../include/header.jsp" %>
	
	<%@ include file="../include/admin_nav.jsp" %>
	
	<section>

		<div id="section_wrap">
		
			<div class="article">
			
				<form action="<%=request.getContextPath()%>/admin_login_confirm.adm" method="post" name="admin_login_form">
					
					<input type="text" name="a_id" placeholder="INPUT ADMIN ID.">
					<br>
					<input type="password" name="a_pw" placeholder="INPUT ADMIN PW.">
					<br>
					<input type="button" value="로그인" onclick="adminLoginForm();">
					<input type="reset" value="초기화">
					
				</form>
			
			</div>
		
		</div>
		
	</section>
	
	<%@ include file="../../include/footer.jsp" %>

</body>
</html>
<%@page import="com.office.diary.member.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<%@ include file="../include/title.jsp" %>

<link href="./css/member/member_regist_form.css" rel="stylesheet" type="text/css">
<script src="./js/member/member_regist_form.js" type="text/javascript"></script>

</head>
<body>

	<%@ include file="../include/header.jsp" %>
	
	<%@ include file="../include/nav.jsp" %>
	
	<section>

		<div id="section_wrap">
		
			<div class="article">
			
				<form action="<%=request.getContextPath()%>/member_regist_confirm.mem" method="post" name="member_regist_form">
					
					<input type="text" name="m_id" placeholder="INPUT MEMBER ID.">
					<br>
					<input type="password" name="m_pw" placeholder="INPUT MEMBER PW.">
					<br>
					<input type="text" name="m_mail" placeholder="INPUT MEMBER MAIL.">
					<br>
					<input type="text" name="m_phone" placeholder="INPUT MEMBER PHONE.">
					<br>
					<input type="button" value="계정생성" onclick="memberRegistForm();">
					<input type="reset" value="초기화">
					
				</form>
			
			</div>
		
		</div>
		
	</section>
	
	<%@ include file="../include/footer.jsp" %>

</body>
</html>
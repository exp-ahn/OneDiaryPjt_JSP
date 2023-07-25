<%@page import="com.office.diary.member.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<%@ include file="../include/title.jsp" %>

<link href="./css/member/member_modify_form.css" rel="stylesheet" type="text/css">
<script src="./js/member/member_modify_form.js" type="text/javascript"></script>

</head>
<body>

	<%@ include file="../include/header.jsp" %>
	
	<%@ include file="../include/nav.jsp" %>
	
	<section>

		<div id="section_wrap">
		
			<div class="article">
			
				<form action="<%=request.getContextPath()%>/member_modify_confirm.mem" method="post" name="member_modify_form">
					
					<input type="hidden" name="m_no" value="<%=logined_memberDto.getM_no() %>">
					<br>
					<input type="text" name="m_id" value="<%=logined_memberDto.getM_id()%>" readonly="readonly" disabled="disabled">
					<br>
					<input type="password" name="m_pw" value="<%=logined_memberDto.getM_pw()%>" placeholder="INPUT MEMBER PW.">
					<br>
					<input type="text" name="m_mail" value="<%=logined_memberDto.getM_mail()%>" placeholder="INPUT MEMBER MAIL.">
					<br>
					<input type="text" name="m_phone" value="<%=logined_memberDto.getM_phone()%>" placeholder="INPUT MEMBER PHONE.">
					<br>
					<input type="button" value="정보수정" onclick="memberModifyForm();">
					<input type="reset" value="초기화">
					
				</form>
			
			</div>
		
		</div>
		
	</section>
	
	<%@ include file="../include/footer.jsp" %>

</body>
</html>
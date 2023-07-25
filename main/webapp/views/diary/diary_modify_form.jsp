<%@page import="com.office.diary.onediary.OneDiaryDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.office.diary.member.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<%@ include file="../include/title.jsp" %>

<link href="./css/diary/diary_modify_form.css" rel="stylesheet" type="text/css">
<script src="./js/diary/diary_modify_form.js" type="text/javascript"></script>

</head>
<body>

	<%@ include file="../include/header.jsp" %>
	
	<%@ include file="../include/nav.jsp" %>
	
	<section>
	
		<div id="section_wrap">
		
			<div class="diary_regist">
				
				<p>Diary Modify Form</p>
				
				<form action="<%=request.getContextPath()%>/diary_modify_confirm.dir" method="post" name="diary_modify_form">
					
					<%
						OneDiaryDto oneDiaryDto = (OneDiaryDto) request.getAttribute("oneDiaryDto");
					%>
					
					<input type="hidden" name="d_no" value="<%=oneDiaryDto.getD_no()%>">
					
					<table>
						<tr>
							<td>
								<input type="text" name="d_word" value="<%=oneDiaryDto.getD_word()%>" placeholder="INPUT DIARY.">
							</td>
						</tr>
						<tr>
							<td>
								<input type="button" value="일기수정" onclick="diaryModifyForm();">
								<input type="reset" value="초기화">
							</td>
						</tr>
					</table>
				
				</form>
				
			</div>
			
		</div>
	
	</section>
	
	<%@ include file="../include/footer.jsp" %>

</body>
</html>
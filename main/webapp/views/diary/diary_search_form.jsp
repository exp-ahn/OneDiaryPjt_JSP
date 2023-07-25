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

<link href="./css/diary/diary_search_form.css" rel="stylesheet" type="text/css">
<script src="./js/diary/diary_search_form.js" type="text/javascript"></script>

</head>
<body>

	<%@ include file="../include/header.jsp" %>
	
	<%@ include file="../include/nav.jsp" %>
	
	<section>
	
		<div id="section_wrap">
		
			<div class="diary_search">
				
				<p>Diary Search Form</p>
				
				<form action="<%=request.getContextPath()%>/diary_search_confirm.dir" method="get" name="diary_search_form">
				
					<table>
						<tr>
							<td>
								<input type="text" name="search_txt" placeholder="INPUT SEARCH TEXT.">
							</td>
						</tr>
						<tr>
							<td>
								<input type="button" value="일기검색" onclick="diarySearchForm();">
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
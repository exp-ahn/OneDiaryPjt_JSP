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

<link href="./css/diary/diary_list.css" rel="stylesheet" type="text/css">
<script src="./js/diary/diary_list.js" type="text/javascript"></script>

</head>
<body>

	<%@ include file="../include/header.jsp" %>
	
	<%@ include file="../include/nav.jsp" %>
	
	<section>
	
		<div id="section_wrap">
		
			<div class="diary_regist">
				
				<p>Diary Regist Form</p>
				
				<form action="<%=request.getContextPath()%>/diary_regist_confirm.dir" method="post" name="diary_regist_form">
				
					<table>
						<tr>
							<td>
								<input type="text" name="d_word" placeholder="INPUT DIARY.">
							</td>
						</tr>
						<tr>
							<td>
								<input type="button" value="일기작성" onclick="diaryRegistForm();">
								<input type="reset" value="초기화">
							</td>
						</tr>
					</table>
				
				</form>
				
			</div>
			
			<div class="diary_list">
			
				<p>Diary List</p>
				
				<table>
					<thead>
						<tr>
							<th>일기</th>
							<th>작성자</th>
							<th>작성일</th>
							<th>수정일</th>
							<th>수정</th>
							<th>삭제</th>
						</tr>
					</thead>
					<tbody>
					<%
						ArrayList<OneDiaryDto> oneDiaryDtos = (ArrayList<OneDiaryDto>) request.getAttribute("oneDiaryDtos");
						if (oneDiaryDtos != null) {
							
							for (int i = 0; i < oneDiaryDtos.size(); i++) {
					%>
								<tr>
									<td><%=oneDiaryDtos.get(i).getD_word()%></td>
									<td><%=oneDiaryDtos.get(i).getM_id()%></td>
									<td><%=oneDiaryDtos.get(i).getD_reg_date().substring(2)%></td>
									<td><%=oneDiaryDtos.get(i).getD_mod_date().substring(2)%></td>
									<td><a class="btn_modify" href="<%=request.getContextPath()%>/diary_modify_form.dir?d_no=<%=oneDiaryDtos.get(i).getD_no() %>">수정</a></td>
									<td><a class="btn_modify" href="<%=request.getContextPath()%>/diary_delete_confirm.dir?d_no=<%=oneDiaryDtos.get(i).getD_no() %>">삭제</a></td>
								</tr>		
					<%
							}
							
						}
					%>
					</tbody>
				</table>
				
			</div>
		
		</div>
	
	</section>
	
	<%@ include file="../include/footer.jsp" %>

</body>
</html>
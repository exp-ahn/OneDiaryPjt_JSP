<%@page import="com.office.diary.onediary.OneDiaryDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.office.diary.member.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<%@ include file="../../include/title.jsp" %>

<link href="./css/diary/diary_list.css" rel="stylesheet" type="text/css">
<script src="./js/diary/diary_list.js" type="text/javascript"></script>

</head>
<body>

	<%@ include file="../../include/header.jsp" %>
	
	<%@ include file="../include/admin_nav.jsp" %>
	
	<section>
	
		<div id="section_wrap">
			
			<div class="diary_list">
			
				<p>Diary List</p>
				
				<table>
					<thead>
						<tr>
							<th>일기</th>
							<th>작성자</th>
							<th>작성일</th>
							<th>수정일</th>
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
	
	<%@ include file="../../include/footer.jsp" %>

</body>
</html>
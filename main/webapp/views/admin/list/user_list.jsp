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

<link href="./admin/css/admin_list.css" rel="stylesheet" type="text/css">
<script src="./js/diary/diary_list.js" type="text/javascript"></script>

</head>
<body>

	<%@ include file="../../include/header.jsp" %>
	
	<%@ include file="../include/admin_nav.jsp" %>
	
	<section>
	
		<div id="section_wrap">
			
			<div class="diary_list">
			
				<p>USER LIST</p>
				<br>
				
				<table>
					<thead>
						<tr>
							<th>사용자 계정</th>
							<th>메일</th>
							<th>휴대전화</th>
							<th>등록일</th>
							<th>수정일</th>
							<th>정보 수정</th>
							<th>일기 리스트</th>
						</tr>
					</thead>
					<tbody>
					<%
						ArrayList<MemberDto> memberDtos = (ArrayList<MemberDto>) request.getAttribute("memberDtos");
						if (memberDtos != null) {
							
							for (int i = 0; i < memberDtos.size(); i++) {
					%>
								<tr>
									<td><%=memberDtos.get(i).getM_id()%></td>
									<td><%=memberDtos.get(i).getM_mail()%></td>
									<td><%=memberDtos.get(i).getM_phone()%></td>
									<td><%=memberDtos.get(i).getM_reg_date().substring(2)%></td>
									<td><%=memberDtos.get(i).getM_mod_date().substring(2)%></td>
									<td><a class="btn_modify" href="<%=request.getContextPath()%>/user_modify_form.adm?m_no=<%=memberDtos.get(i).getM_no() %>">정보 수정</a></td>
									<td><a class="btn_diary_list" href="<%=request.getContextPath()%>/user_diary_list.adm?m_id=<%=memberDtos.get(i).getM_id() %>">일기 리스트</a></td>
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
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
			
				<p>ADMIN LIST</p>
				<br>
				
				<table>
					<thead>
						<tr>
							<th>관리자 계정</th>
							<th>등급</th>
							<th>메일</th>
							<th>휴대전화</th>
							<th>등록일</th>
							<th>수정일</th>
							<th>권한 승인</th>
							<th>권한 회수</th>
						</tr>
					</thead>
					<tbody>
					<%
						ArrayList<AdminDto> adminDtos = (ArrayList<AdminDto>) request.getAttribute("adminDtos");
						if (adminDtos != null) {
							
							for (int i = 0; i < adminDtos.size(); i++) {
					%>
								<tr>
									<td><%=adminDtos.get(i).getA_id()%></td>
									<td><%=adminDtos.get(i).getA_grade()%></td>
									<td><%=adminDtos.get(i).getA_mail()%></td>
									<td><%=adminDtos.get(i).getA_phone()%></td>
									<td><%=adminDtos.get(i).getA_reg_date().substring(2)%></td>
									<td><%=adminDtos.get(i).getA_mod_date().substring(2)%></td>
									<td><a class="btn_approve" href="<%=request.getContextPath()%>/diary_modify_form.dir?d_no=<%=adminDtos.get(i).getA_no() %>">승인</a></td>
									<td><a class="btn_approve_return" href="<%=request.getContextPath()%>/diary_delete_confirm.dir?d_no=<%=adminDtos.get(i).getA_no() %>">회수</a></td>
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
package com.office.diary.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.office.diary.member.MemberService;
import com.office.diary.onediary.OneDiaryService;

@WebServlet("*.adm")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AdminController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());
		
		AdminService adminService = null;
		MemberService memberService = null;
		String nextPage = null;
		
		if (command.equals("/user_index_form.adm")) {
			System.out.println("[AdminController] /user_index_form.adm");
			
			nextPage = "/";
			
		} else if (command.equals("/admin_regist_form.adm")) {
			System.out.println("[AdminController] /admin_regist_form.adm");
			
			nextPage = "views/admin/member/admin_regist_form.jsp";
			
		} else if (command.equals("/admin_regist_confirm.adm")) {
			System.out.println("[AdminController] /admin_regist_confirm.adm");
			
			adminService = new AdminService();
			
			int result = adminService.adminRegistConfirm(request, response);
			
			if (result > 0) {
				nextPage = "views/admin/member/admin_regist_success.jsp";
			} else {
				nextPage = "views/admin/member/admin_regist_fail.jsp";
			}
				
		} else if (command.equals("/admin_login_form.adm")) {
			System.out.println("[AdminController] /admin_login_form.adm");
			
			nextPage = "views/admin/member/admin_login_form.jsp";
			
		} else if (command.equals("/admin_login_confirm.adm")) {
			System.out.println("[AdminController] /admin_login_confirm.adm");
			
			adminService = new AdminService();
			
			AdminDto logined_adminDto = adminService.adminLoginConfirm(request, response);
			
			if (logined_adminDto != null) {
				nextPage = "views/admin/member/admin_login_success.jsp";
			} else {
				nextPage = "views/admin/member/admin_login_fail.jsp";
			}
				
		} else if (command.equals("/admin_modify_form.adm")) {
			
		} else if (command.equals("/admin_modify_confirm.adm")) {
			
		} else if (command.equals("/admin_delete_confirm.adm")) {
			
		} else if (command.equals("/admin_logout_confirm.adm")) {
			System.out.println("[AdminController] /admin_logout_confirm.adm");
			
			adminService = new AdminService();
			
			adminService.adminLogoutConfirm(request, response);
			
			nextPage = "views/admin/index.jsp";
			
		} else if (command.equals("/admin_list.adm")) {
			System.out.println("[AdminController] /admin_list.adm");
			
			adminService = new AdminService();
			adminService.adminList(request, response);
			
			nextPage = "views/admin/list/admin_list.jsp";
			
		} else if (command.equals("/user_list.adm")) {
			System.out.println("[AdminController] /user_list.adm");
			
			adminService = new AdminService();
			adminService.userList(request, response);
			
			nextPage = "views/admin/list/user_list.jsp";
			
		} else if (command.equals("/user_modify_form.adm")) {
			System.out.println("[AdminController] /user_modify_form.adm");
			
			memberService = new MemberService();
			memberService.selectMemberDtoByNo(request, response);
			
			nextPage = "views/admin/member/user_modify_form.jsp";
			
		} else if (command.equals("/user_modify_confirm.adm")) {
			System.out.println("[AdminController] /user_modify_comfirm.adm");
			
			memberService = new MemberService();
			
			int result = memberService.memberModifyConfirm(request, response);
			
			if (result > 0) {
				nextPage = "views/admin/member/user_modify_success.jsp";
			} else {
				nextPage = "views/admin/member/user_modify_fail.jsp";
			}
			
		} else if (command.equals("/user_diary_list.adm")) {
			System.out.println("[AdminController] /user_diary_list.adm");
			
			adminService = new AdminService();
			adminService.diaryList(request, response);
			
			nextPage = "views/admin/list/user_diary_list.jsp";
			
		}
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(nextPage);
		requestDispatcher.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

}

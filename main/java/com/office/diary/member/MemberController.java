package com.office.diary.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("*.mem")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String requestURI = request.getRequestURI();			// /OneDiaryPjt/signup.mem   --> URI
		String contextPath =  request.getContextPath();	    	// /OneDiaryPjt				-- context path
		String command = requestURI.substring(contextPath.length());	// /signup.mem
		
		IMemberService memberService = null;
		String nextPage = null;
		
		if (command.equals("/member_regist_form.mem")) {			  // 회원 가입 양식
			System.out.println("[MemberController] /member_regist_form.mem");
			
			nextPage = "views/member/member_regist_form.jsp";
			
		} else if (command.equals("/member_regist_confirm.mem")) {    // 회원 가입 확인
			System.out.println("[MemberController] /member_regist_confirm.mem");
			
			memberService = new MemberService();
			
			int result = memberService.memberRegistConfirm(request, response);
			if (result > 0) {
				nextPage = "views/member/member_regist_success.jsp";
			} else {
				nextPage = "views/member/member_regist_fail.jsp";
			}
			
		} else if (command.equals("/member_login_form.mem")) {		  // 회원 로그인 양식
			System.out.println("[MemberController] /member_login_form.mem");
			
			nextPage = "views/member/member_login_form.jsp";
			
		} else if (command.equals("/member_login_confirm.mem")) {	  // 회원 로그인 확인
			System.out.println("[MemberController] /member_login_confirm.mem");
			
			memberService = new MemberService();
			
			MemberDto logined_memberDto = memberService.memberLoginConfirm(request, response);
			if (logined_memberDto != null) {
				nextPage = "views/member/member_login_success.jsp";
			} else {
				nextPage = "views/member/member_login_fail.jsp";
			}
			
		} else if (command.equals("/member_modify_form.mem")) {	       // 회원 정보 수정 양식
			System.out.println("[MemberController] /member_modify_form.mem");
			
			nextPage = "views/member/member_modify_form.jsp";
			
		} else if (command.equals("/member_modify_confirm.mem")) {	   // 회원 정보 수정 확인
			System.out.println("[MemberController] /member_modify_confirm.mem");
			
			memberService = new MemberService();
			
			int result = memberService.memberModifyConfirm(request, response);
			
			if (result > 0) {
				nextPage = "views/member/member_modify_success.jsp";
				
			} else {
				nextPage = "views/member/member_modify_fail.jsp";
				
			}
			
		} else if (command.equals("/member_delete_confirm.mem")) {	   // 회원 탈퇴 확인
			System.out.println("[MemberController] /member_delete_confirm.mem");
			
			memberService = new MemberService();
			
			int result = memberService.memberDeleteConfirm(request, response);
			
			if (result > 0) {
				nextPage = "views/member/member_delete_success.jsp";
				
			} else {
				nextPage = "views/member/member_delete_fail.jsp";
				
			}
			
			
		} else if (command.equals("/member_logout_confirm.mem")) {	   // 회원 로그 아웃 확인
			System.out.println("[MemberController] /member_logout_confirm.mem");
			
			memberService = new MemberService();
			
			memberService.memberLogoutConfirm(request, response);
			
			nextPage = "index.jsp";
			
		} else if (command.equals("/admin_index_form.mem")) {
			System.out.println("[MemberController] /admin_index_form.mem");
			
			nextPage = "views/admin/index.jsp";
		}
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(nextPage);
		requestDispatcher.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

}

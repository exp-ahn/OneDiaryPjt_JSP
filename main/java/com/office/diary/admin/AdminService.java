package com.office.diary.admin;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.office.diary.member.MemberDto;
import com.office.diary.onediary.OneDiaryDao;
import com.office.diary.onediary.OneDiaryDto;

public class AdminService {
	
	AdminDao adminDao = new AdminDao();
	

	public int adminRegistConfirm(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("[AdminService] adminRegistConfirm()");
		
		String a_id = request.getParameter("a_id");
		String a_pw = request.getParameter("a_pw");
		String a_mail = request.getParameter("a_mail");
		String a_phone = request.getParameter("a_phone");
		
		AdminDto adminDto = new AdminDto();
		adminDto.setA_id(a_id);
		adminDto.setA_pw(a_pw);
		adminDto.setA_mail(a_mail);
		adminDto.setA_phone(a_phone);
		
		boolean isAdmin = adminDao.isAdmin(adminDto.getA_id());
		
		int result = adminDao.adminRegistConfirm(adminDto);
		if (!isAdmin) {
			if (result > 0) {
				System.out.println("ADMIN REGIST SUCCESS!!");
			} else {
				System.out.println("ADMIN REGIST FAIL!!");
			}
		}

		
		return result;
	}

	public AdminDto adminLoginConfirm(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("[AdminService] adminLoginConfirm()");
		
		String a_id = request.getParameter("a_id");
		String a_pw = request.getParameter("a_pw");
		
		AdminDto logined_adminDto = adminDao.adminLoginConfirm(a_id, a_pw);
		if (logined_adminDto != null) {
			System.out.println("ADMIN LOGIN SUCCESS!!");
			
			HttpSession session = request.getSession();
			session.setAttribute("logined_adminDto", logined_adminDto);
			session.setMaxInactiveInterval(60*30);
			
		} else {
			System.out.println("ADMIN LOGIN FAIL!!");
		}
		return logined_adminDto;
	}

	public void adminLogoutConfirm(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("[AdminService] adminLogoutConfirm()");
		
		HttpSession session = request.getSession();
		session.invalidate();
		
	}

	public void adminList(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("[AdminService] adminList()");
		
		HttpSession session = request.getSession();
		AdminDto logined_adminDto = (AdminDto) session.getAttribute("logined_adminDto");
		
		ArrayList<AdminDto> adminDtos = adminDao.adminList(logined_adminDto.getA_id());
		
		request.setAttribute("adminDtos", adminDtos);
		
	}

	public void userList(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("[AdminService] userList()");
		
//		HttpSession session = request.getSession();
//		MemberDto logined_memberDto = (MemberDto) session.getAttribute("logined_memberDto");
		
		ArrayList<MemberDto> userDtos = adminDao.userList(/*logined_memberDto.getM_id()*/);
		
		request.setAttribute("memberDtos", userDtos);
		
	}

	public void diaryList(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("[AdminService] diaryList()");
		
		OneDiaryDao oneDiaryDao = new OneDiaryDao();
		
		String m_id = request.getParameter("m_id");
		
		ArrayList<OneDiaryDto> oneDiaryDtos = oneDiaryDao.diaryList(m_id);
		
		request.setAttribute("oneDiaryDtos", oneDiaryDtos);
		
	}



}

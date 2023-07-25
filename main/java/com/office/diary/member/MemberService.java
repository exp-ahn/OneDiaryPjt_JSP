package com.office.diary.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MemberService implements IMemberService {

	MemberDao memberDao = new MemberDao();
	
	@Override
	public int memberRegistConfirm(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("[MemberService] memberRegistConfirm()");
		
		String m_id = request.getParameter("m_id");
		String m_pw = request.getParameter("m_pw");
		String m_mail = request.getParameter("m_mail");
		String m_phone = request.getParameter("m_phone");
		
		MemberDto memberDto = new MemberDto();
		memberDto.setM_id(m_id);
		memberDto.setM_pw(m_pw);
		memberDto.setM_mail(m_mail);
		memberDto.setM_phone(m_phone);
		
		int result = memberDao.memberRegistConfirm(memberDto);
		if (result > 0) {
			System.out.println("MEMBER REGIST SUCCESS!!");
			
		} else {
			System.out.println("MEMBER REGIST FAIl!!");
			
		}
		
		return result;
	}

	@Override
	public MemberDto memberLoginConfirm(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("[MemberService] memberLoginConfirm()");
		
		String m_id = request.getParameter("m_id");
		String m_pw = request.getParameter("m_pw");
		
		MemberDto logined_memberDto = memberDao.memberLoginConfirm(m_id, m_pw);
		if (logined_memberDto != null) {
			System.out.println("MEMBER LOGIN SUCCESS!!");
			
			HttpSession session = request.getSession();
			session.setAttribute("logined_memberDto", logined_memberDto);
			session.setMaxInactiveInterval(60 * 30);
			
		} else {
			System.out.println("MEMBER LOGIN FAIL!!");
			
		}
		
		return logined_memberDto;
	}

	@Override
	public void memberLogoutConfirm(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("[MemberService] memberLogoutConfirm()");
		
		HttpSession session = request.getSession();
		session.invalidate();
		
	}

	@Override
	public int memberModifyConfirm(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("[MemberService] memberModifyConfirm()");
		
		int m_no = Integer.parseInt(request.getParameter("m_no"));
		String m_pw = request.getParameter("m_pw");
		String m_mail = request.getParameter("m_mail");
		String m_phone = request.getParameter("m_phone");
		
		MemberDto memberDto = new MemberDto();
		memberDto.setM_no(m_no);
		memberDto.setM_pw(m_pw);
		memberDto.setM_mail(m_mail);
		memberDto.setM_phone(m_phone);
		
		int result = memberDao.memberModifyConfirm(memberDto);
		
		if (result > 0) {
			System.out.println("MEMBER MODIFY SUCCESS!!");
			
			MemberDto dto = memberDao.selectLatestModifyMember(m_no);
			
			HttpSession session = request.getSession();
			session.setAttribute("logined_memberDto", dto);
			
		} else {
			System.out.println("MEMBER MODIFY FAIl!!");
			
			
		}
		
		return result;
	}

	@Override
	public int memberDeleteConfirm(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("[MemberService] memberDeleteConfirm()");
		
		HttpSession session = request.getSession();
		MemberDto logined_memberDto = (MemberDto) session.getAttribute("logined_memberDto");
		
		int result = memberDao.memberDeleteConfirm(logined_memberDto.getM_no());
		
		if (result > 0) {
			System.out.println("MEMBER DELETE SUCCESS!!");
			
			session.invalidate();
			
		} else {
			System.out.println("MEMBER DELETE FAIl!!");
			
		}
		
		return result;
		
	}

}

package com.office.diary.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IMemberService {

	public int memberRegistConfirm(HttpServletRequest request, HttpServletResponse response);
	public MemberDto memberLoginConfirm(HttpServletRequest request, HttpServletResponse response);
	public void memberLogoutConfirm(HttpServletRequest request, HttpServletResponse response);
	public int memberModifyConfirm(HttpServletRequest request, HttpServletResponse response);
	public int memberDeleteConfirm(HttpServletRequest request, HttpServletResponse response);
	
}

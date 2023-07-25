package com.office.diary.onediary;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;
import com.office.diary.member.MemberDto;

public class OneDiaryService {

	OneDiaryDao oneDiaryDao = new OneDiaryDao();
	
	public void diaryList(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("[OneDiaryService] diaryList()");
		
		HttpSession session = request.getSession();
		MemberDto logined_memberDto = (MemberDto) session.getAttribute("logined_memberDto");
		
		ArrayList<OneDiaryDto> oneDiaryDtos = oneDiaryDao.diaryList(logined_memberDto.getM_id());
		
		request.setAttribute("oneDiaryDtos", oneDiaryDtos);
		
	}

	public void diaryRegistConfirm(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("[OneDiaryService] diaryList()");
		
		HttpSession session = request.getSession();
		MemberDto logined_memberDto = (MemberDto) session.getAttribute("logined_memberDto");
		
		String m_id = logined_memberDto.getM_id();
		String d_word = request.getParameter("d_word");
		
		int result = oneDiaryDao.diaryRegistConfirm(m_id, d_word);
		if (result > 0) {
			System.out.println("DIARY REGIST SUCCESS!!");
			
		} else {
			System.out.println("DIARY REGIST FAIl!!");
			
		}
		
	}

	public void diaryModifyForm(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("[OneDiaryService] diaryModifyForm()");
		
		int d_no = Integer.parseInt(request.getParameter("d_no"));
		
		OneDiaryDto oneDiaryDto = oneDiaryDao.diaryModifyForm(d_no);
		
		request.setAttribute("oneDiaryDto", oneDiaryDto);
		
	}

	public void diaryModifyConfirm(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("[OneDiaryService] diaryModifyConfirm()");
		
		int d_no = Integer.parseInt(request.getParameter("d_no"));
		String d_word = request.getParameter("d_word");
		
		int result = oneDiaryDao.diaryModifyConfirm(d_no, d_word);
		
		if (result > 0) {
			System.out.println("DIARY MODIFY SUCCESS!!");
			
		} else {
			System.out.println("DIARY MODIFY FAIl!!");
			
		}
		
	}

	public void diaryDeleteConfirm(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("[OneDiaryService] diaryDeleteConfirm()");
		
		int d_no = Integer.parseInt(request.getParameter("d_no"));
		
		int result = oneDiaryDao.diaryDeleteConfirm(d_no);
		
		if (result > 0) {
			System.out.println("DIARY DELETE SUCCESS!!");
			
		} else {
			System.out.println("DIARY DELETE FAIl!!");
			
		}
		
	}

	public void diarySearchConfirm(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("[OneDiaryService] diarySearchConfirm()");
		
		HttpSession session = request.getSession();
		MemberDto logined_memberDto = (MemberDto) session.getAttribute("logined_memberDto");
		
		List<OneDiaryDto> oneDiaryDtos = oneDiaryDao.diarySearchConfirm(logined_memberDto.getM_id(), request.getParameter("search_txt"));
		
		request.setAttribute("oneDiaryDtos", oneDiaryDtos);
		
	}

}

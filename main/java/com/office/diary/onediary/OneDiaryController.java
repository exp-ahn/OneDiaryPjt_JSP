package com.office.diary.onediary;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("*.dir")
public class OneDiaryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public OneDiaryController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());
		
		OneDiaryService oneDiaryService = null;
		String nextPage = null;
		
		if (command.equals("/diary_list.dir")) {
			System.out.println("[OneDiaryController] /diary_list.dir");
			
			oneDiaryService = new OneDiaryService();
			oneDiaryService.diaryList(request, response);
			
			nextPage = "views/diary/diary_list.jsp";
			
		} else if (command.equals("/diary_regist_confirm.dir")) {
			System.out.println("[OneDiaryController] /diary_regist_confirm.dir");
			
			oneDiaryService = new OneDiaryService();
			oneDiaryService.diaryRegistConfirm(request, response);
			
			nextPage = "/diary_list.dir";
			
		} else if (command.equals("/diary_modify_form.dir")) {
			System.out.println("[OneDiaryController] /diary_modify_form.dir");
			
			oneDiaryService = new OneDiaryService();
			oneDiaryService.diaryModifyForm(request, response);
			
			nextPage = "views/diary/diary_modify_form.jsp";
			
		} else if (command.equals("/diary_modify_confirm.dir")) {
			System.out.println("[OneDiaryController] /diary_modify_confirm.dir");
			
			oneDiaryService = new OneDiaryService();
			oneDiaryService.diaryModifyConfirm(request, response);
			
			nextPage = "/diary_list.dir";
			
		} else if (command.equals("/diary_delete_confirm.dir")) {
			System.out.println("[OneDiaryController] /diary_delete_confirm.dir");
			
			oneDiaryService = new OneDiaryService();
			oneDiaryService.diaryDeleteConfirm(request, response);
			
			nextPage = "/diary_list.dir";
			
		} else if (command.equals("/diary_search_form.dir")) {
			System.out.println("[OneDiaryController] /diary_search_form.dir");
			
			nextPage = "views/diary/diary_search_form.jsp";
		} else if (command.equals("/diary_search_confirm.dir")) {
			System.out.println("[OneDiaryController] /diary_search_confirm.dir");
			
			oneDiaryService = new OneDiaryService();
			oneDiaryService.diarySearchConfirm(request, response);
			
			nextPage = "views/diary/diary_list.jsp";
			
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(nextPage);
		dispatcher.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

}

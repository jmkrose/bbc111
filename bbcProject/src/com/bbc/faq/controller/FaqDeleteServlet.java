package com.bbc.faq.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bbc.faq.model.service.FaqService;

/**
 * Servlet implementation class FaqDeleteServlet
 */
@WebServlet("/delete.t.fa")
public class FaqDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FaqDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int faqNo = Integer.parseInt(request.getParameter("delete-faqNo"));
		
		System.out.println(faqNo);
		
		int result = new FaqService().deleteFaq(faqNo);
		
		if(result > 0) {
			// alert창 인코딩 처리해주는 부분
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			// alert바로 띄우는 기능 설정해주는 부분
			out.println("<script>alert('FAQ 삭제가 완료되었습니다.'); location.href='list.t.fa';</script>");
		}else {
			request.setAttribute("msg", "FAQ 게시글 삭제 실패");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
		}
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

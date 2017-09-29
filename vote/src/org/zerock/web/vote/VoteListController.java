package org.zerock.web.vote;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.zerock.web.AbstractController;
import org.zerock.web.PageMaker;
import org.zerock.web.vote.dao.VoteDAO;

/**
 * Servlet implementation class VoteListController
 */
@WebServlet("/vote/index")
public class VoteListController extends AbstractController {
	private static final long serialVersionUID = 1L;
	
	private VoteDAO dao = new VoteDAO();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//System.out.println("list...................."+ dao.getListAll());
		//request.setAttribute("list", dao.getListAll());
		
		int page = 0; 
		
		try {
			page = Integer.parseInt(request.getParameter("page"));
		}catch(Exception e) {
			page = 1;
		}
		
		
		request.setAttribute("list", dao.getList(page));
		PageMaker pg = new PageMaker(dao.getTotal(), page);
		
		System.out.println(pg);
		
		request.setAttribute("pg", pg);
		
		
		dispatcher(request, response, "vote/list");
	}

}



package org.zerock.web.vote;

import java.io.IOException;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.zerock.web.AbstractController;
import org.zerock.web.vote.dao.VoteDAO;
import org.zerock.web.vote.vo.VoteVO;

/**
 * Servlet implementation class VoteRegisterController
 */
@WebServlet("/vote/register")
public class VoteRegisterController extends AbstractController implements Servlet {
	private static final long serialVersionUID = 1L;

	private VoteDAO dao = new VoteDAO();
    /**
     * Default constructor. 
     */
    public VoteRegisterController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		dispatcher(request, response, "/vote/register");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("UTF-8");
		
		VoteVO vo = new VoteVO();
		
		vo.setTitle(request.getParameter("title"));
		vo.setDescp(request.getParameter("descp"));
		vo.setWriter(request.getParameter("writer")== null? "teacher":request.getParameter("writer"));
		
		
		System.out.println("VO: " + vo);
		
		dao.register(vo);
		
		
		dispatcher(request, response, "/vote/registerResult");
	}

}

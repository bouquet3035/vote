package org.zerock.web;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.zerock.web.member.dao.MemberDAO;
import org.zerock.web.member.vo.MemberVO;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends AbstractController implements Servlet {
	private static final long serialVersionUID = 1L;

	private MemberDAO dao = new MemberDAO();
    /**
     * Default constructor. 
     */
    public LoginController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		dispatcher(request, response, "login");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		MemberVO vo = dao.findByIdAndPw(id, pw);
		
		if(vo.getMid() == null) {
			response.sendRedirect("/login?msg=re");
			return;
		}
		
		request.getSession().setAttribute("member", vo);
		
		response.sendRedirect("/vote/index");
		
		
	}

}

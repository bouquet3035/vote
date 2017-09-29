package org.zerock.web.vote;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.zerock.web.AbstractController;
import org.zerock.web.member.vo.MemberVO;
import org.zerock.web.vote.dao.VoteDAO;
import org.zerock.web.vote.vo.VoteResultVO;

/**
 * Servlet implementation class VoteViewController
 */
@WebServlet("/vote/view")
public class VoteViewController extends AbstractController {
	private static final long serialVersionUID = 1L;
       
	
	private VoteDAO dao = new VoteDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VoteViewController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int vno = -1;
		
		try {
			
			vno = Integer.parseInt(request.getParameter("vno"));
			
		}catch(Exception e) {
			
		}
		
		if(vno == -1) {
			throw new ServletException("NOT FOUND VOTE");
		}
		
		request.setAttribute("vo", dao.get(vno));
				
		dispatcher(request, response, "vote/view");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		VoteResultVO result = new VoteResultVO(
				request.getParameter("vno"),
				((MemberVO)(request.getSession().getAttribute("member"))).getMid(),
				request.getParameter("understand")
				);
		
		dao.create(result);
		
		
		
	}

}

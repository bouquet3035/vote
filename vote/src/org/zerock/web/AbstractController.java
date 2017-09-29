package org.zerock.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AbstractController extends HttpServlet {
	
	private static final String PRE ="/WEB-INF/";
	private static final String APP = ".jsp";

	public void dispatcher(HttpServletRequest req, HttpServletResponse res, String path) throws ServletException, IOException {
		
		if(path == null) {
			
		}
		
		req.getRequestDispatcher(PRE + path +APP).forward(req, res);
		
	}
}

package com.alchemy.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alchemy.api.BlogNotFoundException;
import com.alchemy.api.BloggerException;
import com.alchemy.api.IBlogger;
import com.alchemy.biz.Alchemy;
import com.alchemy.biz.Blog;

/**
 * Servlet implementation class EchoTest
 */
public class EchoTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EchoTest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int isbn = 0;
		
		if (request.getParameterMap().containsKey("isbn")) {
			isbn = Integer.parseInt(request.getParameter("isbn"));
		}
		
		IBlogger library = new Alchemy();
		System.out.println("skm : test am I getting logs ??");
		try {
			Blog book = library.find(isbn);
			response.getWriter().println(book.toString());
		} catch (BlogNotFoundException bnfe) {
			response.getWriter().append("BookNotFound invalid isbn ? ").println(isbn);
		} catch (BloggerException le) {
			response.getWriter().append("LibraryException ").println(le.getMessage());
		}
		
		response.setHeader("status", "200");
		// response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

package edu.etu.web;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class PriceProcessor
 */
@WebServlet("/PriceProcessor")
public class PriceProcessor extends HttpServlet {	
	protected void processRequest(HttpServletRequest request, HttpServletResponse
			response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		
		//��������� ����������
		String client = request.getParameter("client");
		String color = request.getParameter("color");
		
		if(client == null) {
			// ��������� �� ������, ���� ������� ������ ��� ���������
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, "�� ������ ��� ����������");
			return;
		}
		
		//���������� ���������� � ������
		request.getSession().setAttribute("client", client);
		
		//���������� ���������� � Cookie
		Cookie c = new Cookie("client", client);
		response.addCookie(c);
		
		//���������� ����� � Cookie
		c = new Cookie("color", color);
		response.addCookie(c);
		
		HttpSession session = request.getSession(true);
		if(session == null) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, "��� ������� HttpSession");
			return;
		};
		
		if(session.getAttribute("counter") == null) {
			session.setAttribute("counter", 0);
		}
		else {
			session.setAttribute("counter", (int)session.getAttribute("counter") + 1);
		}
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();		
		session.setAttribute("data", dateFormat.format(date));
		
		// ��������������� �� �������� �������
		response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/ListData.jsp"));
	}
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PriceProcessor() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

}

package com.harshalwork.pmposhan;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class GovLogin
 */
@WebServlet("/GovLogin")
public class GovLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GovLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		String email = request.getParameter("email");
		String pwd = request.getParameter("pwd");
		
		try
		{
			Connection con = ConnectionDB.connect();
			PreparedStatement psm = con.prepareStatement("select * from gov_db where email=? and pwd=?");
			psm.setString(1, email);
			psm.setString(2, pwd);
		    ResultSet rs =	psm.executeQuery();
           
		    if(rs.next())
		    {    
		    	response.sendRedirect("dashboard.html");
		    }
		    else
		    {
		    	response.sendRedirect("index.html");
		    }

			
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}

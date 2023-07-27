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
 * Servlet implementation class SchoolLogin
 */
@WebServlet("/SchoolLogin")
public class SchoolLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SchoolLogin() {
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
		String semail = request.getParameter("semail");
		String pwd = request.getParameter("pwd");
		try
		{    
			GetterSetter.setSemail(semail);
			Connection con = ConnectionDB.connect();
			PreparedStatement psm = con.prepareStatement("select * from school_info where semail=? and pwd=?");
			psm.setString(1, semail);
			psm.setString(2, pwd);
			
		    ResultSet rs =	psm.executeQuery();
           
		    if(rs.next())
		    {   
		    	
		    	response.sendRedirect("dashboardSchool.html");
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

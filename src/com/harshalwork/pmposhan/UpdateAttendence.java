package com.harshalwork.pmposhan;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateAttendence
 */
@WebServlet("/UpdateAttendence")
public class UpdateAttendence extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateAttendence() {
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
		
		int id = Integer.parseInt(request.getParameter("id"));

		int day = Integer.parseInt( request.getParameter("day"));
		int month =Integer.parseInt(request.getParameter("month")); 

		

		
		
		try
		{  
			
			Connection con = ConnectionDB.connect();
			PreparedStatement ps = con.prepareStatement("update student_info1 set day=? , month=? where id=?");
	
            ps.setInt(1, day);
			ps.setInt(2, month);
			ps.setInt(3, id);




		    int i =	ps.executeUpdate();
		    if(i==1)
		    {
		    	response.sendRedirect("viewAttendence.jsp");
		    }
		    else
		    {
		    	response.sendRedirect("addStudent.html");
		    }




			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
		
	}



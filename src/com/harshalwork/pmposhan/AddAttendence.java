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
 * Servlet implementation class AddAttendence
 */
@WebServlet("/AddAttendence")
public class AddAttendence extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddAttendence() {
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
		

		String present = request.getParameter("present");
		String absent = request.getParameter("absent");
		String newdate = request.getParameter("newdate");


     
		
		 
		try
		{    
			
			   		
			Connection con = ConnectionDB.connect();
			PreparedStatement ps = con.prepareStatement("insert into attendence_info  values(?,?,?,?,?)");
			ps.setInt(1,0);
			ps.setString(2,GetterSetter.getRno());

			ps.setString(3,present);
            ps.setString(4,absent);
			ps.setString(5,newdate);
   


		    int i =	ps.executeUpdate();
		    if(i==1)
		    {
		    	response.sendRedirect("viewAttendence.jsp");
		    }
		    else
		    {
		    	response.sendRedirect("addMeal.html");
		    }




			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	}



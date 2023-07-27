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
 * Servlet implementation class AddComplaint
 */
@WebServlet("/AddComplaint")
public class AddComplaint extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddComplaint() {
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
		String sid = request.getParameter("sid");
		String sname = request.getParameter("sname");
		String complaint = request.getParameter("complaint");
		String date = request.getParameter("date");
		
		
		
		
		try
		{   
			
			Connection con = ConnectionDB.connect();
			PreparedStatement ps = con.prepareStatement("insert into complaint_info values(?,?,?,?,?,?)");
			ps.setInt(1, 0);
			ps.setString(2, sid);
            ps.setString(3, sname);
			ps.setString(4, complaint);
			ps.setString(5, date);
			ps.setString(6, GetterSetter.getSemail());

		



		    int i =	ps.executeUpdate();
		    if(i==1)
		    {
		    	response.sendRedirect("ViewComplaint.jsp");
		    }
		    else
		    {
		    	response.sendRedirect("addComplaint.html");
		    }




			
		}catch(Exception e)
		{
			e.printStackTrace();
		}

	}

}

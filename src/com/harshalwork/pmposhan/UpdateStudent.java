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
 * Servlet implementation class UpdateStudent
 */
@WebServlet("/UpdateStudent")
public class UpdateStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateStudent() {
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
		
		String rno = request.getParameter("rno");
		String name = request.getParameter("name");
		String sclass = request.getParameter("class");
		String height = request.getParameter("height");
		String weight = request.getParameter("weight");
		String date = request.getParameter("date");

		
		
		
		try
		{  
			
			
			Connection con = ConnectionDB.connect();
			PreparedStatement ps = con.prepareStatement("insert into update_info values(?,?,?,?,?,?,?,?)");
			ps.setInt(1, 0);
			ps.setString(2, rno);
            ps.setString(3, name);
			ps.setString(4, sclass);
            ps.setString(5, height);
			ps.setString(6, weight);
			ps.setString(7, date);
			ps.setString(8, GetterSetter.getSemail());




		    int i =	ps.executeUpdate();
		    if(i==1)
		    {
		    	response.sendRedirect("viewUpdate.jsp");
		    }
		    else
		    {
		    	response.sendRedirect("updateStudent.html");
		    }




			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}

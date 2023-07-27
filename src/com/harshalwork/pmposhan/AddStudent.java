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
 * Servlet implementation class AddStudent
 */
@WebServlet("/AddStudent")
public class AddStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddStudent() {
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
		String age = request.getParameter("age");
		String gender = request.getParameter("gender");
		String sclass = request.getParameter("class");
		String height = request.getParameter("height");
		String weight = request.getParameter("weight");
		String date = request.getParameter("date");

		int day =0;
		int month =0;
		String status ="present";


		
		
		try
		{  
			GetterSetter.setRno(rno);
			
			Connection con = ConnectionDB.connect();
			PreparedStatement ps = con.prepareStatement("insert into student_info1 values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setInt(1, 0);
			ps.setString(2, rno);
            ps.setString(3, name);
			ps.setString(4, age);
			ps.setString(5, gender);
			ps.setString(6, sclass);
            ps.setString(7, height);
			ps.setString(8, weight);
			ps.setString(9, date);
			ps.setString(10, GetterSetter.getSemail());
			ps.setInt(11, day);
			ps.setInt(12, month);
			ps.setString(13, status);






		    int i =	ps.executeUpdate();
		    if(i==1)
		    {
		    	response.sendRedirect("viewStudent.jsp");
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

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
 * Servlet implementation class AddSchool
 */
@WebServlet("/AddSchool")
public class AddSchool extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddSchool() {
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
		String sadd = request.getParameter("sadd");
		String scity = request.getParameter("scity");
		String sstate = request.getParameter("sstate");
		String spin = request.getParameter("spin");
		String smob = request.getParameter("smob");
		String semail = request.getParameter("semail");
		String pwd = request.getParameter("pwd");

		
		
		
		try
		{   
			Connection con = ConnectionDB.connect();
			PreparedStatement ps = con.prepareStatement("insert into school_info values(?,?,?,?,?,?,?,?,?,?)");
			ps.setInt(1, 0);
			ps.setString(2, sid);
            ps.setString(3, sname);
			ps.setString(4, sadd);
			ps.setString(5, scity);
			ps.setString(6, sstate);
            ps.setString(7, spin);
			ps.setString(8, smob);
			ps.setString(9, semail);
			ps.setString(10, pwd);



		    int i =	ps.executeUpdate();
		    if(i==1)
		    {
		    	response.sendRedirect("viewSchool.jsp");
		    }
		    else
		    {
		    	response.sendRedirect("addSchool.html");
		    }




			
		}catch(Exception e)
		{
			e.printStackTrace();
		}

	}

}

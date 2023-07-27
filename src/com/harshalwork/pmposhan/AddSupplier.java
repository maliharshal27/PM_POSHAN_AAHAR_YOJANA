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
 * Servlet implementation class AddSupplier
 */
@WebServlet("/AddSupplier")
public class AddSupplier extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddSupplier() {
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
		String sshop = request.getParameter("sshop");
		String smob = request.getParameter("smob");
		String semail = request.getParameter("semail");
		String pwd = request.getParameter("pwd");

		
		
		
		try
		{   
			Connection con = ConnectionDB.connect();
			PreparedStatement ps = con.prepareStatement("insert into supplier_info values(?,?,?,?,?,?,?,?)");
			ps.setInt(1, 0);
			ps.setString(2, sid);
            ps.setString(3, sname);
            ps.setString(4, sshop);
			ps.setString(5, semail);
			ps.setString(6, smob);
			ps.setString(7, sadd);
			ps.setString(8, pwd);




		    int i =	ps.executeUpdate();
		    if(i==1)
		    {
		    	response.sendRedirect("viewSupplier.jsp");
		    }
		    else
		    {
		    	response.sendRedirect("addSupplier.html");
		    }




			
		}catch(Exception e)
		{
			e.printStackTrace();
		}


	}

}

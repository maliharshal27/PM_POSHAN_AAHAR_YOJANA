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
 * Servlet implementation class AddMeal
 */
@WebServlet("/AddMeal")
public class AddMeal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddMeal() {
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
		

		String mt = request.getParameter("mt");
		String quantity = request.getParameter("quantity");
		String unit = request.getParameter("unit");

		
		
		
		
		try
		{   
			Connection con = ConnectionDB.connect();
			PreparedStatement ps = con.prepareStatement("insert into meal_info values(?,?,?,?)");
			ps.setInt(1, 0);
			ps.setString(2, mt);
            ps.setString(3, quantity);
			ps.setString(4,unit);
		


		    int i =	ps.executeUpdate();
		    if(i==1)
		    {
		    	response.sendRedirect("viewMeal.jsp");
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

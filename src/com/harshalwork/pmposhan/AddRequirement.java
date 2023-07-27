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
 * Servlet implementation class AddRequirement
 */
@WebServlet("/AddRequirement")
public class AddRequirement extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddRequirement() {
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
		

		String name = request.getParameter("name");
		String quantity = request.getParameter("quantity");
		String unit = request.getParameter("unit");
		String date = request.getParameter("date");
        
		String delivarystatus ="pending";
        String  status ="pending";
        String Rice ="Rice";
        String Wheat = "Wheat";
        String Oil = "Oil";
        String Biscuit = "Biscuit"; 
        String Eggs = "Eggs"; 
        
         if(name.equals(Wheat))
         {
        	 int q = (Integer.parseInt(quantity)*30);
 	    	
	  			try
				{   
					Connection con = ConnectionDB.connect();
					PreparedStatement ps = con.prepareStatement("insert into requirement_info values(?,?,?,?,?,?,?,?)");
					ps.setInt(1, 0);
					ps.setString(2, name);
		            ps.setInt(3, q);
					ps.setString(4,unit);
					ps.setString(5,delivarystatus);
					ps.setString(6,status);
					ps.setString(7,GetterSetter.getSemail());
					ps.setString(8,date);
		
		            int i =	ps.executeUpdate();
				    if(i==1)
				    {
				    	response.sendRedirect("viewRequirement.jsp");
				    }
				    else
				    {
				    	response.sendRedirect("addRequirement.html");
				    }
		
		
		
		
					
				}catch(Exception e)
				{
					e.printStackTrace();
				}
         }else if(name.equals(Oil))
         {
        	 int s = (Integer.parseInt(quantity)*1);
 	    	
   			try
 			{   
 				Connection con = ConnectionDB.connect();
 				PreparedStatement ps = con.prepareStatement("insert into requirement_info values(?,?,?,?,?,?,?,?)");
 				ps.setInt(1, 0);
 				ps.setString(2, name);
 	            ps.setInt(3, s);
 				ps.setString(4,unit);
 				ps.setString(5,delivarystatus);
 				ps.setString(6,status);
 				ps.setString(7,GetterSetter.getSemail());
 				ps.setString(8,date);
 	
 	            int i =	ps.executeUpdate();
 			    if(i==1)
 			    {
 			    	response.sendRedirect("viewRequirement.jsp");
 			    }
 			    else
 			    {
 			    	response.sendRedirect("addRequirement.html");
 			    }
 	
 	
 	
 	
 				
 			}catch(Exception e)
 			{
 				e.printStackTrace();
 			}
         }else if(name.equals(Eggs))
         {
        	 int p = (Integer.parseInt(quantity)*30);
		    	
	  			try
				{   
					Connection con = ConnectionDB.connect();
					PreparedStatement ps = con.prepareStatement("insert into requirement_info values(?,?,?,?,?,?,?,?)");
					ps.setInt(1, 0);
					ps.setString(2, name);
		            ps.setInt(3, p);
					ps.setString(4,unit);
					ps.setString(5,delivarystatus);
					ps.setString(6,status);
					ps.setString(7,GetterSetter.getSemail());
					ps.setString(8,date);
		
		            int i =	ps.executeUpdate();
				    if(i==1)
				    {
				    	response.sendRedirect("viewRequirement.jsp");
				    }
				    else
				    {
				    	response.sendRedirect("addRequirement.html");
				    }
		
		
		
		
					
				}catch(Exception e)
				{
					e.printStackTrace();
				}
         }else if(name.equals(Rice))
         {
        	 int r = (Integer.parseInt(quantity)*20);
		    	
	  			try
				{   
					Connection con = ConnectionDB.connect();
					PreparedStatement ps = con.prepareStatement("insert into requirement_info values(?,?,?,?,?,?,?,?)");
					ps.setInt(1, 0);
					ps.setString(2, name);
		            ps.setInt(3, r);
					ps.setString(4,unit);
					ps.setString(5,delivarystatus);
					ps.setString(6,status);
					ps.setString(7,GetterSetter.getSemail());
					ps.setString(8,date);
		
		            int i =	ps.executeUpdate();
				    if(i==1)
				    {
				    	response.sendRedirect("viewRequirement.jsp");
				    }
				    else
				    {
				    	response.sendRedirect("addRequirement.html");
				    }
		
		
		
		
					
				}catch(Exception e)
				{
					e.printStackTrace();
				}
         }else if(name.equals(Biscuit))
         {
        	 int r = (Integer.parseInt(quantity)*6);
		    	
	  			try
				{   
					Connection con = ConnectionDB.connect();
					PreparedStatement ps = con.prepareStatement("insert into requirement_info values(?,?,?,?,?,?,?,?)");
					ps.setInt(1, 0);
					ps.setString(2, name);
		            ps.setInt(3, r);
					ps.setString(4,unit);
					ps.setString(5,delivarystatus);
					ps.setString(6,status);
					ps.setString(7,GetterSetter.getSemail());
					ps.setString(8,date);
		
		            int i =	ps.executeUpdate();
				    if(i==1)
				    {
				    	response.sendRedirect("viewRequirement.jsp");
				    }
				    else
				    {
				    	response.sendRedirect("addRequirement.html");
				    }
		
		
		
		
					
				}catch(Exception e)
				{
					e.printStackTrace();
				}
        	 
         }else{
        	 int r = (Integer.parseInt(quantity)*2);
		    	
	  			try
				{   
					Connection con = ConnectionDB.connect();
					PreparedStatement ps = con.prepareStatement("insert into requirement_info values(?,?,?,?,?,?,?,?)");
					ps.setInt(1, 0);
					ps.setString(2, name);
		            ps.setInt(3, r);
					ps.setString(4,unit);
					ps.setString(5,delivarystatus);
					ps.setString(6,status);
					ps.setString(7,GetterSetter.getSemail());
					ps.setString(8,date);
		
		            int i =	ps.executeUpdate();
				    if(i==1)
				    {
				    	response.sendRedirect("viewRequirement.jsp");
				    }
				    else
				    {
				    	response.sendRedirect("addRequirement.html");
				    }
		
		
		
		
					
				}catch(Exception e)
				{
					e.printStackTrace();
				}
        	 
         }
       
		
     }

}

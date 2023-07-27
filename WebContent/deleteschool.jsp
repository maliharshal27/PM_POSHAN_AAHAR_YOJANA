<%@ page import="com.harshalwork.pmposhan.*" %>
<%@ page import="java.sql.*" %>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

 <%
 
      try{  
    	   Connection con=ConnectionDB.connect();
    	  String id=request.getParameter("id");
    	  PreparedStatement ps1= con.prepareStatement("delete from school_info where id=?");
    	  ps1.setString(1, id);
    	  int i = ps1.executeUpdate();
    	   if(i>0)
    	   { 
    		    response.sendRedirect("viewSchool.jsp");

    	   }
    	   else
    	   {
   		    response.sendRedirect("addSchool.html");

    	   }
    	  
    	  
      }
       catch(Exception e)
      {   
    	   e.printStackTrace();
    	   
      }
 
 
 %>

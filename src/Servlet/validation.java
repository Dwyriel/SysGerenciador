package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import classes.users.*;
import DAL.*;

@WebServlet("/validation")
public class validation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public validation() {
        super();
        
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(false);  
        if(session!=null){  
        	User user =(User)session.getAttribute("user");
        	request.getSession().setAttribute(getServletName(), user);
        	request.setAttribute("User", user);
        	request.getRequestDispatcher("Content.jsp").include(request, response);
        }  
        else{  
            response.sendRedirect("Login.jsp");
        }  
		
		
	}


}

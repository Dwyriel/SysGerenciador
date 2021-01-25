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

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Login() {
		super();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = new User();
		
		user.setEmail(request.getParameter("UserEmail"));
		
		String password = (request.getParameter("UserPassword"));
		
		user = UserDAL.getUser(user, password);

		// como iremos vefiricas se o usuario existe no banco de dados, toda a logica
		// abaixo é apenas uma demonstração simplificada do que devera acontecer.
		
//		if (user.getEmail().equals(UserDAL.user.getEmail())) {
//			if (password.equals(UserDAL.password)) {
				
		if(user != null){ 
			
				HttpSession session=request.getSession();  
		        session.setAttribute("user",user);  
				System.out.println(user);
				request.getRequestDispatcher("/validation").include(request, response); 
			
//			}
		} else {// send a response with info telling the user something was wrong
			response.sendRedirect(request.getContextPath() + "/Login.jsp");
		}
	}
}

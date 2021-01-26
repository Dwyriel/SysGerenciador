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
		
		
		String password = (request.getParameter("UserPassword"));
		user = UserDAL.getUser(request.getParameter("UserEmail"));
//		user = UserDAL.userAutentication(user, password);

				
		if(user == null){ 
			
			String msg ="Email Inv�lida ou inexistente";
			request.setAttribute("Msg", msg);
			request.getRequestDispatcher("/Login.jsp").include(request, response);
			return;
			
		} 
		if (!UserDAL.userAutentication(user, password)) {
			String msg ="Senha Inv�lida";
			request.setAttribute("Msg", msg);
			request.getRequestDispatcher("/Login.jsp").include(request, response);
			
			return;
		} 
		HttpSession session=request.getSession();  
        session.setAttribute("user",user); 
		System.out.println(user);
		request.getRequestDispatcher("/validation").include(request, response); 
	}
}

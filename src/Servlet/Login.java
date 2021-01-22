package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
		User user = new User(request.getParameter("UserName"));
		String password = (request.getParameter("UserPassword"));

		// como iremos vefiricas se o usuario existe no banco de dados, toda a logica
		// abaixo é apenas uma demonstração simplificada do que devera acontecer.
		if (user.getName().equals(TestDAL.user.getName())) {
			if (password.equals(TestDAL.password)) {
				System.out.println("Logged in");
				response.sendRedirect(request.getContextPath() + "/Content.jsp");
			}
		} else {// send a response with info telling the user something was wrong
			response.sendRedirect(request.getContextPath() + "/Login.jsp");
		}
	}
}

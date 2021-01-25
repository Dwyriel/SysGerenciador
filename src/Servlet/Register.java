package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import classes.users.*;
import DAL.*;

@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Register() {
		super();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = new User(
				request.getParameter("txtName"),
				request.getParameter("txtEmail"),
				UserType.valueOfNumber(Integer.parseInt(request.getParameter("UserType"))));
		String password = (request.getParameter("txtPassword"));
		UserDAL.user = user;
		UserDAL.password = password;
		System.out.println(UserDAL.user);

		user = UserDAL.insertUser(user, password);
		
		response.sendRedirect(request.getContextPath() + "/Login.jsp");
	}
}

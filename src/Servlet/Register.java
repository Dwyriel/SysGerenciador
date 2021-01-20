package Servlet;

import java.io.Console;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classes.users.User;
import classes.users.UserType;

@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public Register() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			User u = new User();
			//UserType UT = new UserType();
			//UserDAL cDal = new UserDAL();
		
			u.setEmail(request.getParameter("txtEmail"));
			u.setName(request.getParameter("txtName"));
			String password=(request.getParameter("txtPassword"));
			u.setType(UserType.valueOfNumber(Integer.parseInt(request.getParameter("UserType"))));
			
			//u.setAtivo(true);
			System.out.println(u.getName());

			//u = cDal.insert(u);
			
			
			response.sendRedirect(request.getContextPath() + "/Login.jsp");
			
		}

}

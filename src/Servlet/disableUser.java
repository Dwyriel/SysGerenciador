package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classes.users.*;
import DAL.*;

@WebServlet("/disableUser")
public class disableUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public disableUser() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User disableUser = new User();
		
		disableUser = UserDAL.getUser(Integer.parseInt(request.getParameter("id")));
		
		if (disableUser.isActive() == true) {
		User Userdisable = new User(
				disableUser.getName(),
				disableUser.getEmail(),
				disableUser.getId(),
				disableUser.getType(), false);
		
		UserDAL.updateUser(Userdisable);

		String alert="Conta desativada";
		
		request.setAttribute("Alert", alert);
		
		request.getRequestDispatcher("/ListAllUsers.jsp").include(request, response);
		return;
		}
		if (disableUser.isActive() == false) {
			User Userdisable = new User(
					disableUser.getName(),
					disableUser.getEmail(),
					disableUser.getId(),
					disableUser.getType(), true);
			
			UserDAL.updateUser(Userdisable);

			String alert="Conta reativada";
			
			request.setAttribute("Alert", alert);
			
			request.getRequestDispatcher("/ListAllUsers.jsp").include(request, response);
			return;
			}
		
		
	}

}

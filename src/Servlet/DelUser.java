package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAL.UserDAL;
import classes.users.User;



@WebServlet("/deltestuser")
public class DelUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public DelUser() {
        super();
     
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session = request.getSession();
		User loggedUser = (User) session.getAttribute("user");
		
		int id = loggedUser.getId();
		
		
		UserDAL.deleteUser(id);
		
		String alert="Conta deletada";
		
		request.setAttribute("Alert", alert);
		
		request.getRequestDispatcher("/Login.jsp").include(request, response);
		
		return;
		
		
	}

}

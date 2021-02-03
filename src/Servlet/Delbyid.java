package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAL.UserDAL;


@WebServlet("/Delbyid")
public class Delbyid extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Delbyid() {
        super();
    }

	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean userDel;
		userDel = UserDAL.deleteUser(Integer.parseInt(request.getParameter("id")));
	
		String alert="Conta deletada";
	
		request.setAttribute("Alert", alert);
		
		request.getRequestDispatcher("/ListAllUsers.jsp").include(request, response);
		return;
		
	}

	

}

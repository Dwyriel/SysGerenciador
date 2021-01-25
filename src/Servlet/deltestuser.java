package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAL.UserDAL;



@WebServlet("/deltestuser")
public class deltestuser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public deltestuser() {
        super();
     
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		String par = request.getParameter("iduser").toString();
		int numero = Integer.parseInt(par);
		
		
		UserDAL.deleteUser(numero);
		
		
		response.sendRedirect(request.getContextPath() + "/index.jsp");
		
		
	}

}

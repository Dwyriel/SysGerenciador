package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import classes.Institution;
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
		

		boolean validation;
		String Email = request.getParameter("txtEmail");
		validation = UserDAL.emailAutentication(Email);	
		
		if(validation == true){ 
			String msg ="Email em Uso";
			request.setAttribute("Msg", msg);
			request.getRequestDispatcher("/Register.jsp").include(request, response);
			return;
		}
			User user = new User(
					request.getParameter("txtName"),
					request.getParameter("txtEmail"),
					UserType.valueOfNumber(Integer.parseInt(request.getParameter("UserType"))));
			
			String password = (request.getParameter("txtPassword"));
	
			System.out.println(user);
			
			user = UserDAL.insertUser(user, password);
		
			if (user.getType() == UserType.InstitutionAdmin) {
				
			HttpSession session = request.getSession();
			
			User loggedUser = (User) session.getAttribute("user");
	
		
			if (loggedUser.getType() == UserType.InstitutionAdmin) {
				
				user = UserDAL.getUser(user.getEmail());
				
			InstitutionAdmin CurrentAdmin = new InstitutionAdmin();
			
			CurrentAdmin = AdminDAL.getAdmin(loggedUser.getId());
			
			InstitutionAdmin NewAdmin = new InstitutionAdmin();
			
			NewAdmin.setId(user.getId());
			
			NewAdmin.setInstitution(CurrentAdmin.getInstitution());
			AdminDAL.insertAdmin(NewAdmin);
			}
			}
			

			String alert="Usuário cadastrado com sucesso";
			
			request.setAttribute("Alert", alert);
			
			request.getRequestDispatcher("/Register.jsp").include(request, response);
			
			return;
	
	}	
}

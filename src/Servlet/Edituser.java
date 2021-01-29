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
import classes.users.UserType;

@WebServlet("/Edituser")
public class Edituser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Edituser() {
        super();
        
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User loggedUser = (User) session.getAttribute("user");
		
		//boolean validation;
		String Email = request.getParameter("txtEmail");
		String Name = request.getParameter("txtName");
		String passwordOne = request.getParameter("txtPasswordOne");
		String passwordTwo = request.getParameter("txtPasswordTwo");
//		validation = UserDAL.emailAutentication(Email);	
//		
//		if(validation == true){ 
//			String msg ="Não é possível alterar o E-mail para o mesmo utilizado";
//			request.setAttribute("Msg", msg);
//			request.getRequestDispatcher("/Edituser.jsp").include(request, response);
//			return;
//		}
		if(passwordOne != passwordTwo) {
			String msgPassword ="Senhas não conferem";
			request.setAttribute("MsgPassword", msgPassword);
			request.getRequestDispatcher("/Edituser.jsp").include(request, response);
			return;
		}
		User userUpdate = new User();
		userUpdate.setId(loggedUser.getId());
		userUpdate.setEmail(Email);
		userUpdate.setName(Name);
		userUpdate.setType(loggedUser.getType());
		UserDAL.updateUser(userUpdate, passwordOne);
		
		session.invalidate();
		
		String alert="Dados de Usuário alterados com sucesso, efetue Login novamente";
		
		request.setAttribute("Alert", alert);
		
		request.getRequestDispatcher("/Login.jsp").include(request, response);
		
		return;
		
	}


}

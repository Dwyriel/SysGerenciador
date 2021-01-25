package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import classes.users.*;
import classes.*;
import DAL.*;

@WebServlet("/RegInstitution")
public class RegInstitution extends HttpServlet{
	private static final long serialVersionUID = 1L;

	public RegInstitution() {
		super();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Institution institution = new Institution(request.getParameter("InstitutionName"));
		String userEmail = request.getParameter("Admin");
		institution = InstitutionDAL.insertInstitution(institution);
		User user = UserDAL.getUser(userEmail);
		InstitutionAdmin admin = null;
		if (user != null)
			admin = new InstitutionAdmin(user);
		if (admin != null) {
			admin.setType(UserType.InstitutionAdmin);
			admin.setInstitution(institution);
			if (UserDAL.deleteUserRelations(admin.getId()))
				if (UserDAL.updateUser(admin))
					admin = AdminDAL.insertAdmin(admin);
		}

		response.sendRedirect(request.getContextPath() + "/Institution.jsp");
	}
}

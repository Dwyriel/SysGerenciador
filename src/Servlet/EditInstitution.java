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

@WebServlet("/EditInstitution")
public class EditInstitution extends HttpServlet{
	private static final long serialVersionUID = 1L;

	public EditInstitution() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Institution institution = InstitutionDAL.getInstitution(Integer.parseInt(request.getParameter("InstitutionId")));
		institution.setName(request.getParameter("InstitutionName"));

		if(InstitutionDAL.updateInstitution(institution)) {
			response.sendRedirect(request.getContextPath() + "/InstituPage?id="+institution.getId());
			return;
		}
		request.setAttribute("errorMsg", "Não foi possivel atualizar a instituição");
		request.getRequestDispatcher("EditInstitution?id="+institution.getId()).include(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Institution institution = null;
		institution = InstitutionDAL.getInstitution(Integer.parseInt(request.getParameter("id")));
		if (institution == null) {
			response.sendRedirect(request.getContextPath() + "/Login.jsp");
			return;
		}
		request.setAttribute("institution", institution);
		request.getRequestDispatcher("Edit_Institution.jsp").include(request, response);
	}
}

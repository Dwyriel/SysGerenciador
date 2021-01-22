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

@WebServlet("/InstituPage")
public class InstituPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public InstituPage() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		Institution institution = null;
		for (Institution institu : TestDAL.institutions) {
			if (institu.getId().equals(id)) {
				institution = institu;
				break;
			}
		}
		if (institution == null) {
			response.sendRedirect(request.getContextPath() + "/Institution.jsp");
			return;
		}
		request.setAttribute("Institution", institution);
		response.setContentType("text/html; charset=utf-8");
		request.getRequestDispatcher("InstitutionPage.jsp").include(request, response);
	}
}

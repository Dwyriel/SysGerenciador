
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

@WebServlet("/LessonPage")
public class LessonPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LessonPage() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Lesson lesson = null;
		lesson = LessonDAL.getLesson(id);
		if (lesson == null) {
			response.sendRedirect(request.getContextPath() + "/Login.jsp");
			return;
		}
		lesson.setStudents(LessonStudentDAL.getStudentsByLesson(lesson.getId()));
		request.setAttribute("Lesson", lesson);
		request.getRequestDispatcher("LessonPage.jsp").include(request, response);
	}
}
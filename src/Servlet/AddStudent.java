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

@WebServlet("/AddStudent")
public class AddStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddStudent() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = UserDAL.getUser(request.getParameter("student"));
		Lesson lesson = LessonDAL.getLesson(Integer.parseInt(request.getParameter("lessonId")));
		LessonStudentDAL.insertLessonStudent(user.getId(), lesson.getId());
		response.sendRedirect(request.getContextPath() + "/InstituPage?id=" + lesson.getInstitution().getId());
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Lesson lesson = LessonDAL.getLesson(Integer.parseInt(request.getParameter("id")));
		if (lesson == null) {
			response.sendRedirect(request.getContextPath() + "/Login.jsp");
			return;
		}
		request.setAttribute("lesson", lesson);
		request.getRequestDispatcher("AddStudent.jsp").include(request, response);
	}
}
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

@WebServlet("/RemoveStudent")
public class RemoveStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RemoveStudent() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = UserDAL.getUser(request.getParameter("student"));
		Lesson lesson = LessonDAL.getLesson(Integer.parseInt(request.getParameter("lessonId")));
		LessonStudentDAL.deleteLessonStudent(user.getId(), lesson.getId());
		response.sendRedirect(request.getContextPath() + "/LessonPage?id=" + lesson.getId());
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Lesson lesson = LessonDAL.getLesson(Integer.parseInt(request.getParameter("id")));
		if (lesson == null) {
			response.sendRedirect(request.getContextPath() + "/Login.jsp");
			return;
		}
		request.setAttribute("lesson", lesson);
		request.getRequestDispatcher("RemoveStudent.jsp").include(request, response);
	}
}
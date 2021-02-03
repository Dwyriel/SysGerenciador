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

@WebServlet("/EditLesson")
public class EditLesson extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EditLesson() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Lesson lesson = LessonDAL.getLesson(Integer.parseInt(request.getParameter("LessonId")));
		lesson.setName(request.getParameter("LessonName"));
		User user = null;
		if (request.getParameter("Teacher") != null) {
			user = UserDAL.getUser(request.getParameter("Teacher"));
		}
		Teacher teacher = null;
		if (user != null) {
			teacher = new Teacher(user);
		}
		if (teacher != null) {
			teacher.setType(UserType.Teacher);
			if (UserDAL.updateUser(teacher)) {
				if (lesson.getTeacher() != null || lesson.getTeacher().getId() != -1)
					TeacherLessonDAL.deleteTeacherLesson(lesson.getTeacher().getId(), lesson.getId());
				System.out.println("No errors yet " + teacher.getId() + " - " + lesson.getId());
				lesson.setTeacher(teacher);;
				if (LessonDAL.updateLesson(lesson))
					TeacherLessonDAL.insertTeacherLesson(teacher.getId(), lesson.getId());
			}
		} else {
			lesson.setTeacher(new User());
			LessonDAL.updateLesson(lesson);
		}
		response.sendRedirect(request.getContextPath() + "/InstituPage?id=" + lesson.getInstitution().getId());
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Lesson lesson = null;
		lesson = LessonDAL.getLesson(Integer.parseInt(request.getParameter("id")));
		if (lesson == null) {
			response.sendRedirect(request.getContextPath() + "/Login.jsp");
			return;
		}
		request.setAttribute("lesson", lesson);
		request.getRequestDispatcher("Edit_Lesson.jsp").include(request, response);
	}
}
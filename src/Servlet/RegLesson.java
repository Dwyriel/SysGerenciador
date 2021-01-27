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

@WebServlet("/RegLesson")
public class RegLesson extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RegLesson() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Institution institution = InstitutionDAL.getInstitution(Integer.parseInt(request.getParameter("InstitutionId")));
		User user = null;
		if (request.getParameter("Teacher") != null) {
			user = UserDAL.getUser(request.getParameter("Teacher"));
		}
		String lessonName = request.getParameter("LessonName");
		Lesson lesson = null;
		Teacher teacher = null;
		if (user != null) {
			teacher = new Teacher(user);
		}
		if (teacher != null) {
			teacher.setType(UserType.Teacher);
			if (UserDAL.deleteUserRelations(teacher.getId()))
				if (UserDAL.updateUser(teacher)) {
					lesson = new Lesson(lessonName, teacher, institution);
					lesson = LessonDAL.insertLesson(lesson);
					TeacherLessonDAL.insertTeacherLesson(teacher.getId(), lesson.getId());
				}
		} else {
			lesson = new Lesson(lessonName, institution);
			lesson = LessonDAL.insertLesson(lesson);
		}
		response.sendRedirect(request.getContextPath() + "/InstituPage?id="+institution.getId());
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Institution institution = null;
		institution = InstitutionDAL.getInstitution(Integer.parseInt(request.getParameter("id")));
		if (institution == null) {
			response.sendRedirect(request.getContextPath() + "/Institution.jsp");
			return;
		}
		request.setAttribute("institution", institution);
		request.getRequestDispatcher("RegisterLesson.jsp").include(request, response);
	}
}

package DAL;

import java.util.*;
import java.sql.*;
import classes.users.*;
import classes.*;

public class TeacherLessonDAL {

	public static boolean insertTeacherLesson(int teacher_id, int lesson_id) {
		try {
			Connection connection = Conexao.getConnection();
			PreparedStatement statement = connection.prepareStatement("INSERT INTO teacher_lessons VALUES(null,?,?)");
			statement.setInt(1, teacher_id);
			statement.setInt(2, lesson_id);
			statement.executeUpdate();
			return true;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return false;
		} finally {
			Conexao.closeConnection();
		}
	}

	public static boolean deleteTeacherLesson(int teacher_id, int lesson_id) {
		try {
			Connection connection = Conexao.getConnection();
			PreparedStatement statement = connection
					.prepareStatement("DELETE FROM teacher_lessons WHERE teacher_id = ? AND lessons_id = ?");
			statement.setInt(1, teacher_id);
			statement.setInt(2, lesson_id);
			statement.executeUpdate();
			return true;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return false;
		} finally {
			Conexao.closeConnection();
		}
	}

	public static User getTeacherByLesson(int lesson_id) {
		try {
			Connection connection = Conexao.getConnection();
			PreparedStatement statement = connection
					.prepareStatement("SELECT * FROM teacher_lessons WHERE lessons_id = ?");
			statement.setInt(1, lesson_id);
			ResultSet resultSet = statement.executeQuery();
			Teacher teacher = null;
			while (resultSet.next()) {
				teacher = new Teacher(UserDAL.getUser(resultSet.getInt("teacher_id")));
			}
			return teacher;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		} finally {
			Conexao.closeConnection();
		}
	}

	public static List<Lesson> getLessonsByTeacher(int teacher_id) {
		try {
			List<Lesson> lessonList = new ArrayList<Lesson>();
			Connection connection = Conexao.getConnection();
			PreparedStatement statement = connection
					.prepareStatement("SELECT * FROM teacher_lessons WHERE teacher_id = ?");
			statement.setInt(1, teacher_id);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Lesson lesson = LessonDAL.getLesson(resultSet.getInt("lessons_id"));
				lessonList.add(lesson);
			}
			return lessonList;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		} finally {
			Conexao.closeConnection();
		}
	}
}

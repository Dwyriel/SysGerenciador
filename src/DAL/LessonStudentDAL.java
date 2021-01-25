package DAL;

import java.util.*;
import java.sql.*;
import classes.users.*;
import classes.*;

public class LessonStudentDAL {

	public static boolean insertLessonStudent(int student_id, int lesson_id) {
		try {
			Connection connection = Conexao.getConnection();
			PreparedStatement statement = connection.prepareStatement("INSERT INTO lesson_students VALUES(null,?,?)");
			statement.setInt(1, student_id);
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

	public static boolean deleteTeacherLesson(int student_id, int lesson_id) {
		try {
			Connection connection = Conexao.getConnection();
			PreparedStatement statement = connection
					.prepareStatement("DELETE FROM lesson_students WHERE student_id = ? AND lesson_id = ?");
			statement.setInt(1, student_id);
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

	public static List<User> getStudentsByLesson(int lesson_id) {
		try {
			List<User> studentList = new ArrayList<User>();
			Connection connection = Conexao.getConnection();
			PreparedStatement statement = connection
					.prepareStatement("SELECT * FROM lesson_students WHERE lesson_id = ?");
			statement.setInt(1, lesson_id);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Student student = new Student(UserDAL.getUser(resultSet.getInt("student_id")));
				studentList.add(student);
			}
			return studentList;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		} finally {
			Conexao.closeConnection();
		}
	}

	public static List<Lesson> getLessonsByStudent(int student_id) {
		try {
			List<Lesson> lessonList = new ArrayList<Lesson>();
			Connection connection = Conexao.getConnection();
			PreparedStatement statement = connection
					.prepareStatement("SELECT * FROM lesson_students WHERE student_id = ?");
			statement.setInt(1, student_id);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Lesson lesson = LessonDAL.getLesson(resultSet.getInt("lesson_id"));
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

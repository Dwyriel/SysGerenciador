package DAL;

import java.util.*;
import java.sql.*;
import classes.users.*;
import classes.*;

public class LessonDAL {
	public static Lesson insertLesson(Lesson lesson) {
		try {
			Connection connection = Conexao.getConnection();
			PreparedStatement statement = connection.prepareStatement("INSERT INTO lessons VALUES(null,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, lesson.getName());
			statement.setInt(2, lesson.getInstitution().getId());
			statement.setInt(3, lesson.getTeacher().getId());
			statement.setBoolean(4, lesson.isActive());
			statement.executeUpdate();
			ResultSet id = statement.getGeneratedKeys();
			if (id.next())
				lesson.setId(id.getInt(1));
			return lesson;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		} finally {
			Conexao.closeConnection();
		}
	}

	public static boolean deleteLesson(int id) {
		try {
			Connection connection = Conexao.getConnection();
			Statement statement = connection.createStatement();
			String query1 = "DELETE FROM teacher_lessons WHERE lessons_id  = " + id;
			String query2 = "DELETE FROM lesson_students WHERE lesson_id = " + id;
			String query3 = "DELETE FROM lessons WHERE id = " + id;
			statement.addBatch(query1);
			statement.addBatch(query2);
			statement.addBatch(query3);
			statement.executeBatch();

			return true;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return false;
		} finally {
			Conexao.closeConnection();
		}
	}

	public static boolean updateLesson(Lesson lesson) {
		try {
			Connection connection = Conexao.getConnection();
			PreparedStatement statement = connection.prepareStatement(
					"UPDATE lessons SET name = ?, institution_id = ? , teacher_id = ?, active = ? WHERE id = ?");
			statement.setString(1, lesson.getName());
			statement.setInt(2, lesson.getInstitution().getId());
			statement.setInt(3, lesson.getTeacher().getId());
			statement.setBoolean(4, lesson.isActive());
			statement.setInt(5, lesson.getId());
			statement.executeUpdate();
			return true;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return false;
		} finally {
			Conexao.closeConnection();
		}
	}

	public static boolean updateLesson(int id, boolean active) {
		try {
			Connection connection = Conexao.getConnection();
			PreparedStatement statement = connection.prepareStatement("UPDATE lessons SET active = ? WHERE id = ?");
			statement.setBoolean(1, active);
			statement.setInt(2, id);
			statement.executeUpdate();
			return true;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return false;
		} finally {
			Conexao.closeConnection();
		}
	}

	public static Lesson getLesson(int id) {
		try {
			Connection connection = Conexao.getConnection();
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM lessons WHERE id = ?");
			statement.setInt(1, id);
			ResultSet resultSet = statement.executeQuery();
			Lesson lesson = null;
			if (resultSet.next()) {
				lesson = new Lesson(resultSet.getInt("id"), resultSet.getString("name"),
						UserDAL.getUser(resultSet.getInt("teacher_id")),
						InstitutionDAL.getInstitution(resultSet.getInt("institution_id")),
						resultSet.getBoolean("active"));
			}
			return lesson;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		} finally {
			Conexao.closeConnection();
		}
	}

	public static List<Lesson> getLessonByInstitution(int intitution_id) {
		try {
			List<Lesson> lessonList = new ArrayList<Lesson>();
			Connection connection = Conexao.getConnection();
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM lessons WHERE institution_id = ?");
			statement.setInt(1, intitution_id);
			ResultSet resultSet = statement.executeQuery();
			Lesson lesson = null;
			while (resultSet.next()) {
				lesson = new Lesson(resultSet.getInt("id"), resultSet.getString("name"),
						UserDAL.getUser(resultSet.getInt("teacher_id")),
						InstitutionDAL.getInstitution(resultSet.getInt("institution_id")),
						resultSet.getBoolean("active"));
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

	public static List<Lesson> getAllLessons() {
		try {
			List<Lesson> lessonList = new ArrayList<Lesson>();
			Connection connection = Conexao.getConnection();

			PreparedStatement statement = connection.prepareStatement("SELECT * FROM lessons");

			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				Lesson lesson = new Lesson(resultSet.getInt("id"), resultSet.getString("name"),
						UserDAL.getUser(resultSet.getInt("teacher_id")),
						InstitutionDAL.getInstitution(resultSet.getInt("institution_id")),
						resultSet.getBoolean("active"));
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

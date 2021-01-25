package DAL;

import java.util.*;
import java.sql.*;
import classes.users.*;
import classes.*;

public class LessonDAL {
	public static Lesson insertLesson(Lesson lesson) {
		try {
			Connection connection = Conexao.getConnection();
			PreparedStatement statement = connection.prepareStatement("INSERT INTO lessons VALUES(null,?,?,?,?)");
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
	
	public static boolean updateLesson(Lesson lesson) {
		try {
			Connection connection = Conexao.getConnection();
			PreparedStatement statement = connection.prepareStatement("UPDATE lessons SET name = ?, institution_id = ? , teacher_id = ?, active = ? WHERE id = ?");
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
	
	//TODO get singular lesson and get lesson by institution id
	public static List<Lesson> getAllLessons() {
		try {
			List<Lesson> userList = new ArrayList<Lesson>();
			Connection connection = Conexao.getConnection();

			PreparedStatement statement = connection.prepareStatement("SELECT * FROM lessons");

			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				Lesson lesson = new Lesson();//this requires the get of other tables, like the institution and the lesson_students //TODO this
				userList.add(lesson);
			}

			return userList;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		} finally {
			Conexao.closeConnection();
		}
	}
}

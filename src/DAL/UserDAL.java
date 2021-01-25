package DAL;

import java.util.*;
import java.sql.*;
import classes.users.*;
import classes.*;

public class UserDAL {

	public static User insertUser(User user, String password) {
		try {
			Connection connection = Conexao.getConnection();
			PreparedStatement statement = connection.prepareStatement("INSERT INTO users VALUES(null,?,?,?,?,?)");
			statement.setString(1, user.getName());
			statement.setString(2, user.getEmail());
			statement.setString(3, password);
			statement.setInt(4, user.getType().value);
			statement.setBoolean(5, user.isActive());
			statement.executeUpdate();
			ResultSet id = statement.getGeneratedKeys();
			if (id.next())
				user.setId(id.getInt(1));
			return user;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		} finally {
			Conexao.closeConnection();
		}
	}

	public static boolean updateUser(User user) {
		return updateUser(user, null);
	}
	
	public static boolean updateUser(User user, String password) {
		try {
			Connection connection = Conexao.getConnection();
			int i = 1;
			PreparedStatement statement = connection.prepareStatement("UPDATE users SET name = ?, email = ? ,"
					+ ((password != null && password != "") ? "password = ?," : "")
					+ "usertype = ?, active = ? WHERE id = ?");
			statement.setString(i, user.getName());
			i++;
			statement.setString(i, user.getEmail());
			i++;
			if (password != null && password != "") {
				statement.setString(i, password);
				i++;
			}
			statement.setInt(i, user.getType().value);
			i++;
			statement.setBoolean(i, user.isActive());
			i++;
			statement.setInt(i, user.getId());

			statement.executeUpdate();

			return true;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return false;
		} finally {
			Conexao.closeConnection();
		}
	}

	public static boolean deleteUser(int id) {
		try {
			Connection connection = Conexao.getConnection();
			Statement statement = connection.createStatement();
			String query1 = "DELETE FROM adm WHERE user_id = "+id;
			String query2 = "DELETE FROM teacher_lessons WHERE teacher_id = "+id;
			String query3 = "DELETE FROM lesson_students WHERE student_id = "+id;
			String query4 = "DELETE FROM users WHERE id = "+id;
			String query5 = "UPDATE lessons SET teacher_id = -1 WHERE teacher_id = "+ id;
			statement.addBatch(query1);
			statement.addBatch(query2);
			statement.addBatch(query3);
			statement.addBatch(query4);
			statement.addBatch(query5);
			statement.executeBatch();

			return true;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return false;
		} finally {
			Conexao.closeConnection();
		}
	}

	public static User getUser(int id) {
		try {
			Connection connection = Conexao.getConnection();
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE id = ?");
			statement.setInt(1, id);
			ResultSet resultSet = statement.executeQuery();
			User user = null;
			if (resultSet.next()) {
				user = new User(resultSet.getString("name"), resultSet.getString("email"),resultSet.getInt("id"), UserType.valueOfNumber(resultSet.getInt("usertype")), resultSet.getBoolean("active"));
			}
			return user;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		} finally {
			Conexao.closeConnection();
		}
	}

	public static List<User> getAllUsers() {
		try {
			List<User> userList = new ArrayList<User>();
			Connection connection = Conexao.getConnection();

			PreparedStatement statement = connection.prepareStatement("SELECT * FROM users");

			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				User user = new User(resultSet.getString("name"), resultSet.getString("email"), resultSet.getInt("id"),
						UserType.valueOfNumber(resultSet.getInt("usertype")), resultSet.getBoolean("active"));
				userList.add(user);
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

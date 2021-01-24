package DAL;

import java.util.*;
import java.sql.*;
import classes.users.*;
import classes.*;

//the Institution administrator, not to be mistaken by the server admin.
public class AdminDAL {
	public static InstitutionAdmin insertAdmin(InstitutionAdmin admin) {
		try {
			Connection connection = Conexao.getConnection();
			PreparedStatement statement = connection.prepareStatement("INSERT INTO adm VALUES(null,?,?)");
			statement.setInt(1, admin.getId());
			statement.setInt(2, admin.getInstitution().getId());
			statement.executeUpdate();
			ResultSet id = statement.getGeneratedKeys();
			if (id.next())
				admin.setId(id.getInt(1));
			return admin;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		} finally {
			Conexao.closeConnection();
		}
	}
	
	public static boolean updateAdmin(InstitutionAdmin admin) {//this should probably never be used
		try {
			Connection connection = Conexao.getConnection();
			PreparedStatement statement = connection.prepareStatement("UPDATE adm SET institution_id = ? WHERE user_id = ?");
			statement.setInt(1, admin.getInstitution().getId());
			statement.setInt(2, admin.getId());
			statement.executeUpdate();
			return true;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return false;
		} finally {
			Conexao.closeConnection();
		}
	}
	
	public static boolean deleteAdmin(int id) {
		try {
			Connection connection = Conexao.getConnection();
			PreparedStatement statement = connection.prepareStatement("DELETE FROM adm WHERE id = ?");
			statement.setInt(1, id);

			statement.executeUpdate();

			return true;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return false;
		} finally {
			Conexao.closeConnection();
		}
	}

	public static InstitutionAdmin getAdmin(int id) {
		try {
			Connection connection = Conexao.getConnection();
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM adm WHERE id = ?");
			statement.setInt(1, id);

			ResultSet resultSet = statement.executeQuery();
			InstitutionAdmin admin = null;
			if (resultSet.next()) {
				admin = new InstitutionAdmin(resultSet.getString("name"), resultSet.getString("email"),resultSet.getInt("id"), UserType.valueOfNumber(resultSet.getInt("usertype")), resultSet.getBoolean("active"));
			}
			return admin;
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

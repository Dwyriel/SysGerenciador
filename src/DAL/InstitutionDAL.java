package DAL;

import java.util.*;
import java.sql.*;
import classes.users.*;
import classes.*;

public class InstitutionDAL {

	public static Institution insertInstitution(Institution institution) {
		try {
			Connection connection = Conexao.getConnection();
			PreparedStatement statement = connection.prepareStatement("INSERT INTO institutions VALUES(null,?)", Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, institution.getName());
			statement.executeUpdate();
			ResultSet id = statement.getGeneratedKeys();
			if (id.next())
				institution.setId(id.getInt(1));
			return institution;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		} finally {
			Conexao.closeConnection();
		}
	}

	public static boolean updateInstitution(Institution institution) {
		try {
			Connection connection = Conexao.getConnection();
			PreparedStatement statement = connection.prepareStatement("UPDATE institutions SET name = ? WHERE id = ?");
			statement.setString(1, institution.getName());
			statement.setInt(2, institution.getId());
			statement.executeUpdate();
			return true;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return false;
		} finally {
			Conexao.closeConnection();
		}
	}

	public static boolean deleteInstitution(int id) {
		try {
			Connection connection = Conexao.getConnection();
			PreparedStatement statement = connection.prepareStatement("DELETE FROM institutions WHERE id = ?");
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

	public static Institution getInstitution(int id) {
		try {
			Connection connection = Conexao.getConnection();
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM institutions WHERE id = ?");
			statement.setInt(1, id);
			ResultSet resultSet = statement.executeQuery();
			Institution institution = null;
			if (resultSet.next()) {
				institution = new Institution(resultSet.getInt("id"), resultSet.getString("name"));
			}
			return institution;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		} finally {
			Conexao.closeConnection();
		}
	}

	public static List<Institution> getAllInstitutions() {
		try {
			List<Institution> institutionList = new ArrayList<Institution>();
			Connection connection = Conexao.getConnection();
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM institutions");
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Institution institution = new Institution(resultSet.getInt("id"), resultSet.getString("name"));
				institutionList.add(institution);
			}
			return institutionList;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		} finally {
			Conexao.closeConnection();
		}
	}
}

package DAL;

import java.util.*;
import java.sql.*;
import classes.users.*;
import classes.*;

//the Institution administrator, not to be mistaken with the server admin.
public class AdminDAL {
	public static InstitutionAdmin insertAdmin(InstitutionAdmin admin) {
		try {
			Connection connection = Conexao.getConnection();
			PreparedStatement statement = connection.prepareStatement("INSERT INTO adm VALUES(null,?,?)", Statement.RETURN_GENERATED_KEYS);
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

	public static boolean updateAdmin(InstitutionAdmin admin) {// this should probably never be used
		try {
			Connection connection = Conexao.getConnection();
			PreparedStatement statement = connection
					.prepareStatement("UPDATE adm SET institution_id = ? WHERE user_id = ?");
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
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM adm WHERE user_id = ?");
			statement.setInt(1, id);

			ResultSet resultSet = statement.executeQuery();
			InstitutionAdmin admin = null;
			if (resultSet.next()) {
				admin = new InstitutionAdmin(UserDAL.getUser(id),
						InstitutionDAL.getInstitution(resultSet.getInt("institution_id")));
			}
			return admin;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		} finally {
			Conexao.closeConnection();
		}
	}

	public static InstitutionAdmin getAdminByInstitution(int institution_id) {
		try {
			Connection connection = Conexao.getConnection();
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM adm WHERE institution_id = ?");
			statement.setInt(1, institution_id);

			ResultSet resultSet = statement.executeQuery();
			InstitutionAdmin admin = null;
			if (resultSet.next()) {
				admin = new InstitutionAdmin(UserDAL.getUser(resultSet.getInt("user_id")),
						InstitutionDAL.getInstitution(institution_id));
			}
			return admin;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		} finally {
			Conexao.closeConnection();
		}
	}

	public static List<InstitutionAdmin> getAllAdmins() {
		try {
			List<InstitutionAdmin> adminList = new ArrayList<InstitutionAdmin>();
			Connection connection = Conexao.getConnection();
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM adm");
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				InstitutionAdmin admin = new InstitutionAdmin(UserDAL.getUser(resultSet.getInt("user_id")),
						InstitutionDAL.getInstitution(resultSet.getInt("institution_id")));
				adminList.add(admin);
			}
			return adminList;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		} finally {
			Conexao.closeConnection();
		}
	}
}

package DAL;

import java.sql.*;

public class Conexao {
	/*
	 * public Conexao() { this.servidor =
	 * "b0ct7gpszqljrkihasaa-mysql.services.clever-cloud.com"; this.porta = "3306";
	 * this.bancoDados = "b0ct7gpszqljrkihasaa"; this.usuario = "ufjxrkklmrtvulik";
	 * this.senha = "e89vbO8hjokn9h1EFndV"; }
	 * 
	 * public Conexao(String servidor, String porta, String bancoDados, String
	 * usuario, String senha) { this.servidor = servidor; this.porta = porta;
	 * this.bancoDados = bancoDados; this.usuario = usuario; this.senha = senha; }
	 * We can either remove this or go back to how it was
	 */

	private static final String servidor = "b0ct7gpszqljrkihasaa-mysql.services.clever-cloud.com";
	private static final String porta = "3306";
	private static final String bancoDados = "b0ct7gpszqljrkihasaa";
	private static final String usuario = "ufjxrkklmrtvulik";
	private static final String senha = "e89vbO8hjokn9h1EFndV";

	public static Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://" + servidor + ":" + porta + "/" + bancoDados + "",
					usuario, senha);
			return connection;
		} catch (ClassNotFoundException e) {
			System.out.println("Driver is missing.");
			return null;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	public static boolean closeConnection() {
		try {
			getConnection().close();
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

}

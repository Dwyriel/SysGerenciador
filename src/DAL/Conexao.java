package DAL;

import java.sql.*;

public class Conexao {
	public Conexao() {
		this.servidor = "b0ct7gpszqljrkihasaa-mysql.services.clever-cloud.com";
		this.porta = "3306";
		this.bancoDados = "b0ct7gpszqljrkihasaa";
		this.usuario = "ufjxrkklmrtvulik";
		this.senha = "e89vbO8hjokn9h1EFndV";
	}

	public Conexao(String servidor, String porta, String bancoDados, String usuario, String senha) {
		this.servidor = servidor;
		this.porta = porta;
		this.bancoDados = bancoDados;
		this.usuario = usuario;
		this.senha = senha;
	}

	private static String servidor = "b0ct7gpszqljrkihasaa-mysql.services.clever-cloud.com";
	private static String porta = "3306";
	private static String bancoDados = "b0ct7gpszqljrkihasaa";
	private static String usuario = "ufjxrkklmrtvulik";
	private static String senha = "e89vbO8hjokn9h1EFndV";

	public static Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(  
		            "jdbc:mysql://" + servidor + ":" + porta + "/" + bancoDados + "",usuario,senha);
			if(connection != null)
				System.out.println("Connection not null");
			else 
				System.out.println("Connection null");
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

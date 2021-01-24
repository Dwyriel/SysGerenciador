package DAL;
import java.util.*;

//import Model.Usuario;
import classes.*;
import classes.users.*;
import java.sql.*;

public class TestDAL {
	public static User user = new User();
	public static String password;
	public static List<Institution> institutions = new ArrayList<Institution>();
	static {
		for(int i = 0; i < 3; i++) {
			Institution institution = new Institution("institution"+i, "Institution " + i);
			List<Lesson> lessons = new ArrayList();
			lessons.add(new Lesson("aula1", "Aula 1", institution));
			lessons.add(new Lesson("aula2", "Aula 2", institution));
			institution.setClasses(lessons);
			institutions.add(institution);
		}
	}
	public static User insert(User usuario, String password) {
        try {
            Connection connection = Conexao.getConnection();
            PreparedStatement statement = connection.prepareStatement("INSERT INTO teste VALUES(null,?,?,?)");  
            statement.setString(1, usuario.getName());  
            statement.setString(2, usuario.getEmail());  
            statement.setString(3, password);
         
            statement.executeUpdate();
          //  ResultSet id = stmt.getGeneratedKeys();
//            if(id.next())
//                usuario.setId(id.getInt(1));
              
            return usuario;
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        finally {
            Conexao.closeConnection();
        }
}
}

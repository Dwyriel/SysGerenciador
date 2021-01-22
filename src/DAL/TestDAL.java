package DAL;
import java.util.ArrayList;
import java.util.List;
import classes.*;
import classes.users.*;

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
}

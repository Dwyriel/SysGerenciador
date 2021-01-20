package classes.users;

import java.util.List;
import classes.*;

public class Teacher extends User {
	private List<Institution> institutions;
	private List<Lesson> lessons;

	public Teacher() {

	}

	public List<Institution> getInstitutions() {
		return institutions;
	}

	public void setInstitutions(List<Institution> institutions) {
		this.institutions = institutions;
	}

	public List<Lesson> getLessons() {
		return lessons;
	}

	public void setLessons(List<Lesson> lessons) {
		this.lessons = lessons;
	}
}

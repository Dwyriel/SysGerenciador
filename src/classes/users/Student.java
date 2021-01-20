package classes.users;

import java.util.List;
import classes.*;

public class Student {
	private Institution institutions;
	private List<Lesson> lessons;

	public Student() {

	}

	public Institution getInstitutions() {
		return institutions;
	}

	public void setInstitutions(Institution institutions) {
		this.institutions = institutions;
	}

	public List<Lesson> getLessons() {
		return lessons;
	}

	public void setLessons(List<Lesson> lessons) {
		this.lessons = lessons;
	}
}

package classes.users;

import java.util.List;
import classes.*;

public class Student extends User {
	private Institution institution;
	private List<Lesson> lessons;

	public Student() {
		super();
		this.institution = null;
		this.lessons = null;
	}

	public Student(String name) {
		super(name);
	}

	public Student(String name, String email) {
		super(name, email);
		this.institution = null;
		this.lessons = null;
	}

	public Student(String name, String email, UserType type) {
		super(name, email, type);
		this.institution = null;
		this.lessons = null;
	}

	public Student(String name, String email, UserType type, boolean active) {
		super(name, email, type, active);
		this.institution = null;
		this.lessons = null;
	}

	public Student(String name, String email, UserType type, boolean active, Institution institutions) {
		super(name, email, type, active);
		this.institution = institutions;
		this.lessons = null;
	}

	public Student(String name, String email, UserType type, boolean active, Institution institutions,
			List<Lesson> lessons) {
		super(name, email, type, active);
		this.institution = institutions;
		this.lessons = lessons;
	}

	public Student(String name, String email, int id, UserType type, boolean active) {
		super(name, email, id, type, active);
		this.institution = null;
		this.lessons = null;
	}

	public Student(String name, String email, int id, UserType type, boolean active, Institution institutions,
			List<Lesson> lessons) {
		super(name, email, id, type, active);
		this.institution = institutions;
		this.lessons = lessons;
	}

	public Institution getInstitutions() {
		return institution;
	}

	public void setInstitutions(Institution institutions) {
		this.institution = institutions;
	}

	public List<Lesson> getLessons() {
		return lessons;
	}

	public void setLessons(List<Lesson> lessons) {
		this.lessons = lessons;
	}

	@Override
	public String toString() {
		String rString = super.toString();
		rString += ((this.institution != null) ? ("\nInstituição: " + this.institution.getName()) + "\n" : "");
		return rString;
	}
}

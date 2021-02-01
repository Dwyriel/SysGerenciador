package classes.users;

import java.util.*;
import classes.*;

public class Student extends User {
	private Institution institution = new Institution();
	private List<Lesson> lessons = new ArrayList<Lesson>();

	public Student() {
		super();
	}

	public Student(String email) {
		super(email);
	}

	public Student(String name, String email) {
		super(name, email);
	}

	public Student(String name, String email, UserType type) {
		super(name, email, type);
	}

	public Student(String name, String email, UserType type, boolean active) {
		super(name, email, type, active);
	}

	public Student(String name, String email, UserType type, boolean active, Institution institutions) {
		super(name, email, type, active);
		this.institution = institutions;
	}

	public Student(String name, String email, UserType type, boolean active, Institution institutions,
			List<Lesson> lessons) {
		super(name, email, type, active);
		this.institution = institutions;
		this.lessons = lessons;
	}

	public Student(String name, String email, int id, UserType type, boolean active) {
		super(name, email, id, type, active);
	}

	public Student(User user) {
		super(user.getName(), user.getEmail(), user.getId(), user.getType(), user.isActive());
	}

	public Student(String name, String email, int id, UserType type, boolean active, Institution institutions,
			List<Lesson> lessons) {
		super(name, email, id, type, active);
		this.institution = institutions;
		this.lessons = lessons;
	}

	public Student(User user, Institution institutions, List<Lesson> lessons) {
		super(user.getName(), user.getEmail(), user.getId(), user.getType(), user.isActive());
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

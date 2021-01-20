package classes.users;

import java.util.List;
import classes.*;

public class Student extends User {
	private Institution institutions;
	private List<Lesson> lessons;

	public Student() {
		super();
		this.institutions = null;
		this.lessons = null;
	}

	public Student(String name) {
		super(name);
	}

	public Student(String name, String email) {
		super(name, email);
		this.institutions = null;
		this.lessons = null;
	}

	public Student(String name, String email, UserType type) {
		super(name, email, type);
		this.institutions = null;
		this.lessons = null;
	}

	public Student(String name, String email, UserType type, boolean active) {
		super(name, email, type, active);
		this.institutions = null;
		this.lessons = null;
	}

	public Student(String name, String email, UserType type, boolean active, Institution institutions) {
		super(name, email, type, active);
		this.institutions = institutions;
		this.lessons = null;
	}

	public Student(String name, String email, UserType type, boolean active, Institution institutions,
			List<Lesson> lessons) {
		super(name, email, type, active);
		this.institutions = institutions;
		this.lessons = lessons;
	}

	public Student(String name, String email, String id, UserType type, boolean active) {
		super(name, email, id, type, active);
		this.institutions = null;
		this.lessons = null;
	}

	public Student(String name, String email, String id, UserType type, boolean active, Institution institutions,
			List<Lesson> lessons) {
		super(name, email, id, type, active);
		this.institutions = institutions;
		this.lessons = lessons;
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

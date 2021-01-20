package classes.users;

import java.util.List;
import classes.*;

public class Teacher extends User {
	private List<Institution> institutions;
	private List<Lesson> lessons;

	public Teacher() {
		super();
		this.institutions = null;
		this.lessons = null;
	}

	public Teacher(String name) {
		super(name);
	}

	public Teacher(String name, String email) {
		super(name, email);
		this.institutions = null;
		this.lessons = null;
	}

	public Teacher(String name, String email, UserType type) {
		super(name, email, type);
		this.institutions = null;
		this.lessons = null;
	}

	public Teacher(String name, String email, UserType type, boolean active) {
		super(name, email, type, active);
		this.institutions = null;
		this.lessons = null;
	}

	public Teacher(String name, String email, UserType type, boolean active, List<Institution> institutions) {
		super(name, email, type, active);
		this.institutions = institutions;
		this.lessons = null;
	}

	public Teacher(String name, String email, UserType type, boolean active, List<Institution> institutions,
			List<Lesson> lessons) {
		super(name, email, type, active);
		this.institutions = institutions;
		this.lessons = lessons;
	}

	public Teacher(String name, String email, String id, UserType type, boolean active) {
		super(name, email, id, type, active);
		this.institutions = null;
		this.lessons = null;
	}

	public Teacher(String name, String email, String id, UserType type, boolean active, List<Institution> institutions,
			List<Lesson> lessons) {
		super(name, email, id, type, active);
		this.institutions = institutions;
		this.lessons = lessons;
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

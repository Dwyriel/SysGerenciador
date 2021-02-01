package classes.users;

import java.util.*;
import classes.*;

public class Teacher extends User {
	private List<Institution> institutions = new ArrayList<Institution>();
	private List<Lesson> lessons = new ArrayList<Lesson>();

	public Teacher() {
		super();
	}

	public Teacher(String email) {
		super(email);
	}

	public Teacher(String name, String email) {
		super(name, email);
	}

	public Teacher(String name, String email, UserType type) {
		super(name, email, type);
	}

	public Teacher(String name, String email, UserType type, boolean active) {
		super(name, email, type, active);
	}

	public Teacher(String name, String email, UserType type, boolean active, List<Institution> institutions) {
		super(name, email, type, active);
		this.institutions = institutions;
	}

	public Teacher(String name, String email, UserType type, boolean active, List<Institution> institutions,
			List<Lesson> lessons) {
		super(name, email, type, active);
		this.institutions = institutions;
		this.lessons = lessons;
	}

	public Teacher(String name, String email, int id, UserType type, boolean active) {
		super(name, email, id, type, active);
	}

	public Teacher(User user) {
		super(user.getName(), user.getEmail(), user.getId(), user.getType(), user.isActive());
	}

	public Teacher(String name, String email, int id, UserType type, boolean active, List<Institution> institutions,
			List<Lesson> lessons) {
		super(name, email, id, type, active);
		this.institutions = institutions;
		this.lessons = lessons;
	}

	public Teacher(User user, List<Institution> institutions, List<Lesson> lessons) {
		super(user.getName(), user.getEmail(), user.getId(), user.getType(), user.isActive());
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

package classes;

import java.util.*;
import classes.users.*;

public class Lesson {
	private int id = -1;
	private String name = "";
	private User teacher = new User();
	private List<User> students = new ArrayList<User>();
	private Institution institution;
	private boolean active = true;

	// TODO forum, assignments, class material

	public Lesson() {}

	public Lesson(String nome) {
		this.name = nome;
	}

	public Lesson(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public Lesson(int id, String name, Institution institution) {
		this.id = id;
		this.name = name;
		this.institution = institution;
	}
	
	public Lesson(String name, Institution institution) {
		this.name = name;
		this.institution = institution;
	}

	public Lesson(int id, String name, User teacher) {
		this.id = id;
		this.name = name;
		this.teacher = teacher;
	}

	public Lesson(int id, String name, User teacher, Institution institution) {
		this.id = id;
		this.name = name;
		this.teacher = teacher;
		this.institution = institution;
	}
	
	public Lesson(String name, User teacher, Institution institution) {
		this.name = name;
		this.teacher = teacher;
		this.institution = institution;
	}

	public Lesson(int id, String name, User teacher, Institution institution, boolean active) {
		this.id = id;
		this.name = name;
		this.teacher = teacher;
		this.institution = institution;
		this.active = active;
	}
	
	public Lesson(String name, User teacher, Institution institution, boolean active) {
		this.id = -1;
		this.name = name;
		this.teacher = teacher;
		this.institution = institution;
		this.active = active;
	}

	public Lesson(int id, String name, User teacher, List<User> students) {
		this.id = id;
		this.name = name;
		this.teacher = teacher;
		this.students = students;
	}

	public Lesson(int id, String name, User teacher, List<User> students, Institution institution) {
		this.id = id;
		this.name = name;
		this.teacher = teacher;
		this.students = students;
		this.institution = institution;
	}

	public Lesson(int id, String name, User teacher, List<User> students, Institution institution, boolean active) {
		this.id = id;
		this.name = name;
		this.teacher = teacher;
		this.students = students;
		this.institution = institution;
		this.active = active;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User getTeacher() {
		return teacher;
	}

	public void setTeacher(User teacher) {
		this.teacher = teacher;
	}

	public List<User> getStudents() {
		return students;
	}

	public void setStudents(List<User> students) {
		this.students = students;
	}

	public Institution getInstitution() {
		return institution;
	}

	public void setInstitution(Institution institution) {
		this.institution = institution;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return (((id != -1) ? ("Id: " + id + "\n") : "") + ((name != null) ? ("Name: " + name + "\n") : "")
				+ ((teacher.getName() != null) ? ("Professor: " + teacher.getName() + "\n") : "")
				+ ((this.institution != null) ? ("\nInstituição: " + this.institution.getName()) + "\n" : "")
				+ "Ativo: " + ((active) ? "Sim" : "Não"));
	}
}

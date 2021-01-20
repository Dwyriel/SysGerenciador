package classes;

import java.util.List;
import classes.users.*;

public class Lesson {
	private String id;
	private String name;
	private Teacher teacher;
	private List<Student> students;
	private Institution institution;
	private boolean active;

	// TODO forum, assignments, class material

	public Lesson() {
		this.id = null;
		this.name = null;
		this.teacher = null;
		this.students = null;
		this.institution = null;
	}

	public Lesson(String nome) {
		this.id = null;
		this.name = nome;
		this.teacher = null;
		this.students = null;
		this.institution = null;
	}

	public Lesson(String id, String name) {
		this.id = id;
		this.name = name;
		this.teacher = null;
		this.students = null;
		this.institution = null;
	}

	public Lesson(String id, String name, Institution institution) {
		this.id = id;
		this.name = name;
		this.teacher = null;
		this.students = null;
		this.institution = institution;
	}

	public Lesson(String id, String name, Teacher teacher) {
		this.id = id;
		this.name = name;
		this.teacher = teacher;
		this.students = null;
		this.institution = null;
	}

	public Lesson(String id, String name, Teacher teacher, List<Student> students) {
		this.id = id;
		this.name = name;
		this.teacher = teacher;
		this.students = students;
		this.institution = null;
	}

	public Lesson(String id, String name, Teacher teacher, List<Student> students, Institution institution) {
		this.id = id;
		this.name = name;
		this.teacher = teacher;
		this.students = students;
		this.institution = institution;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
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
		return (((id != null) ? ("Id: " + id + "\n") : "") + ((name != null) ? ("Name: " + name + "\n") : "")
				+ ((teacher.getName() != null) ? ("Professor: " + teacher.getName() + "\n") : "")
				+ ((this.institution != null) ? ("\nInstituição: " + this.institution.getName()) + "\n" : "")
				+ "Ativo: " + ((active) ? "Sim" : "Não"));
	}
}

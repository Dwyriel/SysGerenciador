package classes;

import java.util.List;

import classes.users.User;

public class Lesson {
	private String id;
	private String name;
	private User teacher;
	private List<User> students;
	private Institution institution;

	// TODO forum, assignments, class material

	public Lesson() {

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
}

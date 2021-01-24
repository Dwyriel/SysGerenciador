package classes;

import java.util.ArrayList;
import java.util.List;
import classes.users.User;

public class Institution {
	private int id;
	private String name;
	private List<Lesson> classes = new ArrayList<Lesson>();
	private List<User> Admins = new ArrayList<User>();
	// TODO forum

	public Institution() {
		this.name = null;
		this.id = -1;
		this.classes = null;
	}

	public Institution(String name) {
		this.name = name;
		this.id = -1;
		this.classes = null;
	}

	public Institution(int id, String name) {
		this.name = name;
		this.id = id;
		this.classes = null;
	}

	public Institution(int id, String name, List<Lesson> lessons) {
		this.name = name;
		this.id = id;
		this.classes = lessons;
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

	public List<Lesson> getClasses() {
		return classes;
	}

	public void setClasses(List<Lesson> classes) {
		this.classes = classes;
	}

	public List<User> getAdmins() {
		return Admins;
	}

	public void setAdmins(List<User> admins) {
		Admins = admins;
	}

	@Override
	public String toString() {
		return (((id != -1) ? ("Id: " + id + "\n") : "") + ((name != null) ? ("Name: " + name + "\n") : ""));
	}
}

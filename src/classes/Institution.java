package classes;

import java.util.List;

public class Institution {
	private String id;
	private String name;
	private List<Lesson> classes;
	// TODO forum

	public Institution() {

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

	public List<Lesson> getClasses() {
		return classes;
	}

	public void setClasses(List<Lesson> classes) {
		this.classes = classes;
	}
}

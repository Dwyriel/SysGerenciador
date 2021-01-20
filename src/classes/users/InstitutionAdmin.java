package classes.users;

import java.util.List;

import classes.Institution;
import classes.Lesson;

public class InstitutionAdmin extends User {
	private Institution institution;

	public InstitutionAdmin() {
		super();
		this.institution = null;
	}

	public InstitutionAdmin(String name) {
		super(name);
	}

	public InstitutionAdmin(String name, String email) {
		super(name, email);
		this.institution = null;
	}

	public InstitutionAdmin(String name, String email, UserType type) {
		super(name, email, type);
		this.institution = null;
	}

	public InstitutionAdmin(String name, String email, UserType type, boolean active) {
		super(name, email, type, active);
		this.institution = null;
	}

	public InstitutionAdmin(String name, String email, UserType type, boolean active, Institution institutions) {
		super(name, email, type, active);
		this.institution = institutions;
	}

	public InstitutionAdmin(String name, String email, String id, UserType type, boolean active) {
		super(name, email, id, type, active);
		this.institution = null;
	}

	public InstitutionAdmin(String name, String email, String id, UserType type, boolean active,
			Institution institutions, List<Lesson> lessons) {
		super(name, email, id, type, active);
		this.institution = institutions;
	}

	public Institution getInstitution() {
		return institution;
	}

	public void setInstitution(Institution institution) {
		this.institution = institution;
	}
}

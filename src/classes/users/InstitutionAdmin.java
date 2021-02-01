package classes.users;

import java.util.List;

import classes.Institution;
import classes.Lesson;

public class InstitutionAdmin extends User {
	private Institution institution = new Institution();

	public InstitutionAdmin() {
		super();
	}

	public InstitutionAdmin(String email) {
		super(email);
	}

	public InstitutionAdmin(String name, String email) {
		super(name, email);
	}

	public InstitutionAdmin(String name, String email, UserType type) {
		super(name, email, type);
	}

	public InstitutionAdmin(String name, String email, UserType type, boolean active) {
		super(name, email, type, active);
	}

	public InstitutionAdmin(String name, String email, UserType type, boolean active, Institution institutions) {
		super(name, email, type, active);
		this.institution = institutions;
	}

	public InstitutionAdmin(String name, String email, int id, UserType type, boolean active) {
		super(name, email, id, type, active);
	}

	public InstitutionAdmin(User user) {
		super(user.getName(), user.getEmail(), user.getId(), user.getType(), user.isActive());
	}

	public InstitutionAdmin(String name, String email, int id, UserType type, boolean active,
			Institution institutions) {
		super(name, email, id, type, active);
		this.institution = institutions;
	}

	public InstitutionAdmin(User user, Institution institutions) {
		super(user.getName(), user.getEmail(), user.getId(), user.getType(), user.isActive());
		this.institution = institutions;
	}

	public Institution getInstitution() {
		return institution;
	}

	public void setInstitution(Institution institution) {
		this.institution = institution;
	}

	@Override
	public String toString() {
		String rString = super.toString();
		rString += ((this.institution != null) ? ("\nInstituição: " + this.institution.getName()) + "\n" : "");
		return rString;
	}
}

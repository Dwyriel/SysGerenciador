package classes.users;

public class User {
	private int id;
	private String name;
	private String email;
	// private String password;
	private UserType type;
	private boolean active;

	public User() {
		this.id = -1;
		this.name = null;
		this.email = null;
		this.type = UserType.None;
		this.active = false;
	}

	public User(String name) {
		this.id = -1;
		this.name = name;
		this.email = null;
		this.type = UserType.None;
		this.active = false;
	}

	public User(String name, String email) {
		this.id = -1;
		this.name = name;
		this.email = email;
		this.type = UserType.None;
		this.active = false;
	}

	public User(String name, String email, UserType type) {
		this.id = -1;
		this.name = name;
		this.email = email;
		this.type = type;
		this.active = false;
	}

	public User(String name, String email, UserType type, boolean active) {
		this.id = -1;
		this.name = name;
		this.email = email;
		this.type = type;
		this.active = active;
	}

	public User(String name, String email, int id, UserType type, boolean active) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.type = type;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public UserType getType() {
		return type;
	}

	public void setType(UserType type) {
		this.type = type;
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
				+ ((email != null) ? ("Email: " + email + "\n") : "") + type.title + "\nAtivo: "
				+ ((active) ? "Sim" : "Não"));
	}
}
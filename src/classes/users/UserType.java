package classes.users;

import java.util.HashMap;
import java.util.Map;

public enum UserType {
	ServerAdmin("Administrador do site", 0), InstitutionAdmin("Administrador", 1), Teacher("Professor", 2),	Student("Estudante", 3), None("Não validado", 4);

	public String title;
	public int value;

	private static final Map<String, UserType> BY_TITLE = new HashMap<>();
	private static final Map<Integer, UserType> BY_VALUE = new HashMap<>();

	// for reference, this puts the title and value in a map so it's easy to return
	// the Type by those values later
	static {
		for (UserType e : values()) {
			BY_TITLE.put(e.title, e);
			BY_VALUE.put(e.value, e);
		}
	}

	private UserType(String title, int value) {
		this.title = title;
		this.value = value;
	}

	public static UserType valueOfTitle(String title) {
		return BY_TITLE.get(title);
	}

	public static UserType valueOfNumber(int value) {
		return BY_VALUE.get(value);
	}
}

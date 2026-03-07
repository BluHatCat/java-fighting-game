package characters;

/**
 * A balanced fighter-type
 */
public class Warrior extends Fighter {
	public Warrior(String name) {
		super(name, 100, 10, 10, 0.1, 0.1, 1, 10);
	}
	
	public String getType() {
		return "Warrior";
	}
}

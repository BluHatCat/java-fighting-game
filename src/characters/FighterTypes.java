package characters;

public enum FighterTypes {
	WARRIOR{
		public Fighter create(String name) {
			return new Warrior(name);
		}
		public String description() {
			return "The classic fighter type. They like swords. Really, just a normal dude!";
		}
	},
	
	ASSASSIN{
		public Fighter create(String name) {
			return new Assassin(name);
		}
		public String description() {
			return "They won't take much and might not be as strong as others, but they are speedy and precise!";
		}
	},
	
	BARBARIAN{
		public Fighter create(String name) {
			return new Barbarian(name);
		}
		public String description() {
			return "Not the fastest (or smartest), but they can't only land a hard blow, but also take a few of those!";
		}
	};
	
	//required methods
	public abstract Fighter create(String name);
	public abstract String description();

}

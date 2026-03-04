package ui;

/**
 * Any menuUIs
 */
public class MenuUi {
	public static void space() {
		System.out.println("\n----------\n");
	}
	
	public static void waiting() {
		Visuals.typedln(Colours.RED.code() + "Please wait a sec..." + Colours.RESET.code());
	}
	
	public static void showMenu() {
		Visuals.typedln("What do you want to do?");
		Visuals.printLines(false, 0, 
				"1. Add fighter", 
				"2. Let's fight!", 
				"3. Ranking", 
				"4. Leave Arena");
		Visuals.typed("Please choose a number: ");
	}
	
	//*******
	//Lines for options 3 and 4 in menu
	public static void ranked(int place, String name, int wins ) {
		System.out.println(place + ". Place - " + name + ": " + wins);
	}
	
	//*******	
	//Lines for creating a new fighter	
		public static void newFighterInit() {
			Visuals.printLines(false, 0,
					"New fighter?",
					"Awesome! What's their name? ");
		}
		
		public static void classesInit() {
			System.out.println("Now to their class! We let the following classes fight here:");
		}
		
		public static void classesList(int number, String name, String description) {
			Visuals.printLines(false, 0, number + " - " + name + ": " + description);
		}
		
		public static void classesChPr() {
			System.out.print("What is their class (enter number): ");
		}
		
		public static void newFighterDone(String name, String fclass) {
			System.out.println("Alright, " + name + ", a " + fclass + " is all set up!");
		}

	//*******	
	//Lines	for Choosing fighters before the fight
		public static void fighterChoiceInit() {
			System.out.println("Alright, you wanna fight!\nThat's awesome!");
			System.out.println("So let's choose your fighters; these are the available ones:");
		}
		
		public static void fighterChoiceList(int number, String name, int wins) {
			Visuals.printLines(false, 0, number+1 + " - " + name + ": " + wins + " wins");
		}
		
		public static void fighterCh1Pr() {	
			System.out.println("Your first fighter (enter number): ");
		}
		
		public static void fighterCh1(String name) {
			System.out.println("Your first fighter is: " + name);
		}
		
		public static void fighterCh2Pr() {
			System.out.print("Your second fighter (enter number): ");
		}
		
		public static void fighterCh2(String name) {
			System.out.println("Your second fighter is: " + name);
		}
	
	//*******		
	//Lines for errors, problems etc.	
		public static void missingFighters() {
			System.out.println("Sorry, there aren't enough fighters yet!\n");
		}
		
		public static void error() {
			System.out.println("Invalid number!");
		}

		public static void pressEnter() {
			System.out.println(Visuals.paint(Colours.GREY, "Press Enter to Continue"));
		}

}

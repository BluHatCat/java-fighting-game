package ui;

import characters.Fighter;

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
	
	public static void enterNum() {
		Visuals.typed("Please enter a number: ");
	}
	
	public static void showMenu() {
		Visuals.typedln("What do you want to do?");
		Visuals.printLines(false, 0, 
				"1. Manage fighters", 
				"2. Let's fight!",  
				"3. Leave Arena");
		enterNum();
	}
	
	public static void showCharMenu() {
		Visuals.printLines(true, 10, 
				"You want to manage your fighters?",
				"Very well, what do you want to do? ");
		Visuals.printLines(false, 40,
				"1. Add fighter",
				"2. View fighters/Ranking",
				"3. Edit fighters",
				"4. Back to arena");
		enterNum();
	}
	
//*******	
//Lines for managing fighters
	
	//New fighter
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
		
	//Lists a fighter with a number, their name, their type and optionally their wins	
		public static void fighterList(int number, Fighter f, boolean wins) {
			if(wins) {
			Visuals.printLines(false, 0, number+1 + " - " + f.getName() + ", " + f.getType() + ": " + f.getWins() + " wins");
			} else {
				Visuals.printLines(false, 0, number+1 + " - " + f.getName() + ", " + f.getType());	
			}
		}
		
	//Lines for editing a fighter
		public static void editFighterPr() {
			Visuals.printLines(true, 40, 
					"So you want to change a fighters name?", 
					"What fighter do you want to change?");
		}
		
		public static void choiceMade(String name) {
			System.out.println("You wanna edit " + name + " ? No problem!");
		}
		public static void editFighterPr2() {
			System.out.println("Alright, what's their new name?");
		}
		
		public static void editFighterDone(String name) {
			System.out.println("We're done, their new name is: " + name);
		}

//*******	
//Lines	for Choosing fighters before the fight
		public static void fighterChoiceInit() {
			System.out.println("Alright, you wanna fight!\nThat's awesome!");
			System.out.println("So let's choose your fighters; these are the available ones:");
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
		
//*******
//ByeBye
		public static void adios() {
			Visuals.typedln("I hope you had fun! Come visit us again soon!");
		}

}

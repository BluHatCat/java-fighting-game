package ui;

import java.util.Scanner;

import characters.Fighter;
import game.Util;

/**
 * formats different visuals
 */
public class Visuals {
	//Creating Display-Assets (eg health bar)
		public static String healthBar(Fighter f) {
			int health = Math.max(0, f.getHealth());
			int max = f.getMaxHealth();
			StringBuffer s = new StringBuffer();
			
			double percent = ((double) health)/((double) max);
			int filled = (int) (percent * 10);
			
			Colours colour;
			if(percent > 0.6) {
				colour = Colours.GREEN;
			} else if(percent > 0.3) {
				colour = Colours.YELLOW;
			} else {
				colour = Colours.RED;
			}
			
			s.append(f.getName() + "\t[");
			for(int i = 0; i<10; i++) {
				if(i<filled) {
					s.append(paint(colour, "█"));
				} else {
					s.append("░");
				}
			}
			s.append("]");
			return s.toString();
		}
		
		protected static void enterToCon(Scanner s) {
			typedln(Visuals.paint(Colours.GREY, "Press enter to continue"));
			s.nextLine();
		}

		
	//Changing the output of text
		//printing text in a certain colour
		public static String paint(Colours colour, String s) {
			return colour.code() + s + Colours.RESET.code();
		}
		
		//printing text with a typing-effect (appearing letter by letter)
		protected static void typed(String text) {
				for(char c : text.toCharArray()) {
						System.out.print(c);
						Util.sleep(0);
				}
			}
		
		protected static void typedln(String text) {
				for(char c : text.toCharArray()) {
						System.out.print(c);
						Util.sleep(0);
				}
				System.out.println();
			}
		
		//printing multiple Strings line by line, if wanted with a type-effect
		protected static void printLines(boolean typed, int wait, String...text) {
			for(String sentence : text) {
				Util.sleep(wait);
				if(typed) {
					typedln(sentence);
					Util.sleep(wait);
				} else {
					System.out.println(sentence);
					Util.sleep(wait);
				}
				
			}
		}

}

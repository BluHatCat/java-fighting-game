package game;

import java.util.Scanner;

import characters.FighterTypes;
import ui.MenuUi;

/**
 * A class containing methods used in different parts of the game, that don't really belong anywhere
 */
public class Util {
	public static void enterToCon(Scanner s) {
		MenuUi.pressEnter();
		s.nextLine();
	}
	
	public static void sleep(int durationMs) {
		try {
			Thread.sleep(durationMs);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static int check(String s) {
		try {
			int num = Integer.parseInt(s);
			return num;
		} catch (Exception e) {
			return -1;
			}
	}
	
	public static int inputInBounds(Scanner s, int min, int max) {
		int num;
		boolean ok = true;
		do {
			num = Util.check(s.nextLine());
			if(num<min || num> max) {
				MenuUi.error();
				ok=false;
			} else {
				ok = true;
			}
		}while(ok==false);
		return num;
	}
	
	
	public static FighterTypes toClass(int number) {
		try {
			return FighterTypes.values()[number];
		} catch (Exception e) {
			MenuUi.error();
			return null;
		}
	}
	
	public static void classList() {
		for(FighterTypes type : FighterTypes.values()) {
			MenuUi.classesList(type.ordinal()+1, type.name(), type.description());
		}
	}
}

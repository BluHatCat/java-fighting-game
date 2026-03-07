package game;

import java.util.Scanner;

import arena.FightPair;
import arena.FighterManager;
import ui.CombatUI;
import ui.MenuUi;

/**
 * Handles the different menus in the game
 */
public class MenuHandler {
private FighterManager arena;
	
	public MenuHandler() {
		arena = new FighterManager();
	}
	
	public String menu(Scanner s) {
		MenuUi.showMenu();
		String choice = s.nextLine();
		Util.sleep(0);
		MenuUi.space();
		return choice;
	}
	
	public boolean menuAction(int action, Scanner s) {
		switch (action){
		case 1 -> {
			boolean notDone = true;
			do {
				int choice = Util.check(fighterMenu(s));
				notDone = fighterAction(choice, s);
			} while(notDone == true);
			return true;}
		case 2 -> {
			if(arena.numFighters()<2) {
				MenuUi.missingFighters();
				MenuUi.space();
			} else {
				FightPair pair = arena.fighterChoice(s); 
				MenuUi.space();
				String winner = arena.getCombat().fight(pair, s);
				CombatUI.result(winner);
				Util.enterToCon(s);}
			return true;}
		case 3 -> {
			MenuUi.adios();
			Util.enterToCon(s);
			return false;}
		default -> {
			MenuUi.error(); 
			return true;}
		}
	}
	
	private static String fighterMenu(Scanner s) {
		MenuUi.showCharMenu();
		String choice = s.nextLine();
		Util.sleep(0);
		MenuUi.space();
		return choice;
	}

	private boolean fighterAction(int action, Scanner s) {
		switch (action){
		case 1 -> {
			arena.addFighter(s);
			return true;}
		case 2 -> {
			arena.ranking();
			Util.enterToCon(s);
			MenuUi.space();
			return true;}
		case 3 -> {
			arena.editFighter(s);
			return true;}
		case 4 -> {
			return false;}
		default -> {
			MenuUi.error(); 
			return true;}
		}
	}
	
	

}

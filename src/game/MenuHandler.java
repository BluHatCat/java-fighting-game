package game;

import java.util.Scanner;

import arena.FightPair;
import arena.FighterManager;
import characters.FighterTypes;
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
	
	public static String menu(Scanner s) {
		MenuUi.showMenu();
		String choice = s.nextLine();
		Util.sleep(0);
		MenuUi.space();
		return choice;
	}
	
	public boolean action(int action, Scanner s) {
		switch (action){
		case 1 -> 	{MenuUi.newFighterInit();
					String name = s.nextLine();
					MenuUi.classesInit();
					classList();
					MenuUi.classesChPr();
					FighterTypes fclass = Util.toClass(Util.check(s.nextLine())-1);
					arena.addFighter(name, fclass);
					MenuUi.waiting();
					Util.sleep(0);
					MenuUi.newFighterDone(name, fclass.name());
					MenuUi.space();
					Util.sleep(0);
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
		case 3 -> {arena.ranking(); return true;}
		case 4 -> {return false;}
		default -> {MenuUi.error(); return true;}
		}
	}
	

	private static void classList() {
		for(FighterTypes type : FighterTypes.values()) {
			MenuUi.classesList(type.ordinal()+1, type.name(), type.description());
		}
	}

}

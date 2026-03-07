package arena;

import java.awt.Menu;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import characters.Fighter;
import characters.FighterTypes;
import game.Util;
import ui.MenuUi;


/**
 * Managing the different fighters
 */
public class FighterManager {
	private List<Fighter> fighters;
	private Combat combat;
	
	public FighterManager(){
		fighters = new ArrayList<>();
		combat = new Combat(this);
	}
	

	/**
	 * Adding a fighter to the available choices
	 * @param name
	 * @param fclass
	 */
	public void addFighter(Scanner s) {
		MenuUi.newFighterInit();
		String name = s.nextLine();
		MenuUi.classesInit();
		Util.classList();
		MenuUi.classesChPr();
		FighterTypes fclass = Util.toClass(Util.inputInBounds(s, 1, FighterTypes.values().length)-1);
		fighters.add(fclass.create(name));
		MenuUi.waiting();
		Util.sleep(0);
		MenuUi.newFighterDone(name, fclass.name());
		MenuUi.space();
		Util.sleep(0);
	}
	
	public FightPair fighterChoice(Scanner s) {
		MenuUi.fighterChoiceInit();
		for(int i= 0; i<numFighters(); i++) {
			MenuUi.fighterList(i, getFighter(i), false);
		}
		MenuUi.fighterCh1Pr();
		int index1 = Util.inputInBounds(s, 1, numFighters())-1;
		MenuUi.fighterCh1(getFighter(index1).getName());
		MenuUi.fighterCh2Pr();
		int index2 = Util.inputInBounds(s, 1, numFighters())-1;
		MenuUi.fighterCh2(getFighter(index2).getName());
		FightPair pair = new FightPair(getFighter(index1), getFighter(index2));
		return pair;
	}
	
	public void editFighter(Scanner s) {
		MenuUi.editFighterPr();
		for(int i = 0; i<numFighters(); i++) {
			MenuUi.fighterList(i, getFighter(i), false);
			MenuUi.enterNum();
			int index = Util.inputInBounds(s, 1, numFighters())-1;
			MenuUi.choiceMade(getFighter(index).getName());
			MenuUi.editFighterPr2();
			getFighter(index).setName(s.nextLine());
			MenuUi.editFighterDone(getFighter(index).getName());
			MenuUi.space();
		}
	}

//Resets a fighter to their innitial health and initiative
	public void resetAll() {
		for(Fighter fighter : fighters) {
			fighter.reset();
		}
	}
	
//ranks the fighters by how many fights they have won
	public void ranking() {
		int i = 0;
		fighters.sort((a,b) -> b.getWins() - a.getWins());
		for(Fighter fighter : fighters) {
			MenuUi.fighterList(i, fighter, true);
			i++;
		}
	}
	
	
//support methods 
	public Fighter getFighter(int index) {
		return fighters.get(index);
	}
	
	public int numFighters() {
		return fighters.size();
	}
	
	public Combat getCombat() {
		return combat;
	}

}

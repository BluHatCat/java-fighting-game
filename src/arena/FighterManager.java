package arena;

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
		FighterTypes fclass = Util.toClass(Util.inputInBounds(s, 1, Util.numTypes())-1);
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
			MenuUi.fighterChoiceList(i, getFighter(i).getName(), getFighter(i).getWins() );
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

//Resets a fighter to their innitial health and initiative
	public void resetAll() {
		for(Fighter fighter : fighters) {
			fighter.reset();
		}
	}
	
//ranks the fighters by how many fights they have won
	public void ranking() {
		int i = 1;
		fighters.sort((a,b) -> b.getWins() - a.getWins());
		for(Fighter fighter : fighters) {
			MenuUi.ranked(i, fighter.getName(), fighter.getWins());
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

package arena;

import java.util.Scanner;

import characters.Fighter;
import game.Util;
import ui.CombatUI;
import ui.MenuUi;


/**
 * Managing the combat
 */
public class Combat {
private FighterManager m;
	
	public Combat(FighterManager m) {
		this.m = m;
	}
	
	/**
	 * The actual fight itself
	 * @param pair
	 * @param s
	 * @return the winner of the battle
	 */
	public String fight(FightPair pair, Scanner s) {
		//Both the fighters get appointed their variable in this fight
		Fighter f1 = pair.getF1();
		Fighter f2 = pair.getF2();
		
		
		startIni(f1, f2);
		
		//The main fighting loop, ends if one fighter is not alive
		while(f1.isAlive() && f2.isAlive()) {
			fightTick(s, f1, f2);
		}
		//determination of the winner
		String winner = winnerDet(f1, f2);
		
		MenuUi.space();
		m.resetAll(); //"Healing" the fighters
		return winner;
	}
	
	/**
	 * At the beginning of the fight, both fighters gain a random amount of Initiative
	 * @param fighters
	 */
	private void startIni(Fighter...fighters) {
		for( Fighter fighter : fighters) {
			fighter.gainIni((int)(Math.random()*50));
		}
	}
	
	/**
	 * One tick is one possibility for the fighters to attack.
	 * It starts with both of them gaining initiative equal to their speed
	 * And ends as soon as none of the fighters can attack anymore
	 * @param s
	 * @param f1
	 * @param f2
	 */
	private void fightTick(Scanner s, Fighter f1, Fighter f2) {
		
		f1.gainIni(0);
		f2.gainIni(0);
		
		while(f1.canAttack() || f2.canAttack()) {
			fightRound(s, f1, f2);
		}
	}
	
	/**
	 * A round in the classic sense: Depending on their initiative,
	 * all fighters that can attack, will attack
	 * @param s
	 * @param f1
	 * @param f2
	 */
	private void fightRound(Scanner s, Fighter f1, Fighter f2) {
		boolean running = true;
		while(running) {
			if(f1.getInitiative()>f2.getInitiative()) { //one with the highest init starts
				fightAttack(f1, f2);
				if(! f2.isAlive()) { //if attacked player dies, the fight loop ends (also the outer one in conclusion)
					running = false;
					break;
				}
			} else if(f2.getInitiative()>f1.getInitiative()) { //same thing as above with the other fighter
				fightAttack(f2, f1);
				if( ! f1.isAlive()) {
					running = false;
					break;
				}
			} else if(f2.getInitiative() == f1.getInitiative()) { //if both have the same Initiative, they parry each other
				CombatUI.parry();
				f1.loseIni((int) (Math.random()*10));
				f2.loseIni((int) (Math.random()*10));
			}
			CombatUI.currentStats(f1, f2);
			Util.enterToCon(s);
		}
	}
	
	/**
	 * A single attack and its output
	 * @param f1
	 * @param f2
	 */
	private void fightAttack(Fighter f1, Fighter f2) {
		int healthA =  f2.getHealth();
		DmgTypes type = f1.attack(f2);
		if(type == DmgTypes.MISSED) {
			CombatUI.missed(f1.getName(), f2.getName());
		} else if(type == DmgTypes.CRIT) {
			CombatUI.damage(f1.getName(), healthA-(f2.getHealth()/2), f2.getName());
			CombatUI.critical(f2.getName());
		} else {
			CombatUI.damage(f1.getName(), healthA-f2.getHealth(), f2.getName());
		}
	}
	
	/**
	 * When one fighter died and the fight is over, this determines the winner
	 * It also is responsible for making sure the fighters win is counted in the ranking
	 * @param f1
	 * @param f2
	 * @return
	 */
	private String winnerDet(Fighter f1, Fighter f2) {
		if(f1.isAlive()) {
			f1.addWin();
			return f1.getName();
		} else {
			f2.addWin();
			return f2.getName();
		}
	}
}

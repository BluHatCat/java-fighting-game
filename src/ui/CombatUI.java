package ui;

import characters.Fighter;

/**
 * Any UI during combat
 */
public class CombatUI {
	public static void damage(String attackerName, int dmg, String opponentName ) {
		System.out.println(attackerName + " dealt " + dmg + " points of damage to " + opponentName + "!");
	}
		
	public static void missed(String attackerName, String opponentName) {
		System.out.println(Visuals.paint(Colours.GREY, attackerName + " MISSED! " + opponentName + " does not take damage"));
	}
		
	public static void critical(String opponentName) {
		System.out.println(Visuals.paint(Colours.RED, "CRITICAL HIT! " + opponentName + " took double damage!"));
	}
		
	public static void parry() {
		System.out.println(Visuals.paint(Colours.GREEN, "UNBELIEVABLE! Both fighters attacked at the same time; they PARRIED each other's attacks!"));
	}
		
	public static void result(String winner) {
		System.out.println(Visuals.paint(Colours.YELLOW, winner.toUpperCase() + " WINS!"));
	}
	
	public static void currentStats(Fighter f1, Fighter f2) {
		System.out.println("CURRENT_STATS ----------");
		System.out.println(Visuals.healthBar(f1) + " " + f1.getHealth() + "/" + f1.getMaxHealth());
		System.out.println(Visuals.healthBar(f2) + " " + f2.getHealth() + "/" + f2.getMaxHealth());
		System.out.println("---------- CURRENT_STATS\n");
	}
}

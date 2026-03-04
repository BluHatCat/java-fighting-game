package characters;

import arena.DmgTypes;

/**
 * The base for every fighter-type, cannot be chosen
 */
public class Fighter {
		private String name;
		private int health;
		private int maxHealth;
		private int attack;
		private double critChance;
		private int speed;
		private int initiative;
		private int wins;

		
	//Constructors
		public Fighter(String name, int health, int attack, double critChance, int speed) {
			this.name = name;
			this.maxHealth = this.health = health;
			this.attack = attack;
			this.critChance = critChance;
			this.speed = speed;
			initiative = 0;
			wins = 0;	
		}
		
		public Fighter(String name) {
			this(name, 100, 10, 0.1, 10);
		}
	//**********	

		
	//Attack pattern	
		public DmgTypes attack(Fighter opponent) {
			loseIni(0);
			int dmg = (int) (Math.random()*attack);
			if(dmg == 0) {
				return DmgTypes.MISSED;
			} else {
				opponent.takeDamage(dmg);
				if(Math.random()<critChance) {
					opponent.takeDamage(dmg);
					return DmgTypes.CRIT;
				} else {
					return DmgTypes.NORMAL;
				}
			}
		}
	//**********

		
	//Stat management
		private void takeDamage(int amount) {
			health -= amount;
		}
		
		public void gainIni(int amount) {
			initiative += speed + amount;
		}
		
		public void loseIni(int amount) {
			initiative -= 100 + amount;
		}
		
		public void addWin() {
			wins++;
		}
		
		public void reset() {
			health = maxHealth;
			initiative = 0;
		}
	//**********

		
	//Checks
		public boolean isAlive() {
			return health>0;
		}
		
		public boolean canAttack() {
			return(initiative>= 100);
		}
	//**********
		

	//getters
		public int getWins() {
			return wins;
		}
		
		public String getName() {
			return name;
		}
		
		public int getSpeed() {
			return speed;
		}
		
		public int getInitiative() {
			return initiative;
		}
		
		public int getHealth() {
			return health;
		}
		
		public int getMaxHealth() {
			return maxHealth;
		}

}

package arena;

import characters.Fighter;
/**
 * A support-class that connects fighter-choice with the actual fight
 */
public class FightPair {
		private Fighter f1;
		private Fighter f2;
		
		public FightPair(Fighter f1, Fighter f2) {
			this.f1 = f1;
			this.f2 = f2;
		}

		public Fighter getF1() {
			return f1;
		}

		public Fighter getF2() {
			return f2;
		}

}

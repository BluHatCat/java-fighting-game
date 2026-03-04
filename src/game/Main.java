package game;

import java.util.Scanner;

/**
 * Starting the game
 */
public class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		MenuHandler game = new MenuHandler();
		boolean running = true;
		
		while(running) {
			int choice = Util.check(MenuHandler.menu(s));
			running = game.action(choice, s);
		}
		s.close();
	}
}

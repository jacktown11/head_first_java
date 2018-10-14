package Chapter6;

import java.util.*;

public class DotComBust {
	private GameHelper helper = new GameHelper();
	ArrayList<DotCom> dotComsList = new ArrayList<DotCom>();
	int numOfGuesses = 0;
	
	public static void main(String[] args) {
		DotComBust game = new DotComBust();
		game.setupGame();
		game.startPlaying();
	}
	
	public void setupGame() {
		// create 3 DotComs, save them in dotComsList
		DotCom dot1 = new DotCom();
		dot1.setName("Pets.com");
		DotCom dot2 = new DotCom();
		dot2.setName("eToys.com");
		DotCom dot3 = new DotCom();
		dot3.setName("Go2.com");
		dotComsList.add(dot1);
		dotComsList.add(dot2);
		dotComsList.add(dot3);

		// show instructions of the game
		System.out.println("Your goal is to sink all three dot coms.");
		System.out.println("Pets.com, eToys.com, Go2.com");
		System.out.println("Try to sink them in the fewest guess times");

		// place all three DotCom
		for (DotCom item : dotComsList) {
			ArrayList<String> locations = helper.placeDotCom(3);
			item.setLocationCells(locations);
		}
	}

	public void startPlaying() {
		while (!dotComsList.isEmpty()) {
			String guess = helper.getUserInput("Please guess the position:");
			checkUserGuess(guess);
		}
		finishGame();
	}

	public void checkUserGuess(String guess) {
		numOfGuesses++;
		String result = "miss";
		String name = "";
		
		for (DotCom dot : dotComsList) {	
			result = dot.checkYourself(guess);
			if (result.equals("kill")) {
				dotComsList.remove(dot);
				name = dot.getName();
				break;
			}
			if (result.equals("hit")) {
				break;
			}
		}
		System.out.println(result);
		if(result.equals("kill")) {
			System.out.println("Ouch! You sunk " + name);
		}
	}
	
	public void finishGame() {
		System.out.println("All Dot Coms are dead! Your stock is now worthless.");
		if (numOfGuesses < 18) {
			System.out.println("It only took you " + numOfGuesses + " guesses.");
			System.out.println("You got out before your options sunk");
		} else {
			System.out.println("Took you long enough. " + numOfGuesses + " guesses.");
			System.out.println("Fish are dancing with your options.");
		}
	}
}

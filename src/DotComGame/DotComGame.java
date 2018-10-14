package DotComGame;

import java.util.ArrayList;

public class DotComGame {
	private GameHelper gh = new GameHelper();
	private ArrayList<DotCom> dotComs = new ArrayList<DotCom>();
	private int numOfGuesses = 0;
	
	public static void main(String[] args) {
		DotComGame dcg = new DotComGame();
		dcg.setupGame();
		dcg.startPlay();
	}
	
	public void setupGame() {
		String[] dotNames = {"pets.com", "kids.com", "flower.com"};
		
		for(String dotName : dotNames) {
			DotCom dc = new DotCom();
			dc.setName(dotName);
			dc.setLocationCells(gh.getLocations());
			dotComs.add(dc);
		}
	}
	
	public void startPlay() {
		while(!dotComs.isEmpty()) {
			String userGuess = gh.getUserInput("Guess a position:");
			numOfGuesses++;
			for(DotCom dc : dotComs) {
				String result = dc.checkYourself(userGuess);
				if(result.equals("kill")) {
					dotComs.remove(dc);
					break;
				}
			}
		}
		finishGame();
	}
	
	public void finishGame() {
		System.out.println("It took you " + numOfGuesses + " to sunk all dotcoms");
	}	
}

package Chapter5;


public class SimpleDotComGame {
	public static void main(String[] args) {
		int numOfGuess = 0;
		GameHelper helper = new GameHelper();

		// Create a new dot and initialize its location
		SimpleDotCom dot = new SimpleDotCom();
		int start = (int) (Math.random() * 5);
		int[] locations = { start, start + 1, start + 2 };
		dot.setLocationCells(locations);

		boolean isAlive = true;
		while (isAlive) {
			String userGuess = helper.getUserInput("Enter a number:");
			String guessResult = dot.checkYourself(userGuess);
			numOfGuess++;
			if (guessResult.equals("kill")) {
				isAlive = false;
				System.out.println("You took " + numOfGuess + " guesses.");
			}
		}

	}
}

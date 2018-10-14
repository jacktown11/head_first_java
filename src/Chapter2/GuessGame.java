package Chapter2;


public class GuessGame {
	Player p1;
	Player p2;
	Player p3;
	
	public void startGame() {
		p1 = new Player();
		p2 = new Player();
		p3 = new Player();
		
		boolean isP1Right = false;
		boolean isP2Right = false;
		boolean isP3Right = false;
		boolean isFinished = false;
		
		int targetNumber = (int) Math.random() * 10;
		
		String winStr = "win";
		String loseStr = "lose";
		
		while(!isFinished) {
			p1.guess();
			p2.guess();
			p3.guess();
			isP1Right = (p1.guessNumber == targetNumber);
			isP2Right = (p2.guessNumber == targetNumber);
			isP3Right = (p3.guessNumber == targetNumber);
			
			System.out.println("p1 " + (isP1Right?winStr:loseStr));
			System.out.println("p2 " + (isP2Right?winStr:loseStr));
			System.out.println("p3 " + (isP3Right?winStr:loseStr));
			
			if(isP1Right || isP2Right || isP3Right) {
				System.out.println("We have a winner, game finished.");
				isFinished = true;
			} else {
				System.out.println("No one guessed the right answer, we'll play again.");
			}
			
			System.out.println("");
		}
		
	}
}

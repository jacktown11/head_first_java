package Chapter2;


public class Player {
	int guessNumber;
	
	public void guess() {
		guessNumber = (int) (Math.random() * 10);
		System.out.println("I am guessing " + guessNumber);
	}
}

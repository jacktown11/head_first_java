package Chapter10;


public class Player {
	static int playerCount = 0;
	private String name;
	final int a;
	
	public Player(String n) {
		a = 12;
		name = n;
		playerCount++;
	}
}

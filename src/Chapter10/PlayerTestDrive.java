package Chapter10;


public class PlayerTestDrive {
	public static void main(String[] args) {
		System.out.println(Player.playerCount);
		Player player = new Player("Bob");
		System.out.println(Player.playerCount);
	}
}

package Chapter14;

import java.io.*;
public class GameSaverTest {
	public static void main(String[] args) {
		GameCharacter one = new GameCharacter(50, "Elf", new String[] {"bow", "sword", "dust"});
		GameCharacter two = new GameCharacter(100, "Troll", new String[] {"bare hands", "big ax"});
		GameCharacter three = new GameCharacter(200, "Magician", new String[] {"spells", "invisibility"});
		
		try {
			FileOutputStream fs = new FileOutputStream("Game.ser");
			ObjectOutputStream os = new ObjectOutputStream(fs);
			os.writeObject(one);
			os.writeObject(two);
			os.writeObject(three);
			os.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		one = null;
		two = null;
		three = null;
		
		try {
			FileInputStream fs = new FileInputStream("Game.ser");
			ObjectInputStream os = new ObjectInputStream(fs);
			one = (GameCharacter) os.readObject();
			two= (GameCharacter) os.readObject();
			three = (GameCharacter) os.readObject();
			os.close();			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		System.out.println("one's type is " + one.type);
		System.out.println("two's type is " + two.type);
		System.out.println("three's type is " + three.type);		
	}
}

package DotComGame;

import java.util.ArrayList;

public class GameHelperTestDrive {
	public static void main(String[] args) {
		GameHelper gh = new GameHelper();
		
		ArrayList<String> locationCells = new ArrayList<String>();
		
		for (int i = 0; i < 10; i++) {
			System.out.println("Getting next");
			locationCells = gh.getLocations();
			for(String str : locationCells) {
				System.out.println(str);
			}	
		}
		
		System.out.println("finished.");
	}
}

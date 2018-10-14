package DotComGame;

import java.util.ArrayList;

public class DotCom {
	private ArrayList<String> locationCells;
	private String name;
	
	public String checkYourself(String userGuess) {
		String result = "miss";
		
		if (locationCells.contains(userGuess)) {
			result = "hit";
			locationCells.remove(userGuess);
			if(locationCells.isEmpty()) {
				result = "kill";
				System.out.println("You hava killed " + name);
			} else {
				System.out.println(result);		
			}
		}
		
		return result;
	}
	
	public void setLocationCells(ArrayList<String> locations) {
		locationCells = locations;
	}
	
	public void setName(String n) {
		name = n;
	}
}

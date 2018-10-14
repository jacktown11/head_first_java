package DotComGame;

import java.io.*;
import java.util.ArrayList;

public class GameHelper {
	private static final String VOCAB ="ABCDEFG";
	private ArrayList<String> usedCoords = new ArrayList<String>();
	
	public String getUserInput(String prompt) {
		String inputLine = null;
		System.out.print(prompt + " ");
		try {
			BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
			inputLine = is.readLine();
			if(inputLine.length() == 0) {
				return null;
			}
		} catch (IOException e) {
			System.out.println("IOException: " + e);
		}
		
		return inputLine;
	}
	
	public ArrayList<String> getLocations(){
		ArrayList<String> locationCells = new ArrayList<String>();
		boolean isFound = false;
		
		while(!isFound) {
			locationCells.clear();
			int x = (int) (Math.random() * 5) + 1;
			int y = (int) (Math.random() * 7);		
			boolean isVertical = Math.random() > 0.5;
			if (isVertical) {
				locationCells.add(VOCAB.substring(y, y+1) + (x-1));
				locationCells.add(VOCAB.substring(y, y+1) + x);
				locationCells.add(VOCAB.substring(y, y+1) + (x+1));
			} else {
				locationCells.add(VOCAB.substring(x-1, x) + y);
				locationCells.add(VOCAB.substring(x, x+1) + y);
				locationCells.add(VOCAB.substring(x+1, x+2) + y);
			}			
			
			isFound = true;
			for(String str : locationCells) {
				if(usedCoords.contains(str)) {
					isFound = false;
					break;
				}
			}
		}
		for(String str : locationCells) {
			usedCoords.add(str);
		}
		
		return locationCells;
	}
}

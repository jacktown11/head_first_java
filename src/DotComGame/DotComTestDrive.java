package DotComGame;

import java.util.ArrayList;

public class DotComTestDrive {
	public static void main(String[] args) {
		DotCom dc = new DotCom();
		ArrayList<String> locationCells = new ArrayList<String>();
		locationCells.add("A3");
		locationCells.add("A4");
		locationCells.add("A5");
		String guess = "A3";
		
		dc.setLocationCells(locationCells);
		String result = dc.checkYourself(guess);
		
		String testResult = "failed";
		if(result == "hit") {
			testResult = "passed";
		}
		
		System.out.println(testResult);
	}
}

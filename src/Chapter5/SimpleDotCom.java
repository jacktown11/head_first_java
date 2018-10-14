package Chapter5;


public class SimpleDotCom {
	int[] locationCells;
	int numOfHits = 0;
	
	public String checkYourself(String userGuess) {
		int guess = Integer.parseInt(userGuess);
		String result = "miss";
		
		for (int cell : locationCells) {
			if (cell == guess) {
				result = "hit";
				numOfHits++;
				break;
			}
		}
		
		if (numOfHits == locationCells.length) {
			result = "kill";
		}
		
		System.out.println(result);
		return result;
	}
	
	public void setLocationCells (int[] locations) {
		locationCells = locations;
	}
}

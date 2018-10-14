package Chapter16;

import java.util.*;
public class MapTest {
	public static void main(String[] args) {
		new MapTest().go();
	}
	public void go() {
		HashMap<String, Integer> scores = new HashMap<String, Integer>();
		scores.put("A",	10);
		scores.put("B",	60);
		scores.put("C",	40);
		
		System.out.println(scores);
		System.out.println(scores.get("B"));
		
	}
}

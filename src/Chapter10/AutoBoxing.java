package Chapter10;

import java.util.ArrayList;

public class AutoBoxing {
	public static void main(String args[]) {
		ArrayList<Object> a = new ArrayList<Object>();
		
		a.add(1);
		a.add(1.2f);
		
		System.out.println(a.get(0));
		System.out.println(a.get(1));
		
	}
}

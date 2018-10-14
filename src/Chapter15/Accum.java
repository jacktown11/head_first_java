package Chapter15;


public class Accum {
	private int counter = 0;
	private static Accum a = new Accum();

	private Accum() {}
	
	public static Accum getAccum() {
		return a;
	}
	
	public int getCount() {
		return counter;
	}
	
	public synchronized void updateCounter(int add) {
		counter += add;
	}
}

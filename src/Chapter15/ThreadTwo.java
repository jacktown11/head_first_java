package Chapter15;


public class ThreadTwo implements Runnable {
	public void run() {
		Accum a = Accum.getAccum();
		for(int x = 0; x < 99; x++) {
			try {
				Thread.sleep(50);
			}catch(Exception ex) {
				ex.printStackTrace();
			}
			a.updateCounter(1);
		}
		System.out.println("two" + a.getCount());
	}
}

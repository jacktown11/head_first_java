package Chapter15;


public class ThreadOne implements Runnable {
	public void run() {
		Accum a = Accum.getAccum();
		for(int x = 0; x < 98; x++) {
			try {
				Thread.sleep(50);
			}catch(Exception ex) {
				ex.printStackTrace();
			}
			a.updateCounter(1000);
		}
		System.out.println("one" + a.getCount());
	}
}

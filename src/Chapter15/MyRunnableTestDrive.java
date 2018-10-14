package Chapter15;


public class MyRunnableTestDrive {
	public static void main(String[] args) {
		MyRunnable job = new MyRunnable();
		Thread t = new Thread(job);
		t.start();
		for(int i = 0; i < 100; i++) {			
			System.out.println("String from main" + i);
		}
	}
}

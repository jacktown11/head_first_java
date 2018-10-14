package Chapter15;


public class TestSync implements Runnable{
	private int balance;
	public void run() {
		for(int i = 0; i < 5000; i++) {
			increment();
			System.out.println("Thread " + Thread.currentThread().getName() +" Blalance is " + balance);			
		}
	}
	public synchronized void increment() {
		int i = balance;
		balance = i + 1;
	}
}

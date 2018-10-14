package Chapter15;


public class BobAndMaryJob implements Runnable{
	private BankAccount account = new BankAccount();
	public static void main(String[] args) {
		BobAndMaryJob job = new BobAndMaryJob();
		Thread a = new Thread(job);
		Thread b = new Thread(job);
		a.setName("Bob");
		b.setName("Mary");
		a.start();
		b.start();
	}
	public void run() {
		for(int x = 0; x < 10; x++) {
			makeWithDrawal(10);
			if(account.getBalance() < 0) {
				System.out.println("Overdrawn");
			}
		}
	}
	public synchronized void makeWithDrawal(int amount) {
		if(account.getBalance() >= amount) {
			System.out.println(Thread.currentThread().getName() + " is about to withdraw.");
			try {
				System.out.println(Thread.currentThread().getName() + " is about to sleep");
				Thread.sleep(200);
			}catch(Exception ex) {
				ex.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + " woke up.");
			account.withdraw(amount);
			System.out.println(Thread.currentThread().getName() + " completes the withdrawal. " + account.getBalance() + " left in bank account.");
		}else {
			System.out.println("Sorry, Not enough for " + Thread.currentThread().getName());
		}
	}
}

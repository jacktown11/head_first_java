package Chapter15;


public class TestSyncTestDrive {
	public static void main(String[] args) {
		TestSync s = new TestSync();
		Thread a = new Thread(s);
		Thread b = new Thread(s);
		a.setName("a");
		b.setName("b");
		a.start();
		b.start();
	}
}

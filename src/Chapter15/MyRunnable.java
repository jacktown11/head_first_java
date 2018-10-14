package Chapter15;


public class MyRunnable implements Runnable{
	public void run() {
		go();
	}
	public void go() {
//		try {
//			Thread.sleep(200);
//		}catch(Exception ex) {
//			ex.printStackTrace();
//		}
		doMore();
	}
	public void doMore() {
		for(int i = 0; i < 100; i++) {			
			System.out.println("String from MyRunnable" + i);
		}
		
	}
}

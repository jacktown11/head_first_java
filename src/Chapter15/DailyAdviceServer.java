package Chapter15;

import java.io.*;
import java.net.*;
public class DailyAdviceServer {
	private String[] adviceList = {"advice 1", "advice 2", "advice 3", "advice 4", "advice 5"};
	public static void main(String[] args) {
		DailyAdviceServer server = new DailyAdviceServer();
		server.go();
	}
	
	public void go() {
		try {			
			ServerSocket ss = new ServerSocket(4242);
			
			while(true) {
				Socket server = ss.accept();
				PrintWriter writer = new PrintWriter(server.getOutputStream());
				String advice = getAdvice();
				writer.println(advice);
				writer.close();
				System.out.println(advice);
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public String getAdvice() {
		int index = (int) (Math.random() * adviceList.length);
		return adviceList[index];
	}
}

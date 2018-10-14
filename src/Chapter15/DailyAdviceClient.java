package Chapter15;

import java.io.*;
import java.net.*;
public class DailyAdviceClient {
	public static void main(String[] args) {
		DailyAdviceClient adc = new DailyAdviceClient();
		adc.go();
	}
	public void go() {
		try {
			Socket s = new Socket("127.0.0.1", 4242);
			InputStreamReader isr = new InputStreamReader(s.getInputStream());
			BufferedReader reader = new BufferedReader(isr);
			String advice = reader.readLine();
			System.out.println("Accepted advice: " + advice);
			reader.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}
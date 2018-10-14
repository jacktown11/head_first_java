package Chapter15;

import java.io.*;
import java.net.*;
import java.util.*;
public class SimpleChatServer {
	ArrayList<PrintWriter> clientOutputStreams;
	public static void main(String[] args) {
		SimpleChatServer scs = new SimpleChatServer();
		scs.go();
	}
	public void go() {
		clientOutputStreams  = new ArrayList<PrintWriter>();
		try {
			ServerSocket ss = new ServerSocket(5000);
			while(true) {
				Socket clientSocket = ss.accept();
				PrintWriter writer = new PrintWriter(clientSocket.getOutputStream());
				clientOutputStreams.add(writer);
				
				Thread t = new Thread(new ClientHandler(clientSocket));
				t.start();
				
				System.out.println("Got a connection.");
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public class ClientHandler implements Runnable{
		BufferedReader reader;
		Socket sock;
		public ClientHandler(Socket clientSocket) {
			try {
				sock = clientSocket;
				InputStreamReader isr = new InputStreamReader(sock.getInputStream());
				reader = new BufferedReader(isr);
			}catch(Exception ex) {
				ex.printStackTrace();
			}
		}
		public void run() {
			String message = null;
			try {
				while((message = reader.readLine()) != null) {
					System.out.println("server NEW: " + message);
					tellEveryone(message);
				}
			}catch(Exception ex) {
				ex.printStackTrace();
			}
			
		}
	}
	public void tellEveryone(String message) {
		Iterator it = clientOutputStreams.iterator();
		while(it.hasNext()) {
			try {
				PrintWriter writer = (PrintWriter) it.next();
				writer.println(message);
				writer.flush();
			}catch(Exception ex) {
				ex.printStackTrace();
			}
			
		}
	}
}

package Chapter15;

import java.io.*;
import java.net.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class SimpleChatClient {
	JTextArea incoming;
	JTextField outgoing;
	BufferedReader reader;
	PrintWriter writer;
	Socket sock;
	
	public static void main(String[] args) {
		SimpleChatClient server = new SimpleChatClient();
		server.go();
	}
	public void go() {
		JFrame fr = new JFrame("Simple Chat Client");
		JPanel mainPanel = new JPanel();
		
		incoming = new JTextArea(15, 50);
		incoming.setLineWrap(true);
		incoming.setWrapStyleWord(true);
		incoming.setEditable(false);
		JScrollPane qScroller = new JScrollPane(incoming);
		qScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		qScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		outgoing = new JTextField(20);
		JButton sendButton = new JButton("Send");
		sendButton.addActionListener(new SendButtonListener());
		mainPanel.add(qScroller);
		mainPanel.add(outgoing);
		mainPanel.add(sendButton);
		setUpNetworking();
		
		Thread readerThread = new Thread(new IncomingReader());
		readerThread.start();
		
		fr.getContentPane().add(BorderLayout.CENTER, mainPanel);
		fr.setSize(600, 800);
		fr.setVisible(true);
	}
	public void setUpNetworking() {
		try {
			sock = new Socket("127.0.0.1", 5000);
			writer = new PrintWriter(sock.getOutputStream());
			InputStreamReader isr = new InputStreamReader(sock.getInputStream());
			reader = new BufferedReader(isr);				
			System.out.println("Networking established");
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	public class SendButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			try {
				writer.println(outgoing.getText());
				writer.flush();		
				
			}catch(Exception ex){
				ex.printStackTrace();
			}
			outgoing.setText("");
			outgoing.requestFocus();
		}
	}
	public class IncomingReader implements Runnable{
		public void run() {
			String message = null;
			try {
				while((message = reader.readLine()) != null) {
					System.out.println("client NEW: " + message);
					incoming.append(message + "\n");
				}
			}catch(Exception ex) {
				ex.printStackTrace();
			}
		}
	}
}

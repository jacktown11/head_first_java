package Chapter15;

import java.io.*;
import java.net.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class SimpleChatClientA {
	JTextField outgoing;
	PrintWriter writer;
	Socket sock;
	
	public static void main(String[] args) {
		SimpleChatClientA serverA = new SimpleChatClientA();
		serverA.go();
	}
	public void go() {
		JFrame fr = new JFrame("Simple Chat Client");
		JPanel mainPanel = new JPanel();
		outgoing = new JTextField(20);
		JButton sendButton = new JButton("Send");
		sendButton.addActionListener(new SendButtonListener());
		mainPanel.add(outgoing);
		mainPanel.add(sendButton);
		fr.getContentPane().add(BorderLayout.CENTER, mainPanel);
		setUpNetworking();
		fr.setSize(400, 500);
		fr.setVisible(true);
	}
	public void setUpNetworking() {
		try {
			sock = new Socket("127.0.0.1", 5000);
			writer = new PrintWriter(sock.getOutputStream());
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
}

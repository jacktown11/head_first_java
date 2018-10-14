package Chapter12;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleGui3C implements ActionListener {
	JFrame frame;
	public static void main(String[] args) {
		SimpleGui3C sg3C = new SimpleGui3C();
		sg3C.go();
	}
	
	public void go() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btn = new JButton("Refresh paint");
		btn.addActionListener(this);
		frame.getContentPane().add(BorderLayout.SOUTH, btn);

		MyDrawPanel mdp = new MyDrawPanel();
		frame.getContentPane().add(BorderLayout.CENTER, mdp);
		
		frame.setSize(300, 300);
		frame.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent event) {
		frame.repaint();
	}
}

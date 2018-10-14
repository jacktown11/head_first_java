package Chapter12;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class SimpleGui1 implements ActionListener{
	JButton btn;
	public static void main(String[] args) {
		SimpleGui1 sg = new SimpleGui1();
		sg.go();
	}

	public void go() {
		JFrame frame = new JFrame();
		btn = new JButton("click me");
		btn.addActionListener(this);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(BorderLayout.SOUTH, btn);
//		JButton btn2 = new JButton("test");
//		frame.getContentPane().add(BorderLayout.CENTER, btn2);		
		frame.setSize(300, 300);
		frame.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent event) {
		btn.setText("I've been clicked.");
	}
}

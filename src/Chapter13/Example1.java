package Chapter13;

import javax.swing.*;
import java.awt.*;

public class Example1 {
	public static void main(String[] args) {
		Example1 ex1 = new Example1();
		ex1.go();
	}
	
	public void go() {
		JFrame fr = new JFrame();
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panelA = new JPanel();
		JPanel panelB = new JPanel();
		panelB.add(new JButton("button 1"));
		panelB.add(new JButton("button 2"));
		panelB.add(new JButton("button 3"));
		panelA.add(panelB);
		fr.getContentPane().add(panelA);
		fr.setSize(300, 300);
		fr.setVisible(true);
	}
	
	
}

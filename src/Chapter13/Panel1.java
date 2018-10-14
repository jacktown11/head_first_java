package Chapter13;

import javax.swing.*;
import java.awt.*;
public class Panel1 {
	public static void main(String[] args) {
		Panel1 gui = new Panel1();
		gui.go();
	}
	
	public void go() {
		JFrame fr = new JFrame();
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		panel.setBackground(Color.darkGray);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		JButton btn = new JButton("shock me");
		JButton btn2 = new JButton("biss");
		
		panel.add(btn);
		panel.add(btn2);
		fr.getContentPane().add(BorderLayout.EAST, panel);
		
		fr.setSize(300, 300);
		fr.setVisible(true);
	}
}

package Chapter13;

import javax.swing.*;
import java.awt.*;

public class Example2 {
	public static void main(String[] args) {
		Example2 gui = new Example2();
		gui.go();
	}
	
	public void go() {
		JFrame fr = new JFrame();
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JButton btn = new JButton("click me you mean it");
		Font bigFont = new Font("serial", Font.BOLD, 28);
		btn.setFont(bigFont);
		fr.getContentPane().add(BorderLayout.NORTH, btn);
		fr.setSize(300, 300);
		fr.setVisible(true);
	}
	
	
}

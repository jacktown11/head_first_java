package Chapter13;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TextAreaExample implements ActionListener{
	JTextArea text;
	public static void main(String[] args) {
		TextAreaExample ta = new TextAreaExample();
		ta.go();
	}
	public void go() {
		JFrame fr = new JFrame();
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		JButton btn = new JButton("Just click me");
		btn.addActionListener(this);
		text = new JTextArea(10, 20);
		text.setLineWrap(true);
		
		JScrollPane scroller = new JScrollPane(text);
		scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		panel.add(scroller);
		
		fr.getContentPane().add(BorderLayout.CENTER, panel);
		fr.getContentPane().add(BorderLayout.SOUTH, btn);
		
		fr.setSize(350, 300);
		fr.setVisible(true);
	}
	public void actionPerformed(ActionEvent event) {
		text.append("Clicked once more!\n");
	}
}

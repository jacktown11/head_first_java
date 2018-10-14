package Chapter12;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TwoButtons {
	JFrame frame;
	JLabel label;

	public static void main(String[] args) {
		TwoButtons tbs = new TwoButtons();
		tbs.go();
	}

	public void go() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JButton btn = new JButton("Refresh paint");
		frame.getContentPane().add(BorderLayout.SOUTH, btn);
		btn.addActionListener(new PaintListener());

		JButton btn1 = new JButton("Refresh label");
		frame.getContentPane().add(BorderLayout.EAST, btn1);
		btn1.addActionListener(new LabelListener());

		label = new JLabel("I'm label");
		frame.getContentPane().add(BorderLayout.WEST, label);

		MyDrawPanel mdp = new MyDrawPanel();
		frame.getContentPane().add(BorderLayout.CENTER, mdp);

		frame.setSize(300, 300);
		frame.setVisible(true);
	}

	class PaintListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			frame.repaint();
		}
	}

	class LabelListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			int random = (int) (Math.random() * 10);
			label.setText("String" + random);
		}
	}
}

package Chapter12;

import javax.swing.*;
import java.awt.*;
//import java.awt.event.*;

public class SimpleAnimation {
	int x = 0;
	int y = 0;

	public static void main(String[] args) {
		SimpleAnimation sa = new SimpleAnimation();
		sa.go();
	}

	public void go() {
		JFrame fr = new JFrame();
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		MyDrawPanel mdp = new MyDrawPanel();
		fr.getContentPane().add(BorderLayout.CENTER, mdp);

		fr.setSize(300, 300);
		fr.setVisible(true);

		while (x < 130) {
			x++;
			y++;
			mdp.repaint();
			try {
				Thread.sleep(50);
			} catch (Exception ex) {}
			
		}
		
	}

	class MyDrawPanel extends JPanel {
		public void paintComponent(Graphics g) {
			g.setColor(Color.white);
			g.fillRect(0, 0, this.getWidth(), this.getHeight());
			
			g.setColor(Color.ORANGE);
			g.fillOval(x, y, 100, 100);
			
		}
	}
}

package Chapter12;

import java.awt.*;
import javax.swing.*;

class MyDrawPanel extends JPanel {
	public void paintComponent(Graphics g) {
		// drawRectangle(g);
		// drawImage(g);
		// drawRandomColor(g);
		// gradientPaint(g);
		 randomGradientPaint(g);
	}

	private void drawRectangle(Graphics g) {
		g.setColor(Color.orange);
		g.fillRect(20, 50, 100, 100);
	}

	private void drawImage(Graphics g) {
		Image img = new ImageIcon("test.jpg").getImage();
		g.drawImage(img, 3, 4, this);
	}

	private void drawRandomColor(Graphics g) {
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		int red = (int) (Math.random() * 255);
		int green = (int) (Math.random() * 255);
		int blue = (int) (Math.random() * 255);
		Color randomColor = new Color(red, green, blue);
		g.setColor(randomColor);
		g.fillOval(70, 70, 100, 100);
	}

	private void gradientPaint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		GradientPaint gradient = new GradientPaint(70, 70, Color.blue, 50, 50, Color.orange);
		g2d.setPaint(gradient);
		g2d.fillOval(20, 20, 100, 100);
	}

	private void randomGradientPaint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		int red = (int) (Math.random() * 255);
		int green = (int) (Math.random() * 255);
		int blue = (int) (Math.random() * 255);
		Color startColor = new Color(red, green, blue);

		red = (int) (Math.random() * 255);
		green = (int) (Math.random() * 255);
		blue = (int) (Math.random() * 255);
		Color endColor = new Color(red, green, blue);

		GradientPaint gradient = new GradientPaint(70, 70, startColor, 50, 50, endColor);
		g2d.setPaint(gradient);
		g2d.fillOval(20, 20, 100, 100);
	}
}

package Chapter12;

import javax.swing.JFrame;

public class MyDrawPanelTestDrive {
	public static void main(String[] args) {
		JFrame fr = new JFrame();
		MyDrawPanel dp = new MyDrawPanel();
		fr.getContentPane().add(dp);
		fr.setSize(500, 500);
		fr.setVisible(true);
	}
}

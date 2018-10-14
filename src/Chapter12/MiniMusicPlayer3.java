package Chapter12;

import java.awt.*;
import javax.swing.*;
import javax.sound.midi.*;

public class MiniMusicPlayer3 {
	static JFrame fr = new JFrame("My First Music Video");
	static DrawPanel dp;

	public static void main(String[] args) {
		MiniMusicPlayer3 mmp = new MiniMusicPlayer3();
		mmp.go();
	}

	public void setUpGui() {
		dp = new DrawPanel();
		fr.setContentPane(dp);
		fr.setBounds(30, 30, 300, 300);
		fr.setVisible(true);
	}

	public void go() {
		setUpGui();
		try {
			Sequencer sqr = MidiSystem.getSequencer();
			sqr.open();
			sqr.addControllerEventListener(dp, new int[] { 127 });
			Sequence sq = new Sequence(Sequence.PPQ, 4);
			Track track = sq.createTrack();

			for (int i = 5; i < 61; i += 4) {
				track.add(MiniMusicPlayer3.makeEvent(144, 1, i, 100, i));
				track.add(MiniMusicPlayer3.makeEvent(176, 1, 127, 0, i));
				track.add(MiniMusicPlayer3.makeEvent(128, 1, i, 100, i + 2));
			}

			sqr.setSequence(sq);
			sqr.setTempoInBPM(120);
			sqr.start();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static MidiEvent makeEvent(int comd, int chan, int one, int two, int tick) {
		MidiEvent event = null;
		try {
			ShortMessage a = new ShortMessage();
			a.setMessage(comd, chan, one, two);
			event = new MidiEvent(a, tick);
		} catch (Exception ex) {
		}
		return event;
	}

	public class DrawPanel extends JPanel implements ControllerEventListener {
		boolean msg = false;

		public void paintComponent(Graphics g) {
			if (msg) {
				Graphics2D g2 = (Graphics2D) g;
				int r = (int) (Math.random() * 250);
				int gr = (int) (Math.random() * 250);
				int b = (int) (Math.random() * 250);
				g2.setColor(new Color(r, gr, b));
				int ht = (int) (Math.random() * 120 + 10);
				int width = (int) (Math.random() * 120 + 10);
				int x = (int) (Math.random() * 40 + 10);
				int y = (int) (Math.random() * 40 + 10);
				g2.fillRect(x, y, width, ht);
				msg = false;
			}
		}

		public void controlChange(ShortMessage sm) {
			msg = true;
			dp.repaint();
		}
	}

}

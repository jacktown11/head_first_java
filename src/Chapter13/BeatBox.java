package Chapter13;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.sound.midi.*;

public class BeatBox {
	JPanel mainPanel;
	ArrayList<JCheckBox> checkboxList;
	Sequencer sqr;
	Sequence sq;
	Track track;
	JFrame fr;

	String[] instrumentNames = { "Bass Drum", "Closed Hi-Hat", "Open Hi-Hat", "Acoustic Snare", "Crash Cymbal",
			"Hand Clap", "High Tom", "Hi Bango", "Maracas", "Whistle", "Low Conga", "Cowbell", "Vibraslap",
			"Low-mid Tom", "High Agogo", "Open High Conga" };
	int[] instruments = { 35, 42, 46, 38, 49, 39, 50, 60, 70, 72, 64, 56, 58, 47, 67, 63 };

	public static void main(String[] args) {
		new BeatBox().buildGUI();
	}

	public void buildGUI() {
		fr = new JFrame("Cyber BeatBox");
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		BorderLayout layout = new BorderLayout();
		JPanel background = new JPanel(layout);
		background.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		// build buttons and put them into box
		Box buttonBox = new Box(BoxLayout.Y_AXIS);

		JButton start = new JButton("Start");
		start.addActionListener(new MyStartMidiListener());
		buttonBox.add(start);

		JButton stop = new JButton("Stop");
		stop.addActionListener(new MyStopMidiListener());
		buttonBox.add(stop);

		JButton upTempo = new JButton("Tempo Up");
		upTempo.addActionListener(new MyUpTempoMidiListener());
		buttonBox.add(upTempo);

		JButton downTempo = new JButton("Tempo Down");
		downTempo.addActionListener(new MyDownTempoMidiListener());
		buttonBox.add(downTempo);

		// build labels for instrumentNames and put them into box
		Box nameBox = new Box(BoxLayout.Y_AXIS);
		for (int i = 0; i < instrumentNames.length; i++) {
			nameBox.add(new Label(instrumentNames[i]));
		}

		// build checkboxes and put them into grid
		checkboxList = new ArrayList<JCheckBox>();
		GridLayout grid = new GridLayout(16, 16);
		grid.setVgap(1);
		grid.setHgap(2);
		mainPanel = new JPanel(grid);
		for (int i = 0; i < 256; i++) {
			JCheckBox c = new JCheckBox();
			c.setSelected(false);
			checkboxList.add(c);
			mainPanel.add(c);
		}
		// locate sections
		background.add(BorderLayout.WEST, nameBox);
		background.add(BorderLayout.EAST, buttonBox);
		background.add(BorderLayout.CENTER, mainPanel);
		fr.getContentPane().add(background);

		setUpMidi();

		fr.setBounds(50, 50, 300, 300);
		fr.pack();
		fr.setVisible(true);
	}

	public void setUpMidi() {
		try {
			sqr = MidiSystem.getSequencer();
			sqr.open();
			sq = new Sequence(Sequence.PPQ, 4);
			track = sq.createTrack();
			sqr.setTempoInBPM(120);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void buildTrackAndStart() {
		int[] trackList = null;
		sq.deleteTrack(track);
		track = sq.createTrack();
		for(int i = 0; i < 16; i++) {
			trackList = new int[16];
			int key = instruments[i];
			for(int j = 0; j < 16; j++) {
				JCheckBox jc = (JCheckBox) checkboxList.get(j + 16 * i);
				if(jc.isSelected()) {
					trackList[j] = key;
				}else {
					trackList[j] = 0;
				}
				System.out.print(trackList[j]);
			}
			System.out.println("");
			makeTracks(trackList);
			track.add(makeEvent(176, 1, 127, 0, 16));
		}
		track.add(makeEvent(192, 9, 1, 0, 15));
		try {
			sqr.setSequence(sq);
			sqr.setLoopCount(Sequencer.LOOP_CONTINUOUSLY);
			sqr.start();
			sqr.setTempoInBPM(120);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	public void makeTracks(int[] list) {
		for(int i = 0; i < 16; i++) {
			int key = list[i];
			System.out.print(key);
			if(key != 0) {
				track.add(makeEvent(144, 9, key, 100, i));
				track.add(makeEvent(128, 9, key, 100, i+1));
			}
		}
		System.out.println("");
	}
	
	public MidiEvent makeEvent(int comd, int chan, int one, int two, int tick) {
		MidiEvent event = null;
		try {
			ShortMessage a = new ShortMessage();
			a.setMessage(comd, chan, one, two);
			event = new MidiEvent(a, tick);
		} catch (Exception ex) {
		}
		return event;
	}
	
	public class MyStartMidiListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			System.out.println("start");				
			buildTrackAndStart();
		}
	}

	public class MyStopMidiListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			System.out.println("stop");
			sqr.stop();
		}
	}

	public class MyUpTempoMidiListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			float tempoFactor = sqr.getTempoFactor();
			sqr.setTempoFactor((float) (tempoFactor * 1.03)); 
		}
	}

	public class MyDownTempoMidiListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			float tempoFactor = sqr.getTempoFactor();
			sqr.setTempoFactor((float) (tempoFactor * 0.97)); 
		}
	}
}

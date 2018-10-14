package Chapter12;

import javax.sound.midi.*;

public class MiniMusicPlayer1 {
	public static void main(String[] args) {
		try {
			Sequencer sqr = MidiSystem.getSequencer();
			sqr.open();
			
			Sequence sq = new Sequence(Sequence.PPQ, 4);
			Track track = sq.createTrack();
			for(int i = 5; i < 61; i+=4) {
				track.add(MiniMusicPlayer1.makeEvent(144, 1, i, 100, i));
				track.add(MiniMusicPlayer1.makeEvent(128, 1, i, 100, i + 2));
			}
			
			sqr.setSequence(sq);
			sqr.setTempoInBPM(220);
			sqr.start();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public static MidiEvent makeEvent(int comd, int chan, int one, int two, int tick) {
		MidiEvent event = null;
		try {
			ShortMessage a = new ShortMessage();
			a.setMessage(comd, chan, one, two);
			event = new MidiEvent(a, tick);
		}catch(Exception ex) {}
		return event;
	}
}

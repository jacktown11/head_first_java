package Chapter16;

import java.io.*;
import java.util.*;

public class Jukebox1 {
	ArrayList<String> songList = new ArrayList<String>();

	public static void main(String[] args) {
		new Jukebox1().go();
	}

	public void go() {
		getSongs();
		Collections.sort(songList);
		System.out.println(songList);
	}

	public void getSongs() {
		try {
			File songFile = new File("songs.txt");
			BufferedReader reader = new BufferedReader(new FileReader(songFile));
			String song;
			while ((song = reader.readLine()) != null) {
				addSong(song);
			}
			reader.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public void addSong(String strToParse) {
		String songName = strToParse.split("/")[0];
		songList.add(songName);
	}
}

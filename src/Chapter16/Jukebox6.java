package Chapter16;


// 璇ョ▼搴忔湁鐐归棶棰橈細璇诲彇鏂囦欢鏃讹紝鏈�寮�濮嬫�绘槸澶氬嚭涓�涓棤鎰忎箟鐨勫瓧绗︼紝瀵艰嚧绗竴琛岀殑鍐呭鎺掑簭閿欒

import java.io.*;
import java.util.*;

public class Jukebox6 {
	ArrayList<Song> songList = new ArrayList<Song>();

	public static void main(String[] args) {
		new Jukebox6().go();
	}

	public void go() {
		getSongs();
		System.out.println(songList);
		Collections.sort(songList, new artistCompare());
		System.out.println(songList);
		
		HashSet<Song> songSet = new HashSet<Song>();
		songSet.addAll(songList);
		System.out.println(songSet);
	}

	public class artistCompare implements Comparator<Song> {
		public int compare(Song s1, Song s2) {
			return s1.getArtist().compareTo(s2.getArtist());
		}
	}

	public void getSongs() {
		try {
			File songFile = new File("songListMore.txt");
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
		String[] parts = strToParse.split("/");
		Song s = new Song(parts[0], parts[1], parts[2], parts[3]);
		songList.add(s);
	}
}

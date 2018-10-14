package Chapter16;


// 璇ョ▼搴忔湁鐐归棶棰橈細璇诲彇鏂囦欢鏃讹紝鏈�寮�濮嬫�绘槸澶氬嚭涓�涓棤鎰忎箟鐨勫瓧绗︼紝瀵艰嚧绗竴琛岀殑鍐呭鎺掑簭閿欒

import java.io.*;
import java.util.*;

public class Jukebox3 {
	ArrayList<Song> songList = new ArrayList<Song>();

	public static void main(String[] args) {
		new Jukebox3().go();
	}

	public void go() {
		getSongs();
		System.out.println(songList);
		Collections.sort(songList);
		System.out.println(songList);
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

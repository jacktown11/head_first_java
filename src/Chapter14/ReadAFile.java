package Chapter14;

import java.io.*;
public class ReadAFile {
	public static void main(String[] args) {
		try {
			File file = new File("Foo.txt");
			FileReader fileReader = new FileReader(file);
			BufferedReader reader = new BufferedReader(fileReader);
			String line = null;
			while((line = reader.readLine()) != null) {
				System.out.println(line);
			}
			reader.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}

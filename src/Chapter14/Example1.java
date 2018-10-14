package Chapter14;

import java.io.*;

public class Example1 implements Serializable{
	int weight;
	int height;
	public static void main(String[] args) {
		Example1 ex = new Example1();
		ex.setHeight(10);
		ex.setWeight(20);
		
		try {
			FileOutputStream fos = new FileOutputStream("ex.er");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(ex);
			oos.close();
		}catch(Exception expt) {
			expt.printStackTrace();
		}
	}
	
	public void setWeight(int w) {
		weight = w;
	}
	public void setHeight(int h) {
		height = h;
	}
}

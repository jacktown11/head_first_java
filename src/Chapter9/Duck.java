package Chapter9;


public class Duck {
	int size;
	
	public Duck() {
		size = 16;
		System.out.println("The duck's size is " + size);
	}
	
	public Duck(int duckSize) {
		size = duckSize;
		System.out.println("The duck's size is " + size);
	}
}

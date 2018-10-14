package Chapter10;


public class Duck {
	int size;
	public static void main(String[] args) {
		Duck duck = new Duck();
		duck.say("in instance");
		Duck.hello("static method");
	}
	
	public static void hello(String str) {
		System.out.println("hello " + str);
	}
	
	public void say(String str) {
		System.out.println(str);
	}
	
	public int getSize() {
		return size;
	}
}

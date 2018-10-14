package Chapter4;


public class GoodDogTestDrive {
	public static void main(String[] args) {
		GoodDog one = new GoodDog();
		one.setSize(70);
		
		GoodDog two = new GoodDog();
		two.setSize(8);
		
		GoodDog three = new GoodDog();
		three.setSize(35);
		
		one.bark();
		two.bark();
		three.bark();
	}
}

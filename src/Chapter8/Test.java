package Chapter8;


public class Test {
	public static void main(String[] args) {
		Dog a = new Dog();
		a.size = 8;
		Dog a1 = new Dog();
		a1.size = 8;
		Cat b = new Cat();
		
		System.out.println(a.equals(a));
		System.out.println(b.getClass());
		System.out.println(b.hashCode());
		System.out.println(b.toString());
	}
}

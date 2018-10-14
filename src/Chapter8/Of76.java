package Chapter8;


public class Of76 extends Clowns {
	public static void main(String[] args) {
		Picasso[] i = new Picasso[3];
		i[0] = new Acts();
		i[1] = new Clowns();
		i[2] = new Of76();

		for (int x = 0; x < 3; x++) {
			System.out.println(i[x].iMethod() + " " + i[x].getClass());
		}
	}
}

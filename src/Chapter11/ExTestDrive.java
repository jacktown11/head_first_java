package Chapter11;


public class ExTestDrive {
	public static void main(String[] args) {
		String test = args[0];
		System.out.print("t");
		System.out.print("h");
		try {
			doRisky(test);			
		}catch(MyEx ex) {
			System.out.print("a");
		}finally {
			System.out.print("w");
			System.out.print("s");
		}
		
	}
	static void doRisky(String t) throws MyEx{
		if(t.equals("yes")) {
			throw new MyEx();
		}else {
			System.out.print("r");
			System.out.print("o");
		}
	}
}

package input;

public class ReadInput {
	
	public static String input() {

		String input = "";

		try {
			input = System.console().readLine();
		} catch (Exception e) {
			System.out.println("Unexpected error.");
		}
		return input;
	}
}

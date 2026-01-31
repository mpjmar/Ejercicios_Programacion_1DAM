package utils;

public class Input {
	
	public static int readInteger() {
		int n = -1;
		try {
			n = Integer.parseInt(System.console().readLine());
		} catch (NumberFormatException e) {
			System.out.println("Invalid number format. Please, enter an integer.");
		} catch (Exception e) {
			System.out.println("Unexpected error.");
		}
		return n;
	}
}

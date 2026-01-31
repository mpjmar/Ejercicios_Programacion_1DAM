package utils;

public class Validation {

	public static int validatePassword() {

		int password = -1;
		
		try {
			password = Integer.parseInt(System.console().readLine("Password: "));
		} catch (NumberFormatException e) {
			System.out.println("Your input must be an integer value.\n");
		} catch (Exception e) {
			System.out.println("Unexpected error.");
		}
		return password;
	}
}

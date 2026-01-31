import java.util.HashMap;

import utils.*;

public class App {
    public static void main(String[] args) throws Exception {

		HashMap<String, Integer> users = new HashMap<String, Integer>();

		String user = "";
		int password = -1;
		boolean correct = false;
		int tries = 3;

		users.put("user1", 1234);
		users.put("user2", 2345);
		users.put("user3", 3456);
		users.put("user4", 4567);
		users.put("user5", 5678);

		do {
			System.out.println("\nPlease, introduce your user and password: ");
			System.out.println("(" + tries-- + " tries left)");
			user = System.console().readLine("User: ");
			password = Validation.validatePassword();
			if (users.containsKey(user)) {
				if (users.get(user) == password) {
					System.out.println("\nAccess granted to the restricted area.");
					correct = true;
				}
				else
					System.out.println("Incorrect password.");
			}
			else
				System.out.println("The entered user does not exists.");
		} while (!correct && tries > 0);
		if (!correct && tries == 0)
			System.out.println("\nSorry, you don´t have access to the restricted area.");
	}
}

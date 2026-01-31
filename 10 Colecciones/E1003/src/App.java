import java.util.ArrayList;
import java.util.Collections;

import utils.Input;

public class App {
    public static void main(String[] args) throws Exception {
		
		int n;
		ArrayList<Integer> numbers = new ArrayList<Integer>();

		System.out.println("Please, insert 10 integer numbers: ");
		for (int i = 0; i < 10; i++) {
			n = Input.readInteger();
			numbers.add(n);
		}

		System.out.println(numbers);
		Collections.sort(numbers);
		System.out.println(numbers);
    }
}

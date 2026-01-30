import java.util.ArrayList;
import java.util.Collections;

import utils.*;

public class App {
    public static void main(String[] args) throws Exception {
		
		int size = Utils.random(10, 20);
		ArrayList<Integer> values = new ArrayList<Integer>();

		for (int i = 0; i < size; i++)
			values.add(i, Utils.random(0, 100));

		System.out.println("Length: " + values.size());
		System.out.println("Values: " + values);
		System.out.println("Sum: " + Utils.sum(values));
		System.out.println("AVG: " + Utils.sum(values) / values.size());
		System.out.println("MAX: " + Collections.max(values));
		System.out.println("MIN: " + Collections.min(values));
	}

}

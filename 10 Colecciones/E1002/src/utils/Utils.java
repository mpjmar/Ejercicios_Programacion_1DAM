package utils;

import java.util.ArrayList;

public class Utils {
	
	public static int random(int min, int max) {
		return (int)(Math.random() * (max - min + 1)) + min;
	}

	public static int sum(ArrayList<Integer> list) {
		int res = 0;
		for (int n : list)
			res += n;
		return res;
	}

		
}

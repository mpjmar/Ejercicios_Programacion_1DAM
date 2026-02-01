package coins;

public class Utils {
	
	private static final int[] COINS = {1, 2, 5, 10, 25, 50, 100, 200};

	public static int generateRandom(int min, int max) {
		return (int)(Math.random() * (max - min + 1)) + min;
	}

	public static int assignValue() {
		return COINS[generateRandom(0, 7)];
	}

	public static String assignSide() {
		return generateRandom(1, 2) == 1 ? "cara" : "cruz";
	}
}

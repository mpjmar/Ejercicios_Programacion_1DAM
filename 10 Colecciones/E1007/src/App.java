import java.util.ArrayList;

import coins.*;

public class App {
    public static void main(String[] args) throws Exception {

		int coins = 6;
		ArrayList<Coin> c = new ArrayList<Coin>();

		for (int i = 0; i < coins; i++) {
			System.out.print("Press INTRO to generate a new coin.");
			String foo = System.console().readLine();
			if (i == 0)
				c.add(new Coin());
			else
				c.add(new Coin(c.get(i - 1)));
			System.out.println("Generando moneda " + (i + 1));
		}
		System.out.println("\nLas monedas generadas son: \n" + c);
	}
}

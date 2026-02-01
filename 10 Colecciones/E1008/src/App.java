import java.util.ArrayList;

import cards.*;

public class App {
    public static void main(String[] args) throws Exception {
        
		int cards = 10;
		ArrayList<Card> c = new ArrayList<Card>(10);

		c.add(new Card());
		for (int i = 1; i < cards; i++) {
			Card newCard = new Card();
			if (!c.contains(newCard))
				c.add(newCard);
		}
		// System.out.println(c);

		System.out.println("\n=== CARTAS ===");
		for (Card card : c)
			System.out.println(card);
    }
}

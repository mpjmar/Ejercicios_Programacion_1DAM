import java.util.ArrayList;
import java.util.HashMap;

public class App {
    public static void main(String[] args) throws Exception {

		int points = 0;
		ArrayList<Card> cards = new ArrayList<Card>();
		HashMap<String, Integer> values = new HashMap<String, Integer>();
		values.put("as", 11);
		values.put("tres", 10);
		values.put("sota", 2);
		values.put("caballo", 3);
		values.put("rey", 4);

		for (int i = 0; i < 5; i++) {
			Card card = new Card();
			cards.add(card);
			points += values.getOrDefault(card.getFigure(), 0);
			System.out.println(card);
		}
		System.out.printf("Tienes %d puntos.%n", points);
	}
}

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        
		HashMap<String, String> dictionary = new HashMap<>();
		dictionary.put("caliente", "hot");
		dictionary.put("rojo", "red");
		dictionary.put("ardiente", "hot");
		dictionary.put("verde", "green");
		dictionary.put("agujetas", "stiff");
		dictionary.put("abrasador", "hot");
		dictionary.put("hierro", "iron");
		dictionary.put("grande", "big");

		System.out.print("Introduzca una palabra y le daré los sinónimos: ");
		String word = System.console().readLine().toLowerCase();

		do {
			ArrayList<String> synonym = new ArrayList<>();
			if (dictionary.containsKey(word)) {
				String transl = dictionary.get(word);
				for (Map.Entry<String, String> e : dictionary.entrySet()) {
					if (e.getValue().equals(transl) && !e.getKey().equals(word))
						synonym.add(e.getKey());
				}
				if (synonym.size() == 0) {
					System.out.print("No conozco sinónimos de esa palabra ¿quiere añadir alguno? (s/n): ");
					String answer = System.console().readLine().toLowerCase();
					if (answer.equals("s")) {
						System.out.printf("Introduzca un sinónimo de %s: ", word);
						String newSynonym = System.console().readLine().toLowerCase();
						dictionary.put(newSynonym, dictionary.get(word));
						System.out.println("Gracias por enseñarme nuevos sinónimos!");
					}
				}
				else {
					System.out.printf("Sinónimos de %s: ", word);
					for (String s : synonym)
						System.out.print(synonym.indexOf(s) < synonym.size() - 1 ? s + ", " : s);
					System.out.println();
				}
			}
			else {
				System.out.print("No conozco esa palabra ¿quiere añadirla al diccionario? (s/n): ");
				String answer = System.console().readLine().toLowerCase();
				if (answer.equals("s")) {
					System.out.printf("Introduzca la traducción de %s al inglés: ", word);
					String translation = System.console().readLine().toLowerCase();
					dictionary.put(word, translation);
					System.out.println("Gracias por enseñarme nuevas palabras!");
				}
			}
			System.out.print("Introduzca una palabra y le daré los sinónimos: ");
			word = System.console().readLine().toLowerCase();
		} while (!word.equals("salir"));
    }
}

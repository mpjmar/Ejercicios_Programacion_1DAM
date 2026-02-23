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
		String word = System.console().readLine();

		ArrayList<String> sinonim = new ArrayList<>();
		if (dictionary.containsKey(word)) {
			String transl = dictionary.get(word);
			for (Map.Entry<String, String> e : dictionary.entrySet()) {
				if (e.getValue().equals(transl) && !e.getKey().equals(word))
					sinonim.add(e.getKey());
			}
			if (sinonim.size() == 0)
				System.out.println("No conozco sinónimos de esa palabra.");
			else {
				System.out.printf("Sinónimos de %s: ", word);
				for (String s : sinonim)
					System.out.print(sinonim.indexOf(s) < sinonim.size() - 1 ? s + ", " : s);
				System.out.println();
			}
		}
		else
			System.out.println("No conozco esa palabra.");
    }
}

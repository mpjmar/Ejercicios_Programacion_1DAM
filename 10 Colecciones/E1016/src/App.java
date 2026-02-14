import java.util.HashMap;

public class App {
    public static void main(String[] args) throws Exception {
        
		HashMap<String, String> countries = new HashMap<String, String>();
		countries.put("España", "Madrid");
		countries.put("Francia", "Paris");
		countries.put("Portugal", "Lisboa");

		boolean finished = false;
		boolean found = false;
		do {
			System.out.print("Escribe el nombre de una país y te diré su capital: ");
			String country = System.console().readLine();
			finished = country.equals("salir");
			found = countries.containsKey(country);
			if (found)
				System.out.printf("La capital de %s es %s.%n", country, countries.get(country));
			else {
				if (!finished) {
					System.out.printf("No conozco la respuesta ¿cual es la capital de %s?: ", country);
					String capital = System.console().readLine();
					countries.put(country, capital);
					System.out.println("Gracias por enseñarme nuevas capitales.");
				}
			}
		} while (!finished);
    }
}

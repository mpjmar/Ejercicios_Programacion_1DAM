import java.util.HashMap;

public class App {
    public static void main(String[] args) throws Exception {

		HashMap<String, String> habitat = new HashMap<>();
		HashMap<String, String> diet = new HashMap<>();

		habitat.put("rana", "En los trópicos y cerca de las zonas húmedas y acuáticas.");
		habitat.put("salamandra", "Ecosistemas húmedos.");
		habitat.put("sapo", "En cualquier sitio salvo el desierto y la Antártida.");
		habitat.put("triton", "América y África.");
		habitat.put("tritón", "América y África.");
		
		diet.put("rana", "Larvas e insectos.");
		diet.put("salamandra", "Pequeños crustáceos e insectos.");
		diet.put("sapo", "Insectos, lombrices y pequeños roedores.");
		diet.put("triton", "Insectos.");
		diet.put("tritón", "Insectos.");
		
		System.out.print("Introduzca el tipo de anfibio: ");
		String type = System.console().readLine().toLowerCase();

		do {
			if (habitat.containsKey(type)) {
				System.out.println("Hábitat: " + habitat.get(type));
				System.out.println("Alimentación: " + diet.get(type));
			}
			else
				System.out.println("Ese tipo de anfibio no existe.");

			System.out.print("Introduzca el tipo de anfibio: ");
			type = System.console().readLine().toLowerCase();
		} while (!type.equals("salir"));
	}
}

import java.util.ArrayList;
import java.util.HashMap;

public class App {
    public static void main(String[] args) throws Exception {
        
		String word = "";
		String[] spanish = {"Ordenador", "Teléfono", "Internet", "Pantalla", "Teclado", "Ratón", "Programa", 
			"Aplicación", "Archivo", "Contraseña", "Red", "Correo electrónico", "Página web", "Descarga", 
			"Subir archivo", "Datos", "Seguridad", "Usuario", "Servidor", "Nube"};
		String[] english = {"Computer", "Phone", "Internet", "Screen", "Keyboard", "Mouse", "Program", "Application", 
			"File", "Password", "Network", "Email", "Website", "Download", "Upload", "Data", "Security", "User", 
			"Server", "Cloud"};
		HashMap<String, String> dictionary = new HashMap<String, String>();
		
		for (int i = 0; i < spanish.length; i++) {
			dictionary.put(spanish[i].toLowerCase(), english[i].toLowerCase());
		}
		
		ArrayList<String> chosenWords = Utils.chooseWords(spanish);
		int hits = 0;
		int misses = 0;

		System.out.println("Traduce las siguientes palabras:");
		try {
			for (int i = 0; i < chosenWords.size(); i++) {
				System.out.printf("%s: ", chosenWords.get(i));
				String translation = System.console().readLine().toLowerCase();
				if (translation.equals(dictionary.get(chosenWords.get(i).toLowerCase()))) {
					System.out.println("Correcta!");
					hits++;
				}
				else {
					System.out.println("Incorrecta.");
					misses++;
				}
			}
		} catch (Exception e) {
			System.out.println("Ha ocurrido un error inesperado.");
		}
		System.out.printf("Has obtenido %d aciertos y %d fallos!%n", hits, misses);
    }
}

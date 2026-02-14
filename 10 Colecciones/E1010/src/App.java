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

		try {
			System.out.print("¿Qué palabra quieres buscar? ");
			word = System.console().readLine().toLowerCase();
			if (dictionary.containsKey(word))
				System.out.printf("La traducción de %s es %s.%n", word, dictionary.get(word));
			else
				System.out.printf("La palabra %s no se encuentra en el diccionario.%n", word);
		} catch (Exception e) {
			System.out.println("Ha ocurrido un error inesperado.");
		}

    }
}

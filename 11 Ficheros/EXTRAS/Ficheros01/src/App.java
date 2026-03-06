import java.io.IOException;
import java.util.List;

import flamenco.GestorFlamenco;

public class App {

	/* Implementa en el main la funcionalidad para: Crear el fichero si no existe. 
	Añadir frases al ArrayList y al HashMap. Guardar el contenido en el fichero. 
	Leer y mostrar el contenido del fichero con un mensaje tipo: "Este archivo tiene X líneas de puro arte". 
	Borrar el fichero con confirmación. */
	public static void main(String[] args) throws Exception {
		try {
			GestorFlamenco gestor = new GestorFlamenco("fichero.txt");
			gestor.getArchivo().crearArchivo();
			List<String> listaFrases = gestor.getListaFrases();
	
			gestor.agregarFrase("¡Olé el arte del flamenco!");
			gestor.agregarFrase("Taconeo que hace vibrar el corazón.");
			gestor.agregarFrase("Gritos y palmas llenan la noche de duende.");
			
			System.out.println("\nListamos las frases:");
			gestor.listarFrases();
			System.out.printf("Este archivo tiene %d líneas de puro arte.%n", listaFrases.size());
	
			System.out.println("\nMapeamos las frases:");
			gestor.mapearFrases();

			gestor.getArchivo().borrarArchivo();
			
		} catch (IOException ioe) {
			System.out.println("Ha ocurrdio un error con el archivo: " + ioe.getMessage());
		}
	}
}

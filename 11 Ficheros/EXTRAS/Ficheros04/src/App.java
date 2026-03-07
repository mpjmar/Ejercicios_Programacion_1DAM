import java.io.IOException;

public class App {
    public static void main(String[] args) throws Exception {

		GestorBiblioteca biblioteca = new GestorBiblioteca("biblioteca");

		try {
			if (biblioteca.comprobarFichero("libro1.txt")) {
				biblioteca.leerFichero("libro1.txt");
				biblioteca.modificarFichero("libro1.txt", "libro", "fichero");
				biblioteca.copiarFichero("libro1.txt", "libro10.txt");
				biblioteca.renombrarFichero("libro10.txt", "nuevoLibro.txt");
				biblioteca.moverFichero("libro2.txt", "nuevoDirectorio");
				biblioteca.eliminarFichero("libro5.txt");
				biblioteca.listarFicheros();
			}
		} catch (IOException ioe) {
			System.out.println("Se ha producido un error: " + ioe.getMessage());
		}
		
	}
}

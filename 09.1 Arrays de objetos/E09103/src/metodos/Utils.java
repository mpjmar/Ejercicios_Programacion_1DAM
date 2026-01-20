package metodos;
import Excepciones.InvalidOption;

public class Utils {
	
	public static void muestraMenu() throws InvalidOption {
		System.out.println("""

				COLECCIÓN DE DISCOS
				===================
				1. Listado
				2. Nuevo disco
				3. Modificar
				4. Borrar
				5. Salir """);
	}

	static String generaCodigo() {
		String codigo = "";
		for (int i = 0; i < 4; i++)
			codigo += (char)((int)((Math.random() * (90 - 65 + 1)) + 65));
		codigo += (int)((Math.random() * 99 - 10 + 1) + 10);
		return codigo;
	}

	public static void validaOpcion (int opcion) throws InvalidOption {
		if (opcion < 1 || opcion > 5)
			throw new InvalidOption("La opción debe ser un número del 1 al 5.");
	}

	public static int buscaCodigo(Disco[] coleccion, String codigo) {
		int pos = -1;
		for (int i = 0; i < coleccion.length; i++) {
			if (coleccion[i] != null && coleccion[i].getCodigo().equals(codigo)) {
				pos = i;
				return pos;
			}
		}
		return pos;
	}

	public static int buscaPosLibre(Disco[] coleccion) {
		int pos = -1;
		for (int i = 0; i < coleccion.length; i++) {
			if (coleccion[i] == null) {
				pos = i;
				return pos;
			}
		}
		return pos;
	}
}

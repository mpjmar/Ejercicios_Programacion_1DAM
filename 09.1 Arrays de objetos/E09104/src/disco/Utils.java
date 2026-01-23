package disco;
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
				5. Salir 
				""");
	}

	public static void muestraSubmenu() throws InvalidOption {
		System.out.println("""
				
				LISTADO
				=======
				1. Completo
				2. Por autor
				3. Por género
				4. En un rango de duración
				5. Menú principal
				""");
	}

	public static String generaCodigo() {
		String codigo = "";
		for (int i = 0; i < 4; i++)
			codigo += (char)((int)((Math.random() * (90 - 65 + 1)) + 65));
		codigo += (int)((Math.random() * 99 - 10 + 1) + 10);
		return codigo;
	}

	public static boolean validaOpcion (int opcion, int min, int max) throws InvalidOption {
		if (opcion < min || opcion > max)
			throw new InvalidOption(String.format("La opción debe ser un número del %d al %d.", min, max));
		return true;
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

	public static String asignaCodigo(Disco[] coleccion) {
		String codigo = "";
		do {
			codigo = Utils.generaCodigo();
		} while (Utils.buscaCodigo(coleccion, codigo) > 0);
		return codigo;
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

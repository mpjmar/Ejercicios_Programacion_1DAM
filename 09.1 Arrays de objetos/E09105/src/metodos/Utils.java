package metodos;
import excepciones.InvalidOptionException;
import articulo.Articulo;

public class Utils {
	
	public static void mostrarMenu() {
		System.out.println("""
				
			G E S T I S I M A L
			===================
			1. Listado
			2. Alta
			3. Baja
			4. Modificación
			5. Entrada de mercancía
			6. Salida de mercancía
			7. Salir
			""");
	}

	public static void validaOpcion(int opcion, int min, int max) throws InvalidOptionException {
		if (opcion < min || opcion > max)
			throw new InvalidOptionException("Opción no válida. Por favor, seleccione una opción del menú.");
	}

	public static int buscaPosLibre(Articulo[] articulos) {
		for (int i = 0; i < articulos.length; i++) {
			if (articulos[i] == null)
				return i;
		}
		return -1;
	}

	public static int buscaArticulo(Articulo[] articulos, String codigo) {
		for (int i = 0; i < articulos.length; i++) {
			if (articulos[i] != null && articulos[i].getCodigo().equalsIgnoreCase(codigo))
				return i;
		}
		return -1;
	}

}

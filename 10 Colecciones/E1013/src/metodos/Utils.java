package metodos;
import excepciones.InvalidOptionException;

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

}

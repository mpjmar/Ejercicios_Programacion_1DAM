package excepciones;

public class InvalidOptionException extends Exception {
	
	public InvalidOptionException() {
		super("Opción no válida. Por favor, seleccione una opción del menú.");
	}

	public InvalidOptionException(String mensaje) {
		super(mensaje);
	}
}

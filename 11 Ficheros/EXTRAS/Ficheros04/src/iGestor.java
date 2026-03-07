import java.io.IOException;

public interface iGestor {
	
	public void leerFichero(String nombreLibro) throws IOException;
	public void modificarFichero(String nombreLibro, String palabraAntigua, String palabraNueva) throws IOException;
	public boolean copiarFichero(String libro1, String libro2) throws IOException;
	public boolean renombrarFichero(String libro, String nuevoNombre);
	public boolean moverFichero(String titulo, String rutaDirectorio) throws IOException;
	public boolean eliminarFichero(String nombre);
	public void listarFicheros();
}

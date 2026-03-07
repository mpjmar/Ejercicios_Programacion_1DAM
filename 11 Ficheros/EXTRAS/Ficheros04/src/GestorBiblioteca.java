import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class GestorBiblioteca implements iGestor {
	
	private File directorioLibros;
	
	public GestorBiblioteca(String rutaDirectorio) {
		this.directorioLibros = new File(rutaDirectorio);
		if (!directorioLibros.exists()) {
			directorioLibros.mkdirs();
			System.out.println("Directorio creado: " + directorioLibros.getAbsolutePath());
		}
	}

	public boolean comprobarFichero(String nombreLibro) {
		File libro = new File(directorioLibros, nombreLibro);
		if (!(libro.exists())) {
			System.out.printf("El libro %s no está disponible.%n", nombreLibro);
			return false;
		}
		return true;
	}

	public void leerFichero(String nombreLibro) throws IOException {
		File libro = new File(directorioLibros, nombreLibro);
		BufferedReader br = new BufferedReader(new FileReader(libro));
		String linea;
		while ((linea = br.readLine()) != null)
			System.out.println(linea);
		br.close();
	}

	public void modificarFichero(String nombreLibro, String palabraAntigua, String palabraNueva) throws IOException {
		File libro = new File(directorioLibros, nombreLibro);
		BufferedReader br = new BufferedReader(new FileReader(libro));
		String linea;
		String titulo = "";
		String descripcion = "";
		int numLinea = 0;

		while ((linea = br.readLine()) != null) {
			if (numLinea == 0)
				titulo = linea + "\n";
			else
				descripcion += linea.replace(palabraAntigua, palabraNueva) + "\n";
			numLinea++;
		}
		br.close();

		BufferedWriter bw = new BufferedWriter(new FileWriter(libro));
		bw.write(titulo);
		bw.write(descripcion);
		bw.close();
	}

	public boolean copiarFichero(String titulo1, String titulo2) throws IOException {
		File libro1 = new File(directorioLibros, titulo1);
		File libro2 = new File(directorioLibros, titulo2);
		BufferedReader br = new BufferedReader(new FileReader(libro1));
		BufferedWriter bw = new BufferedWriter(new FileWriter(libro2));
		String linea;

		while ((linea = br.readLine()) != null) {
			bw.write(linea);
			bw.newLine();
		}
		br.close();
		bw.close();
		return true;
	}

	public boolean renombrarFichero(String libro, String nuevoNombre) {
		File fichero = new File(directorioLibros, libro);
		File nuevo = new File(directorioLibros, nuevoNombre);
		boolean cambiado = false;

		if (fichero.exists())
			cambiado = fichero.renameTo(nuevo);
		if (!cambiado)
			System.out.println("No se ha podido cambiar el nombre al fichero.");
		return cambiado;
	}

	public boolean moverFichero(String titulo, String rutaDirectorio) throws IOException {
		File libro = new File(directorioLibros, titulo);
		File nuevoDirectorio = new File(rutaDirectorio);

		if (!libro.exists()) {
			System.out.println("El libro no se ha encontrado.");
			return false;
		}
		if (!nuevoDirectorio.exists())
			nuevoDirectorio.mkdirs();

		File libroDestino = new File(rutaDirectorio, titulo);
		boolean cambiado = false;
		if (!libroDestino.exists()) {
			//cambiado = libro.renameTo(libroDestino);
			BufferedReader br = new BufferedReader(new FileReader(libro));
			BufferedWriter bw = new BufferedWriter(new FileWriter(libroDestino));
			String linea;
			while ((linea = br.readLine()) != null) {
				bw.write(linea);
				bw.newLine();
			}
			br.close();
			bw.close();
		}
		cambiado = libroDestino.exists();
		if (cambiado)
			libro.delete();
		else
			System.out.println("No se ha podido cambiar la ubicación del libro.");
		return cambiado;
	}

	public boolean eliminarFichero(String nombre) {
		boolean borrado = false;
		File libro = new File(directorioLibros, nombre);
		if (libro.exists())
			borrado = libro.delete();
		else 
			System.out.println("El libro no existe.");
		return borrado;
	}

	public void listarFicheros() {
		String[] ficheros = new String[0];
		if (directorioLibros.exists() && directorioLibros.isDirectory()) 
			ficheros = directorioLibros.list();
		if (ficheros != null) {
			Arrays.sort(ficheros);
			System.out.println("Libros contenidos en el directorio:");
			for (String s : ficheros)
				System.out.println(s);
		}
	}
}

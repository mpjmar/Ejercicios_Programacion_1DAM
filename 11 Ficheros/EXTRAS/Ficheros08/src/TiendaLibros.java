import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TiendaLibros {
	
	ArrayList<Libro> listaLibros;
	HashMap<Integer, Libro> mapaLibros;

	public TiendaLibros() {
		listaLibros = new ArrayList<>();
		mapaLibros = new HashMap<>();
	}

	public boolean agregarLibro(Libro libro) {
		listaLibros.add(libro);
		mapaLibros.put(mapaLibros.size() + 1, libro);
		return true;
	}

	public void mostrarLibros() {
		for (Map.Entry<Integer, Libro> entry : mapaLibros.entrySet())
			System.out.println(entry.getKey() + " " + entry.getValue());
	}

	public boolean guardarEnFichero() {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("libros.txt", true));
			for (Libro l : listaLibros)
				bw.write(l.getTitulo() + ";" + l.getAutor() + ";" + l.getPrecio() + "\n");
			bw.close();
			return true;
		} catch (IOException ioe) {
			System.out.println(ioe.getMessage());
			return false;
		}
	}

	public boolean leerLibros() {
		try {
			BufferedReader br = new BufferedReader(new FileReader("libros.txt"));
			String line;
			while ((line = br.readLine()) != null) {
				String[] words = line.split(";");
				String titulo = words[0];
				String autor = words[1];
				double precio = Double.parseDouble(words[2]);
				this.agregarLibro(new Libro(titulo, autor, precio));
			}
			br.close();
			return true;
		} catch (IOException ioe) {
			System.out.println(ioe.getMessage());
			return false;
		}
	}

	public boolean borrarFichero() {
		System.out.print("¿Desea borrar el fichero \"libros.txt\"? (s/n): ");
		String respuesta = System.console().readLine().toLowerCase();
		if (respuesta.equals("s")) {
			File archivo = new File("libros.txt");
			if (archivo.delete())
				System.out.println("El archivo ha sido borrado");
			return true;
		}
		else {
			System.out.println("No se ha borrado el archivo.");
			return false;
		}
	}
}

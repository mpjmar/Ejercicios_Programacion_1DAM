package flamenco;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* Crea una clase GestorFlamenco que gestione múltiples frases de flamenco usando un ArrayList<String>. 
Debe permitir añadir frases nuevas y guardarlas en el fichero sin borrar las anteriores. 
Usa un HashMap<Integer, String> para almacenar frases con un identificador único. 
Implementa métodos para añadir, recuperar y listar las frases con su ID. */

public class GestorFlamenco {
	
	private FlamencoArchivo archivo;
	private static Integer id = 1;
	private List<String> listaFrases;
	private Map<Integer, String> mapaFrases;

	public GestorFlamenco(String archivo) {
		this.archivo = new FlamencoArchivo(archivo);
		try {
			this.listaFrases = this.archivo.leerArchivo();
		} catch (IOException ioe) {
			this.listaFrases = new ArrayList<>();
		}
		this.mapaFrases = new HashMap<>();
		for (String frase : listaFrases)
			mapaFrases.put(id++, frase);
	}

	public FlamencoArchivo getArchivo() {
		return this.archivo;
	}

	public List<String> getListaFrases() {
		return this.listaFrases;
	}

	public boolean agregarFrase(String frase) throws IOException {
		this.archivo.escribirArchivo(frase);
		this.listaFrases.add(frase);
		this.mapaFrases.put(id++, frase);
		return true;
	}

	public String recuperarFrase(Integer id) {
		/* if (mapaFrases.containsKey(id))
			return mapaFrases.get(id); */
		return mapaFrases.getOrDefault(id, "No se ha encontrado el ID");
	}

	public void listarFrases() {
		for (String frase : listaFrases)
			System.out.println(frase);
	}

	public void mapearFrases() {
		for (Map.Entry<Integer, String> entry : mapaFrases.entrySet()) {
			System.out.println("ID: " + entry.getKey() + " FRASE: " + entry.getValue());
		}
	}
}

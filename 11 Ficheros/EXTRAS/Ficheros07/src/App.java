import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {

		File documentos = new File("documentos");
		File[] archivos = documentos.listFiles();
		ArrayList<Texto> textos = new ArrayList<>();

		for (int i = 0; i < archivos.length; i++) {
			String nombreConExt = archivos[i].getName();
			String nombreSinExt = nombreConExt.substring(0, nombreConExt.length() - 4);
			String contenido = "";

			BufferedReader br = new BufferedReader(new FileReader(archivos[i]));
			String line;
			while ((line = br.readLine()) != null)
				contenido += line;

			textos.add(new Texto(nombreSinExt, contenido));
			br.close();
		}

		System.out.println("\nArchivos cargados: ");
		for (Texto t : textos)
			System.out.println("- " + t.getNombre());
		System.out.println();

		HashMap<String, ArrayList<Texto>> categorias = clasificarTextos(textos);
		for (Map.Entry<String, ArrayList<Texto>> entry : categorias.entrySet()) {
			System.out.println("Categoría: " + entry.getKey());
			for (Texto t : entry.getValue())
				System.out.println("- " + t.getNombre());
			System.out.println();
		}

		eliminarDuplicados(textos);

	}

	public static HashMap<String, ArrayList<Texto>> clasificarTextos(ArrayList<Texto> textos) {
		String[] categorias = {"importante", "revision", "borrador"};
		HashMap<String, ArrayList<Texto>> resultados = new HashMap<>();
		
		for (String s : categorias) {
			ArrayList<Texto> aparece = new ArrayList<>();
			for (Texto t : textos) {
				if (t.getContenido().contains(s))
					aparece.add(t);
				resultados.put(s, aparece);
			}
		}
		return resultados;
	}

	public static void eliminarDuplicados(ArrayList<Texto> textos) throws IOException {
		ArrayList<String> paraEliminar = new ArrayList<>();

		for (int i = 0; i < textos.size() - 1; i++) {
			for (int j = i + 1; j < textos.size(); j++) {
				if (textos.get(i).getContenido().equals(textos.get(j).getContenido()))
					paraEliminar.add(textos.get(i).getNombre());
			}
		}

		File limpios = new File("limpios");
		limpios.mkdir();
		for (Texto f : textos) {
			if (!paraEliminar.contains(f.getNombre())) {
				BufferedWriter bw = new BufferedWriter(new FileWriter("limpios/" + f.getNombre() + ".txt"));
				bw.write(f.getContenido());
				bw.close();
			}
		}

		System.out.println("Se eliminaron los siguientes archivos duplicados:");
		for (String s : paraEliminar)
			System.out.println("- " + s);
		System.out.println();

		System.out.println("Buscador genérico para \"informe\":");
		Buscador<Texto> buscador = new Buscador<>();
		ArrayList<Texto> resultado = buscador.buscar(textos, new Texto(null, "informe"));
		for (Texto t : resultado)
			System.out.println("- " + t.getNombre());
	}
}

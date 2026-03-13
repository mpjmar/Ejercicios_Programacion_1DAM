package plataforma;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import elementos.Elemento;

public class Plataforma<T extends Elemento<?>> {
	
	private ArrayList<T> listaElementos;
	private HashMap<Integer, T> mapaElementos;
	
	public Plataforma() {
		this.listaElementos = new ArrayList<>();
		this.mapaElementos = new HashMap<>();
	}

	public void agregarElemento(T elem) {
		listaElementos.add(elem);
		mapaElementos.put(mapaElementos.size(), elem);
	}

	public void mostrarElementos() {

	}

	public void guardarEnArchivo(String ruta) {

	}

	public void leerDesdeArchivo(String ruta) {

	}

	public void crearDirectorio(String ruta) {
		File directorio = new File(ruta);
		if (!directorio.exists()) {
			if (directorio.mkdirs())
				System.out.println("Se ha creado el directorio.");
			else
				System.out.println("No se ha podido crear el directorio.");
		}
		else
			System.out.println("El directorio ya existe.");
	}
}
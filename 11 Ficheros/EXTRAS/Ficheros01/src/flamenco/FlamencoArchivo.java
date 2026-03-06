package flamenco;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FlamencoArchivo implements IFlamencoArchivo {
	
	/* Crea una clase FlamencoArchivo que maneje un fichero flamenco.txt. 
	Debe tener métodos para crear el archivo, escribir en él, leerlo y borrarlo. */
	
	private String nombre;

	public FlamencoArchivo(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public boolean crearArchivo() throws IOException {
		File archivo = new File(nombre);
		if (!archivo.exists()) {
			System.out.println("Archivo creado.");
			return archivo.createNewFile();
		}
		System.out.println("El archivo ya existe.");
		return false;
	}

	@Override
	public boolean escribirArchivo(String texto) throws IOException {
		File archivo = new File(this.nombre);
		if (archivo.exists()) {
			BufferedWriter bw = new BufferedWriter(new FileWriter(nombre, true));
			bw.append(texto + "\n");
			bw.close();
			return true;
		}
		else {
			throw new IOException("El archivo no existe.");
		}
	}

	@Override
	public List<String> leerArchivo() throws IOException {
		File archivo = new File(this.nombre);
		List<String> frases = new ArrayList<>();
		
		if (archivo.exists()) {
			BufferedReader br = new BufferedReader(new FileReader(archivo));
			String linea = "";
			while ((linea = br.readLine()) != null)
				frases.add(linea);

			br.close();
			return frases;
		}
		else
			throw new IOException("El archivo no existe.");
	}

	@Override
	public boolean borrarArchivo() throws IOException {
		File archivo = new File(this.nombre);
		if (archivo.exists()) {
			System.out.printf("¿Quiere borrar el archivo %s (s/n)?: ", this.nombre);
			String respuesta = System.console().readLine().toLowerCase();
			if (respuesta.equals("s")) {
				archivo.delete();
				System.out.println("Archivo borrado.");
				return true;
			}
			return false;
		}
		else
			throw new IOException("El archivo no existe.");
	}
}

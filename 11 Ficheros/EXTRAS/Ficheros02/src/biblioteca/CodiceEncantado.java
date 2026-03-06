package biblioteca;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CodiceEncantado implements iCodice {

	private String nombre;
	private int relatosExistentes;
	
	public CodiceEncantado(String nombre) throws IOException{
		this.nombre = nombre;
		this.relatosExistentes = contarRelatos();
	}

	public int getRelatosExistentes() {
		return this.relatosExistentes;
	}

	public boolean crearCodice() throws IOException {
		File codice = new File(nombre);
		if (!codice.exists()) {
			System.out.println("Codice creado.");
			return codice.createNewFile();
		}
		System.out.println("El códice ya existe.");
		return false;
	}

	public boolean escribirRelato(String relato) throws IOException {
		File codice = new File(nombre);
		if (codice.exists()) {
			BufferedWriter fw = new BufferedWriter(new FileWriter(nombre, true));
			fw.write(relato + "\n");
			fw.close();
			relatosExistentes++;
			return true;
		}
		throw new IOException("El códice no existe.");
	}

	public String leerCodice() throws IOException {
		File codice = new File(nombre);
		String linea = "";
		String contenido = "";
		if (codice.exists()) {
			BufferedReader br = new BufferedReader(new FileReader(codice));
			while ((linea = br.readLine()) != null)
				contenido += linea + "\n";
			br.close();
			return contenido;
		}
		throw new IOException("El códice no existe.");
	}
	
	private int contarRelatos() throws IOException {
		File codice = new File(nombre);
		int relatosExistentes = 0;
		if (codice.exists()) {
			BufferedReader br = new BufferedReader(new FileReader(codice));
			while (br.readLine() != null)
				relatosExistentes++;
			br.close();
			return relatosExistentes;
		}
		return 0;
	}

	public boolean borrarCodice() throws IOException {
		File codice = new File(nombre);
		if (codice.exists()) {
			System.out.printf("¿Desea borrar el códice %s (s/n)?: ", nombre);
			String respuesta = System.console().readLine().toLowerCase();
			if (respuesta.equals("s")) {
				codice.delete();
				System.out.println("El códice ha sido eliminado.");
				return true;
			}
			return false;
		}
		throw new IOException("El códice no existe.");
	}
}

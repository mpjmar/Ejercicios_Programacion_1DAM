import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class App {
    public static void main(String[] args) throws Exception {

		String nombre = "fichero.txt";
		File fichero = new File(nombre);

		int lineas = 0;
		int palabras = 0;
		int caracteres = 0;

		try {
			BufferedReader br = new BufferedReader(new FileReader("fichero.txt"));
			String line;
			while ((line = br.readLine()) != null) {
				String[] words = line.trim().split(" ");
				lineas++;
				palabras += words.length;
				caracteres += line.length();
			}
			br.close();

			String nuevoNombre = nombre.substring(0, (nombre.length() - 4))  + "_resumen.txt";
			BufferedWriter bw = new BufferedWriter(new FileWriter(nuevoNombre));
			bw.write("Este texto tiene " + lineas + " líneas, " + palabras + " palabras y " + caracteres + " caracteres.");
			bw.close();
		} catch (FileNotFoundException fnfe) {
			System.out.println("No se ha encontrado el archivo.");
		} catch (IOException ioe) {
			System.out.println("Ha ocurrido un error: " + ioe.getMessage());
		}
	}
}

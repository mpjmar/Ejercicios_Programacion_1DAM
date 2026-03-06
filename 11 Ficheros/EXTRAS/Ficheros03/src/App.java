import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class App {
    public static void main(String[] args) throws Exception {

		File registros = new File("registros.txt");
		if (registros.exists()) {
			BufferedReader br = new BufferedReader(new FileReader(registros));
			BufferedWriter bw = new BufferedWriter(new FileWriter("procesado.txt", true));
			String linea = "";
			while ((linea = br.readLine()) != null) {
				String[] palabras = linea.split(" ");
				int edad = Integer.parseInt(palabras[8]);
				String ciudad = palabras[11];
				if (edad >= 18 && (ciudad.equals("Madrid") || ciudad.equals("Barcelona")))
					bw.write(linea + "\n");
			}
			br.close();
			bw.close();
		}
		else 
			throw new IOException("El archivo origen no existe.");
	}
}

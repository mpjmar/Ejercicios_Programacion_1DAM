import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {

		/* // Creamos el fichero
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("words.txt"));
			bw.write("Mi\ngatita\nes\nuna\npetarda\ny\nno\npara\nde\nhacer\nmiiii\n");
			bw.close();
		} catch(IOException ioe) {
			System.out.println("Se ha producido un error.");
		} */

		/* if (args.length != 1) {
			System.out.println("Uso del programa E1104: FICHERO.TXT");
			System.exit(-1);
		} */

		String file = "words.txt";

		try {
			BufferedReader bf = new BufferedReader(new FileReader(file));
	
			String name = file.substring(0, file.length() - 4);
			String ext = file.substring(file.length() - 4, file.length());
			BufferedWriter bw = new BufferedWriter(new FileWriter(name + "_sort" + ext));
			String line = "";
			List<String> words = new ArrayList<>();
	
			while ((line = bf.readLine()) != null)
				words.add(line);
			bf.close();

			Collections.sort(words);

			for(String s : words)
				bw.write(s + "\n");
			
			bw.close();
		} catch (FileNotFoundException fnfe) {
			System.out.println("Fichero no encontrado.");
		} catch (IOException ioe) {
			System.out.println("Error en la lectura/escritura del archivo.");
		}
	}
}

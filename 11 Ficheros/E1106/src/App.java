import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class App {
    public static void main(String[] args) throws Exception {

		/* if (args.length != 2) {
			System.out.println("Uso del programa E1106 FICHERO PALABRA");
			System.exit(-1);
		} */

		String word = "fichero";
		String line = "";
		int counter = 0;
		try {
			BufferedReader br = new BufferedReader(new FileReader("file.txt"));
	
			while ((line = br.readLine()) != null) {
				if (line.contains(word)) {
					String[] words = line.split("[ ,]+");
					for (String s : words)
						if (s.equals(word))
							counter++;
				}
			}
		} catch (IOException ioe) {
			System.out.println("Error de lectura/escritura.");
		}
		System.out.printf("El total de ocurrencias de %s es %d.%n", word, counter);
	}
}

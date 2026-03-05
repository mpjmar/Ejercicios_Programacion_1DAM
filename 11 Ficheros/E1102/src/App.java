import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class App {
    public static void main(String[] args) throws Exception {

		try {
			BufferedReader br = new BufferedReader(new FileReader("primos.dat"));

			String line = "";
			while ((line = br.readLine()) != null)
				System.out.print(line + " ");
			br.close();
		} catch (FileNotFoundException fnfe) {
			System.out.println("No se ha encontrado el fichero.");
		} catch (IOException ioe) {
			System.out.println("Error de lectura.");
		}
	}
}

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class App {
    public static void main(String[] args) throws Exception {

		try {
			BufferedReader bf = new BufferedReader(new FileReader("primos.dat"));
			String line = "";

			while ((line = bf.readLine()) != null)
				System.out.println(line);
			bf.close();
		} catch (FileNotFoundException fnfe) {
			System.out.println("No se ha encontrado el fichero.");
		} catch (IOException ioe) {
			System.out.println("No se puede leer el fichero.");
		}
	}
}

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class App {
    public static void main(String[] args) throws Exception {

		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("primos.dat"));

			for (int i = 1; i <= 500; i++)
				if (esPrimo(i))
					bw.write(String.valueOf(i) + "\n");
			bw.close();
		} catch (IOException ioe) {
			System.out.println("No se ha podido crear el fichero.");
		}
	}

	public static boolean esPrimo(int n) {
		if (n == 1)
			return false;
		
		for (int i = 2; i <= n / 2; i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}
}

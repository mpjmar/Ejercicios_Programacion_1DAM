import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class App {
    public static void main(String[] args) throws Exception {

		/* if (args.length != 2) {
			System.out.println("Uso del programa: E1104 PROGRAMA_ORIGINAL PROGRAMA_LIMPIO");
			System.exit(-1);
		} */

		try {
			BufferedReader br = new BufferedReader(new FileReader("source.java"));
			BufferedWriter bw = new BufferedWriter(new FileWriter("dest.java"));

			boolean isComment = false;
			String line = "";
			while ((line = br.readLine()) != null) {
				if (line.indexOf("/*") != -1)
					isComment = true;
				if (line.indexOf("//") != -1)
					continue;
				if (!isComment)
					bw.write(line + "\n");
				if (line.indexOf("*/") != -1)
					isComment = false;
			}
			br.close();
			bw.close();
		} catch (IOException ioe) {
			System.out.println("Error de lectura/escritura.");
		}

		
	}
}

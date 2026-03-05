import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class App {
    public static void main(String[] args) throws Exception {

		/* if (args.length != 3) {
			System.out.println("Uso del programa: E1103 FILE1 FILE2 RESULT");
			System.exit(-1);
		} */

		try {
			BufferedReader br1 = new BufferedReader(new FileReader("file1.txt"));
			BufferedReader br2 = new BufferedReader(new FileReader("file2.txt"));
			BufferedWriter bw = new BufferedWriter(new FileWriter("result.txt"));

			String line1 = "";
			String line2 = "";

			while ((line1 != null) || (line2 != null)) {
				if ((line1 = br1.readLine()) != null)
					bw.write(line1 + "\n");
				if ((line2 = br2.readLine()) != null)
					bw.write(line2 + "\n");
			}
			br1.close();
			br2.close();
			bw.close();
		} catch (IOException ioe) {
			System.out.println("Se ha producido un error de lectura/escitura.");
			System.err.println(ioe.getMessage());
		}


	}
}

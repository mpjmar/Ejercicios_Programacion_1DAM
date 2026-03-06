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
			String line1 = "";
			String line2 = "";
			int start = -1;

			while ((line1 = br.readLine()) != null) {
				if ((start = line1.indexOf("/*")) != -1) {
					isComment = true;
					line2 = line1.substring(0, start);
				}

				if ((start = line1.indexOf("//")) != -1) {
					isComment = true;
					line2 = line1.substring(0, start);
				}
				
				if ((start = line1.indexOf("*/")) != -1) {
					isComment = false;
					line1 = line1.substring(start + 2, line1.length());
				}
			
				if (!isComment)
					bw.write(line1 + "\n");
				else {
					if (line2.length() > 0)
						bw.write(line2 + "\n");
				}
				
				if (line1.contains("//"))
					isComment = false;

			}
			br.close();
			bw.close();
		} catch (IOException ioe) {
			System.out.println("Error de lectura/escritura.");
		}

		
	}
}

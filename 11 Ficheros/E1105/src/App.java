import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class App {
    public static void main(String[] args) throws Exception {

		if (args.length != 2) {
			System.out.println("Uso del programa E1105 PROGRAMA_ORIGINAL PROGRAMA_LIMPIO");
			System.exit(-1);
		}

		try {
			BufferedReader br = new BufferedReader(new FileReader(args[0]));
			BufferedWriter bw = new BufferedWriter(new FileWriter(args[1]));
			
			String line = "";
			boolean isComment = false;

			while ((line = br.readLine()) != null) {
				for (int i = 0; i < line.length(); i++) {
					if ((line.charAt(i) == '/' && (line.charAt(i + 1) == '/') || line.charAt(i + 1) == '*'))
						isComment = true;
					if (line.charAt(i) == '*' && line.charAt(i + 1) == '/')
						isComment = false;
					if (!isComment)
						bw.write(line.charAt(i));
				}
			}
	
			br.close();
			bw.close();

		} catch (IOException ioe) {
			System.err.println(ioe.getMessage());
		}

	}
}

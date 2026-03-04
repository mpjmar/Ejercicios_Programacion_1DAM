import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
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

		if (args.length < 1) {
			System.out.println("Uso del programa: E1104 words.txt");
			System.exit(-1);
		}

		try {
			BufferedReader bf = new BufferedReader(new FileReader(args[0]));
			int len = args[0].length();
			String name = args[0].substring(0, len - 4);
			String ext = args[0].substring(len - 4, len);

			BufferedWriter bw = new BufferedWriter(new FileWriter(name + "_sort" + ext));

			List<String> wordsList = new ArrayList<>();
			String line;

			while ((line = bf.readLine()) != null) 
				wordsList.add(line);
			bf.close();
			
			Collections.sort(wordsList);

			for (String s : wordsList)
				bw.write(s + "\n");
			bw.close();
		} catch (IOException ioe) {
			System.err.println(ioe.getMessage());
		}
	}
}

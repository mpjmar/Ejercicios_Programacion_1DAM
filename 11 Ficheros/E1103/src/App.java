import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class App {
    public static void main(String[] args) throws Exception {

		try {
			BufferedWriter bw1 = new BufferedWriter(new FileWriter("file1.txt"));
			BufferedWriter bw2 = new BufferedWriter(new FileWriter("file2.txt"));
			
			bw1.write("cero\nuno\ndos\ntres\ncuatro\ncinco\nseis\nsiete\nocho\nnueve\n");
			bw2.write("CERO\nUNO\nDOS\nTRES\nCUATRO\nCINCO\nSEIS\nSIETE\nOCHO\nNUEVE\nDIEZ\n");

			bw1.close();
			bw2.close();

			BufferedReader br1 = new BufferedReader(new FileReader("file1.txt"));
			BufferedReader br2 = new BufferedReader(new FileReader("file2.txt"));
			BufferedWriter bw3 = new BufferedWriter(new FileWriter("result.txt"));

			String line1 = "";
			String line2 = "";

			// forma 1
			while (line1 != null || line2 != null) {
				line1 = br1.readLine();
				line2 = br2.readLine();
				
				if (line1 != null)
					bw3.write(line1 + " ");
				if (line2 != null)
					bw3.write(line2 + " ");
			}

			// forma 2
			while (true) {
				line1 = br1.readLine();
				line2 = br2.readLine();

				if (line1 == null && line2 == null)
					break;

				if (line1 != null)
					bw3.write(line1 + " ");
				if (line2 != null)
					bw3.write(line2 + " ");
			}

			bw3.close();
			br1.close();
			br2.close();
			
		} catch (FileNotFoundException fnfe) {
			System.out.println("No se ha encontrado el archivo.");
		} catch (IOException ioe) {
			System.out.println("No se ha podido leer el archivo.");
		}
	}
}

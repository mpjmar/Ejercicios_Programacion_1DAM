import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {

		List<String> procesados = new ArrayList<>();
		File registros = new File("registros.txt");
		
		try {
			if (registros.exists()) {
				BufferedReader br = new BufferedReader(new FileReader(registros));
				BufferedWriter bw = new BufferedWriter(new FileWriter("procesado.txt"));
				String linea;
				int cont = 0;
	
				while ((linea = br.readLine()) != null) {
					String[] campos = linea.split("\\|");
					String nombre = campos[1].split(":")[1].trim();
					int edad = Integer.parseInt(campos[2].split(":")[1].trim());
					String ciudad = campos[3].split(":")[1].trim();
					if (edad >= 18 && (ciudad.toLowerCase().equals("madrid") || ciudad.toLowerCase().equals("barcelona"))) {
						procesados.add(nombre);
						bw.write(campos[0] + "|" + campos[1]);
						bw.newLine();
						cont++;
					}
				}
				bw.write("Total de registros procesados: " + cont);
				br.close();
				bw.close();
	
				System.out.println("Total de registros procesados: " + cont);
				System.out.println("Usuarios procesados: ");
				for (String s : procesados)
					System.out.println("- " + s);
			}
			else 
				throw new IOException("El archivo origen no existe.");
		} catch (IOException ioe) {
			System.out.println(ioe.getMessage());
		}
	}
}



import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class source {
	public static void main(String[] args) {
		for (int i = 0; i < args.length; i++) {
			System.out.print("Procesando el archivo " + args[i] + "...");
			try {
				
				File ficheroOriginal = new File(args[i]);
				File ficheroTemporal = new File(args[i] + ".tmp");
				ficheroOriginal.renameTo(ficheroTemporal);
				
				BufferedReader bf = new BufferedReader(new FileReader(args[i] + ".tmp"));
				
				BufferedWriter bw = new BufferedWriter(new FileWriter(args[i]));
				String linea = "";
				while (linea != null) {
					linea = bf.readLine();
					if (linea != null) {
						
						linea = linea.replace("\t", " ");
						bw.write(linea + "\n");
					}
				}
				bf.close();
				bw.close();
				
				ficheroTemporal.delete();
			} catch (IOException ioe) {
				System.out.println("Se ha producido un error de lectura/escritura");
				System.err.println(ioe.getMessage()); 
			}
			System.out.println("hecho");
		}
	}
}

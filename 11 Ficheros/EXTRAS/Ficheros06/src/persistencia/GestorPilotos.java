package persistencia;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import modelo.Piloto;

public class GestorPilotos {
	
	/* public void agregarPilotos(String archivo, Piloto p) throws IOException {
		BufferedWriter br = new BufferedWriter(new FileWriter(archivo, true));
		br.write(p.getNombre() + ";" + p.getEquipo() + ";" + p.getNumero() + ";" + p.getNacionallidad() + ";" + p.getPuntos());
		br.newLine();
		br.close();
	} */

	public void crearPilotos(String archivo, ArrayList<Piloto> pilotos) throws IOException {
		File archivoTxt = new File(archivo);
		BufferedReader br = new BufferedReader(new FileReader(archivo));
		String line;

		if (!(archivoTxt.exists())) {
			br.close();
			throw new FileNotFoundException("No se ha encontrado el archivo");
		}
		while ((line = br.readLine()) != null) {
			String[] datos = line.split(";");
			String nombre = datos[0];
			String equipo = datos[1];
			int numero = Integer.parseInt(datos[2]);
			String nacionalidad = datos[3];
			int puntos = Integer.parseInt(datos[4]);
			pilotos.add(new Piloto(nombre, equipo, numero, nacionalidad, puntos));
			System.out.println(line);
		}
		br.close();
	}
}

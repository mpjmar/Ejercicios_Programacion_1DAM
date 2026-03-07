package diario;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DiarioMagico implements IDiario {
	
	private File diario;

	public DiarioMagico(String fichero) throws IOException {
		this.diario = new File(fichero);
	}

	public boolean crearDiario() throws IOException {
		return diario.createNewFile();
	}

	public boolean escribirEntrada(String entrada) throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter(diario, true));
		bw.write(entrada);
		bw.newLine();
		bw.close();
		return true;
	}

	public void leerDiario() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(diario));
		List<String> entradas = new ArrayList<>();
		String linea;

		while ((linea = br.readLine()) != null)
			entradas.add(linea);
		br.close();

		System.out.printf("Elara ha escrito %d entradas en su diario mágico: %n", entradas.size());
		for (String s : entradas)
			System.out.println(s);
	}

	public boolean modificarEntrada(int indice, String nuevaEntrada) throws IOException {
		List<String> entradas = new ArrayList<>();
		BufferedReader br = new BufferedReader(new FileReader(diario));
		String linea;
		while ((linea = br.readLine()) != null)
			entradas.add(linea);
		if (indice >= 0 && indice < entradas.size()) {
			entradas.set(indice, nuevaEntrada);
			br.close();
	
			BufferedWriter bw = new BufferedWriter(new FileWriter(diario));
			for (String s : entradas) {
				bw.write(s);
				bw.newLine();
			}
			bw.close();
			return true;
		}
		else {
			System.out.println("El no existe ninguna entrada en el índice introducido.");
			br.close();
			return false;
		}
	}

	public boolean eliminarEntrada(int indice) throws IOException {
		List<String> entradas = new ArrayList<>();
		BufferedReader br = new BufferedReader(new FileReader(diario));
		String linea;
		while ((linea = br.readLine()) != null)
			entradas.add(linea);
		if (indice >= 0 && indice < entradas.size()) {
			entradas.remove(indice);
			br.close();

			BufferedWriter bw = new BufferedWriter(new FileWriter(diario));
			for (String s : entradas) {
				bw.write(s);
				bw.newLine();
			}
			bw.close();
			return true;
		}
		else {
			System.out.println("El no existe ninguna entrada en el índice introducido.");
			br.close();
			return false;
		}
	}
}

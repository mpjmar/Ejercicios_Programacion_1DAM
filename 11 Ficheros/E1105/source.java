
/**
* 5. Escribe un programa capaz de quitar los comentarios de un programa de
* Java. Se utilizaría de la siguiente manera:
* <p>
* <code>quita_commentarios PROGRAMA_ORIGINAL PROGRAMA_LIMPIO</code>
* <p>
* Por ejemplo:
* <p>
* <code>quita_comentarios hola.java holav2.java</code>
* <p>
* crea un fichero con nombre <code>holav2.java</code> que contiene el código
* de <code>hola.java</code> pero sin los comentarios.
*
* @author Luis José Sánchez
*/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Cambia los tabuladores por 2 espacios
 * 
 * @author Luis José Sánchez
 */
public class source {
	public static void main(String[] args) {
		for (int i = 0; i < args.length; i++) {
			System.out.print("Procesando el archivo " + args[i] + "...");
			try {
				// renombra el fichero añadiendo ".tmp"
				File ficheroOriginal = new File(args[i]);
				File ficheroTemporal = new File(args[i] + ".tmp");
				ficheroOriginal.renameTo(ficheroTemporal);
				// lee los datos del archivo temporal
				BufferedReader bf = new BufferedReader(new FileReader(args[i] + ".tmp"));
				// crea un fichero nuevo con el nombre original
				BufferedWriter bw = new BufferedWriter(new FileWriter(args[i]));
				String linea = "";
				while (linea != null) {
					linea = bf.readLine();
					if (linea != null) {
						// cambia el tabulador por 2 espacios
						linea = linea.replace("\t", " ");
						bw.write(linea + "\n");
					}
				}
				bf.close();
				bw.close();
				// borra el fichero temporal
				ficheroTemporal.delete();
			} catch (IOException ioe) {
				System.out.println("Se ha producido un error de lectura/escritura");
				System.err.println(ioe.getMessage());
			}
			System.out.println("hecho");
		}
	}
}
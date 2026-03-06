package biblioteca;
import java.io.IOException;

public interface iCodice {
	boolean crearCodice() throws IOException;
	boolean escribirRelato(String relato) throws IOException;
	String leerCodice() throws IOException;
	boolean borrarCodice() throws IOException;
}

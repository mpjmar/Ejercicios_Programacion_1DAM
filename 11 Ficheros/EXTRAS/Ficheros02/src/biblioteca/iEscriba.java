package biblioteca;

import java.io.IOException;

public interface iEscriba {
	boolean agregarRelato(String relato);
	String listarRelatos();
	boolean guardarRelatosEnCodice() throws IOException;
}

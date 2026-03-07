package diario;

import java.io.IOException;

public interface IDiario {
	boolean crearDiario() throws IOException;
	boolean escribirEntrada(String entrada) throws IOException;
	void leerDiario() throws IOException;
	boolean modificarEntrada(int indice, String nuevaEntrada) throws IOException;
	boolean eliminarEntrada(int indice) throws IOException;
}

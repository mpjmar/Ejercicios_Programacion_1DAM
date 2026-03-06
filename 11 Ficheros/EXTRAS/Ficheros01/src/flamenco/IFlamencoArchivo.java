package flamenco;

import java.io.IOException;
import java.util.List;

public interface IFlamencoArchivo {

	public boolean crearArchivo() throws IOException;
	public boolean escribirArchivo(String texto) throws IOException;
	public List<String> leerArchivo() throws IOException;
	public boolean borrarArchivo() throws IOException;
}


import java.util.ArrayList;

public class Buscador<T extends Texto> {
	
	public ArrayList<T> buscar(ArrayList<T> lista, T criterio) {
		ArrayList<T> resultado = new ArrayList<>();

		for (T t : lista) {
			if ((t.getNombre() != null && criterio.getNombre() != null && t.getNombre().contains(criterio.getNombre())) || 
				(t.getContenido() != null && criterio.getContenido() != null && t.getContenido().contains(criterio.getContenido())))
				resultado.add(t);
		}
		return resultado;
	}
}

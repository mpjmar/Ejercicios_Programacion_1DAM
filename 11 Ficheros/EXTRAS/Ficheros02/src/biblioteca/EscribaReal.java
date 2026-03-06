package biblioteca;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EscribaReal implements iEscriba {
	
	private CodiceEncantado codice;
	private List<String> listaRelatos;
	private Map<Integer, String> mapaRelatos;
	private int nextId;

	public EscribaReal(String nombre) throws IOException {
		this.codice = new CodiceEncantado(nombre);
		this.listaRelatos = new ArrayList<>();
		this.mapaRelatos = new HashMap<>();
		this.nextId = this.codice.getRelatosExistentes() + 1;
	}

	public CodiceEncantado getCodice() {
		return this.codice;
	}

	public boolean agregarRelato(String relato) {
		listaRelatos.add(relato);
		mapaRelatos.put(nextId++, relato);
		return true;
	}

	public String listarRelatos() {
		String relatos = "";
		if (listaRelatos.size() > 0)
			for (String relato : listaRelatos)
				relatos += relato + "\n";
		return relatos;
	}

	public boolean guardarRelatosEnCodice() throws IOException {
		this.codice.crearCodice();
		for (Map.Entry<Integer, String> entry : mapaRelatos.entrySet())
			this.codice.escribirRelato(entry.getKey() + " " + entry.getValue());
		listaRelatos.clear();
		mapaRelatos.clear();
		return true;
	}
}

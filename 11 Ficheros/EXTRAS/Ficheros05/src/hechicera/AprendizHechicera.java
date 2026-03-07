package hechicera;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import diario.DiarioMagico;

public class AprendizHechicera {
	
	List<String> entradasPendientes;
	Map<Integer, String> entradas;

	public AprendizHechicera() throws IOException {
		this.entradasPendientes = new ArrayList<>();
		this.entradas = new HashMap<>();
	}

	public boolean añadirEntrada(String entrada) throws IOException {
		entradasPendientes.add(entrada);
		entradas.put(entradas.size() + 1, entrada);
		return true;
	}

	public void listarEntradas() throws IOException {
		for (Map.Entry<Integer, String> entry : entradas.entrySet())
			System.out.println(entry);
	}

	public boolean guardarEntradasEnDiario(DiarioMagico diario) throws IOException {
		for (String s : entradasPendientes)
			diario.escribirEntrada(s);
		entradasPendientes.clear();
		return true;
	}
}

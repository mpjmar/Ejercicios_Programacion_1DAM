package modelo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Carrera {
	
	private ArrayList<Piloto> pilotos;

	public Carrera() {
		this.pilotos = new ArrayList<>();
	}

	public ArrayList<Piloto> getPilotos() {
		return pilotos;
	}

	public void agregarPiloto(Piloto p) {
		if (!(pilotos.contains(p)))
			pilotos.add(p);
		else
			System.out.println("El piloto ya existe.");
	}

	public ArrayList<Piloto> simularCarrera() {
		// int[] posiciones = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		int[] puntuaciones = {25, 18, 15, 12, 10, 8, 6, 4, 2, 1};
		
		for (int i = 0; i < puntuaciones.length; i++) {
			int nuevaPos = (int)(Math.random() * 10);
			int aux = puntuaciones[i];
			puntuaciones[i] = puntuaciones[nuevaPos];
			puntuaciones[nuevaPos] = aux;
		}

		for (int i = 0; i < pilotos.size(); i++)
			pilotos.get(i).setPuntos(puntuaciones[i]);
		Collections.sort(pilotos);

		System.out.println("Podium de esta carrera: ");
		for (int i = 0; i < 3; i++)
			System.out.println(pilotos.get(i));
		return pilotos;
	}

	public void guardarResultados(String archivo) throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));
		
		for (Piloto p : pilotos) {
			bw.write((pilotos.indexOf(p) + 1) + ";" + p.getNombre() + ";" + p.getEquipo() + ";" + p.getPuntos());
			bw.newLine();
		}
		bw.close();
	}
}

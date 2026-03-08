package modelo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import persistencia.GestorPilotos;

public class Temporada {
	
	private GestorPilotos gp;
	private ArrayList<Piloto> pilotosTemporada;
	private List<Carrera> carreras;
	private Map<Integer, ArrayList<Integer>> puntosPorPiloto;
	ArrayList<Integer> puntuaciones;

	public Temporada(String archivo) throws IOException {
		this.pilotosTemporada = new ArrayList<>();
		this.gp = new GestorPilotos();
		gp.crearPilotos(archivo, pilotosTemporada);

		this.puntosPorPiloto = new HashMap<>();
		puntuaciones = new ArrayList<>();

		this.carreras = new ArrayList<>();
		for (int i = 0; i < 5; i++)
			carreras.add(new Carrera());

		for (Carrera c : carreras) {
			for (Piloto p : pilotosTemporada)
				c.agregarPiloto(p);
			
			ArrayList<Piloto> pilotosCarrera = c.simularCarrera();
			for (Piloto pt : pilotosTemporada) {
				for (Piloto pc : pilotosCarrera) {
					if (pt.equals(pc)) {
						puntuaciones.add((Integer)pc.getPuntos());
						puntosPorPiloto.put((Integer)pt.getNumero(), puntuaciones);
						pt.setPuntos(pt.getPuntos() + pc.getPuntos());
					}
				}
			}
		}
		Collections.sort(pilotosTemporada);
		guardarResultados("resultados.txt");
	}

	private void guardarResultados(String archivo) throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));

		for (Piloto p : pilotosTemporada) {
			bw.write(p.getNombre() + ";" + p.getEquipo() + ";" + p.getNumero() + ";" + p.getNacionallidad() + ";" + p.getPuntos());
			bw.newLine();
		}
		bw.close();
	}

	public void buscarPiloto(int numero) {
		
		for (Piloto p : pilotosTemporada) {
			if (p.getNumero() == numero) {
				for (Map.Entry<Integer, ArrayList<Integer>> entry : puntosPorPiloto.entrySet()) {
					System.out.println(entry.getKey());
					for (Integer i : puntuaciones)
						System.out.println(i + " ");
				}
			}
			else
				System.out.println("El piloto con el número introducido no existe.");
		}
	}
}

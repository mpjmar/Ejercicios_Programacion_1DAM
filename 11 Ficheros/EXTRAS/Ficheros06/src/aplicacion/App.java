package aplicacion;

import java.io.FileNotFoundException;
import java.io.IOException;

import modelo.Temporada;
import persistencia.GestorPilotos;

public class App {
    public static void main(String[] args) throws Exception {

		/* Piloto p1 = new Piloto("Lewis Hamilton", "Mercedes", 44, "Reino Unido", 0);
		Piloto p2 = new Piloto("Max Verstappen", "Red Bull", 1, "Países Bajos", 0);
		Piloto p3 = new Piloto("Charles Leclerc", "Ferrari", 16, "Mónaco", 0);
		Piloto p4 = new Piloto("Lando Norris", "McLaren", 4, "Reino Unido", 0);
		Piloto p5 = new Piloto("Fernando Alonso", "Aston Martin", 14, "España", 0);
		Piloto p6 = new Piloto("Carlos Sainz", "Ferrari", 55, "España", 0);
		Piloto p7 = new Piloto("George Russell", "Mercedes", 63, "Reino Unido", 0);
		Piloto p8 = new Piloto("Sergio Pérez", "Red Bull", 11, "México", 0);
		Piloto p9 = new Piloto("Oscar Piastri", "McLaren", 81, "Australia", 0);
		Piloto p10 = new Piloto("Pierre Gasly", "Alpine", 10, "Francia", 0);

		Carrera c1 = new Carrera();
		c1.agregarPiloto(p1);
		c1.agregarPiloto(p2);
		c1.agregarPiloto(p3);
		c1.agregarPiloto(p4);
		c1.agregarPiloto(p5);
		c1.agregarPiloto(p6);
		c1.agregarPiloto(p7);
		c1.agregarPiloto(p8);
		c1.agregarPiloto(p9);
		c1.agregarPiloto(p10);

		c1.simularCarrera(); */

		GestorPilotos gp = new GestorPilotos();
		try {
			Temporada temporada = new Temporada("pilotos.txt");

		} catch (FileNotFoundException fnfe) {
			System.out.println("No se ha encontrado el archivo");
		} catch (IOException ioe) {
			System.out.println("Ha ocurrido un error: " + ioe.getMessage());
		}
	}	
}

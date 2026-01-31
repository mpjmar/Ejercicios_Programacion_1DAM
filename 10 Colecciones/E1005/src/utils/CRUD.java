package utils;

import java.util.ArrayList;

import disco.*;
import utils.*;

public class CRUD {
	
	public static void altaDisco(ArrayList<Disco> coleccion) {
		
		Disco nuevoDisco = new Disco();

		System.out.println("====== ALTA DISCO ======");

		System.out.print("Introduzca el código: ");
		nuevoDisco.setCodigo(Lectura.leerString());

		System.out.print("Introduzca el autor: ");
		nuevoDisco.setAutor(Lectura.leerString());

		System.out.print("Introduzca el tÍtulo: ");
		nuevoDisco.setTitulo(Lectura.leerString());

		System.out.print("Introduzca el género: ");
		nuevoDisco.setGenero(Lectura.leerString());

		System.out.print("Introduzca la duración: ");
		nuevoDisco.setDuracion(Lectura.leerEntero());

		if (coleccion.add(nuevoDisco))
			System.out.println("Disco añadido correctamente.");
	}

	public static void bajaDisco(ArrayList<Disco> coleccion) {
		
		int opcion = -1;
		int initSize = coleccion.size();

		System.out.println("====== BAJA DISCO ======");

			opcion = Utils.mostrarMenuBusq();

			if (opcion == 1) {
				System.out.print("Introduzca el código del disco: ");
				String codigo = Lectura.leerString();
				coleccion.removeIf(disco -> disco.getCodigo().equals(codigo));
			}
			else if (opcion == 2) {
				System.out.print("Introduzca el título del disco: ");
				String titulo = Lectura.leerString();
				coleccion.removeIf(disco -> disco.getTitulo().equals(titulo));
			}
			else
				System.out.println("Opción incorrecta.");

		int finalSize = coleccion.size();
		System.out.println(initSize == finalSize ? "El disco no se ha encontrado." : "Disco borrado.");
	}

	public static void listarDiscos(ArrayList<Disco> coleccion) {

		System.out.println("====== LISTAR DISCOS ======");
		System.out.println(coleccion);
	}

	public static void modificarDisco(ArrayList<Disco> coleccion) {
		
		int opcion = Utils.mostrarMenuBusq();
		int idx = -1;
		Disco disco;

		System.out.println("====== MODIFICAR DISCO ======");

		System.out.printf("Introduzca el %s del disco: ", opcion == 1 ? "código" : "título");
		String busqueda = Lectura.leerString();

		if (opcion == 1) {
			disco = new Disco(busqueda, "", "", "", 0);
			idx = coleccion.indexOf(disco);
		}
		else if (opcion == 2) {
			disco = new Disco("", "", busqueda, "", 0);
			idx = coleccion.indexOf(disco);
		}

		if (idx < 0)
			System.out.println("No se ha encontrado el disco.");
		else {
			System.out.print("Introduzca el nuevo código (o INTRO): ");
			String nuevoCodigo = Lectura.leerString();
			if (!nuevoCodigo.equals("")) {
				coleccion.get(idx).setCodigo(nuevoCodigo);
				System.out.println("Código modificado.");
			}

			System.out.print("Introduzca el nuevo autor (o INTRO): ");
			String nuevoAutor = Lectura.leerString();
			if (!nuevoAutor.equals("")) {
				coleccion.get(idx).setAutor(nuevoAutor);
				System.out.println("Autor modificado.");
			}

			System.out.print("Introduzca el nuevo título (o INTRO): ");
			String nuevoTitulo = Lectura.leerString();
			if (!nuevoTitulo.equals("")) {
				coleccion.get(idx).setTitulo(nuevoTitulo);
				System.out.println("Título modificada.");
			}

			System.out.print("Introduzca el nuevo género (o INTRO): ");
			String nuevoGenero = Lectura.leerString();
			if (!nuevoGenero.equals("")) {
				coleccion.get(idx).setGenero(nuevoGenero);
				System.out.println("Género modificado.");

			}

			System.out.print("Introduzca la nueva duración (o INTRO): ");
			String nuevaDuracion = Lectura.leerString();
			if (!nuevaDuracion.equals("") && Lectura.stringToInt(nuevaDuracion) != -1) {
				coleccion.get(idx).setDuracion(Lectura.stringToInt(nuevaDuracion));
				System.out.println("Duración modificada.");
			}
		}
	}
}

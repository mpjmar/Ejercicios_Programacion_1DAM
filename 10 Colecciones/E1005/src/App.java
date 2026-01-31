import java.util.ArrayList;

import disco.*;
import utils.*;

public class App {
    public static void main(String[] args) throws Exception {

		ArrayList<Disco> coleccion = new ArrayList<Disco>();
		int opcion = -1;

		coleccion.add(new Disco("ELEC01", "Plastikman", "Musik", "Electrónica", 120));
		coleccion.add(new Disco("ROCK01", "Placebo", "Sleeping with ghosts", "Rock", 110));
		coleccion.add(new Disco("ROCK02", "Royal Blood", "Back to the water below", "Rock", 89));
		coleccion.add(new Disco("EXPER01", "Alva Noto", "Xerrox", "Experimental", 74));

		do {
			opcion = Utils.mostrarMenuPrincipal();
			switch (opcion) {
				case 1:
					CRUD.listarDiscos(coleccion);
					break;
				case 2:
					CRUD.altaDisco(coleccion);
					break;
				case 3:
					CRUD.bajaDisco(coleccion);
					break;
				case 4:
					CRUD.modificarDisco(coleccion);
					break;
				default:
					break;
			}
		} while (opcion != 5);
	}
}

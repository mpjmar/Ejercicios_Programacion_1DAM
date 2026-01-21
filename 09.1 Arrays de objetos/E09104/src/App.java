import metodos.Utils;
import Excepciones.InvalidOption;
import metodos.Disco;
import metodos.GestorColeccion;

public class App {
    public static void main(String[] args) throws Exception {
		
		boolean correcto = false;
		boolean subCorrecto = false;
		int opcion = -1;
		int opcionSub = -1;
		Disco[] coleccion = new Disco[100];
		GestorColeccion.agregaEjemplo(coleccion, "Them Crooked Vultures", "New Fang", "Rock", 20);
		GestorColeccion.agregaEjemplo(coleccion, "Queens of the Stone Age", "Lullabies To Paralize", "Stoner rock", 110);
		GestorColeccion.agregaEjemplo(coleccion, "Placebo", "Meds", "Rock", 95);
		do {
			try {
				Utils.muestraMenu();
				opcion = Integer.parseInt(System.console().readLine("Introduzca una opción: "));
				correcto = Utils.validaOpcion(opcion, 1, 5);
				switch (opcion) {
					case 1:
						do {
							try {
								Utils.muestraSubmenu();
								opcionSub = Integer.parseInt(System.console().readLine("Introduzca una opción: "));
								subCorrecto = Utils.validaOpcion(opcionSub, 1, 5);
								switch (opcionSub) {
									case 1:
										GestorColeccion.muestraColeccion(coleccion);
										break;
									case 2:
										System.out.print("Introduzca el autor: ");
										String autor = System.console().readLine();
										GestorColeccion.muestraColeccion(coleccion, "autor", autor);
										break;
									case 3:
										System.out.print("Introduzca el género: ");
										String genero = System.console().readLine();
										GestorColeccion.muestraColeccion(coleccion, "genero", genero);
										break;
									case 4 :
										System.out.print("Establezca el intervalo para la duración");
										int min = Integer.parseInt(System.console().readLine("Límite inferior de duración en minutos: "));
										int max = Integer.parseInt(System.console().readLine("Límite superior de duración en minutos: "));
										GestorColeccion.muestraColeccion(coleccion, min, max);
										break;
									default:
										break;
								}
							} catch (NumberFormatException e) {
								System.out.println("El número debe ser un entero.");
							} catch (InvalidOption e) {
								System.out.println(e.getMessage());
							}
						} while (!subCorrecto);
						
						break;
					case 2:
						GestorColeccion.agregaDisco(coleccion);
						break;
					case 3:
						GestorColeccion.modificaDisco(coleccion);
						break;
					case 4:
						GestorColeccion.borraDisco(coleccion);
						break;
					default:
						break;
				}
			} catch (NumberFormatException e) {
				System.out.println("El número debe ser un entero.");
			} catch (InvalidOption e) {
				System.out.println(e.getMessage());
			}
		} while (opcion != 5 || !correcto);
    }
}
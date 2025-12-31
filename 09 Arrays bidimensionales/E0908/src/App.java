import funciones.Utils;

public class App {
    public static void main(String[] args) throws Exception {
		boolean correcto = false;
		String posicion = "";
		int[][] tablero = new int[8][8];
		Utils.muestraTablero(tablero);
		do {
			try {
				System.out.print("Introduzca la posición del álfil (por ejemplo, d5): ");
				posicion = System.console().readLine();
				correcto = Utils.validaPosicion(posicion);
				if (!correcto) System.out.println("La posición introducida no es correcta.");
			} catch (Exception e) {
				System.out.println("Ha ocurrido un error inesperado.");
			}
		} while (!correcto);

		System.out.println("El álfil  puede moverse a las siguientes posiciones: ");
		Utils.muestraSolucion(Utils.calculaPosiciones(tablero, posicion));
	}
}

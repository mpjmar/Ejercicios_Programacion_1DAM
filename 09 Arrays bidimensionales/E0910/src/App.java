import funciones.Utils;

public class App {
    public static void main(String[] args) throws Exception {
		int[][] tablero = new int[3][3];
		String entrada = "";
		boolean terminada = false, valida = false, turnoJugador = false;

		Utils.muestraMatriz(tablero);
		Utils.muestraTablero(tablero);
		do {
			turnoJugador = !turnoJugador;
			if (turnoJugador) {
				try {
					do {
						System.out.print("Introduzca las coordenadas, por ejemplo b2: ");
						entrada = System.console().readLine().toLowerCase();
						valida = Utils.validaEntrada(entrada);
						if (!valida) System.out.println("Coordenadas incorrectas.");
					} while (!valida);
				} catch (NumberFormatException e) {
					System.out.println("El número debe ser un entero.");
				} catch (Exception e) {
					System.out.println("Ha ocurrido un error inesperado.");
				}
			}
			terminada = Utils.modificaTablero(tablero, entrada, turnoJugador);
			Utils.muestraMatriz(tablero);
			Utils.muestraTablero(tablero);
		} while (!terminada);
	}
}

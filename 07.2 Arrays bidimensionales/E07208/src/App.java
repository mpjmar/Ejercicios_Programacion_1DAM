import funciones.Utils;

public class App {
    public static void main(String[] args) throws Exception {
		
		int[][] tablero = new int[8][8];
		Utils.muestraTablero(tablero);
		String posicion = Utils.pidePosicion();
		int[][] resultados = Utils.calculaPosiciones(tablero, posicion);
		Utils.muestraSolucion(tablero, resultados, posicion);
	}
}

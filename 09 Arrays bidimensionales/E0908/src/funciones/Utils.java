package funciones;

public class Utils {

	public static boolean validaPosicion(String pos) {
		boolean correcta = false;
		correcta = pos.charAt(0) >= 'a' && pos.charAt(0) <= 'h';
		correcta = pos.charAt(1) >= 49 && pos.charAt(1) <= 56;
		return correcta;
	}

	public static void muestraTablero(int[][] tablero) {
		String borde = "▓▓";
		String negra = "  ", blanca = "\033[47m  \033[0m";
		String alfilB = "♗", alfilN = "♝", punto = "•";
		boolean esBlanca = true;
		int fila = 8;
		muestraLetras(tablero);
		System.out.println("  " + borde.repeat(tablero.length + 2));
		for (int i = 0; i < tablero.length; i++) {
			System.out.print(fila + " " + borde);
			esBlanca = !esBlanca;
			for (int j = 0; j < tablero[i].length; j++) {
				System.out.print(esBlanca ? blanca : negra);
				esBlanca = !esBlanca;
			}
			System.out.println(borde + " " + fila--);
		}
		System.out.println("  " + borde.repeat(tablero.length + 2));
		muestraLetras(tablero);
	}

	public static void muestraLetras(int[][] tablero) {
		char c = 'a';
		System.out.print("   ");
		for (int i = 0; i < tablero.length; i++) {
			System.out.printf(" %s", c++);
		}
		System.out.println();
	}

	public static String[] calculaPosiciones(int[][] tablero, String pos) {
		int filas = tablero.length;
		int fila = volteaFilas(filas, (int)(pos.charAt(1)) - 48);
		int col = (int)(pos.charAt(0)) - 97;
		int posicion = 0;
		String[] solucion = new String[16];
		for (int i = 0; i < tablero.length; i++)
			for (int j = 0; j < tablero[i].length; j++)
				if (Math.abs(fila - i) == Math.abs(col - j) && (fila != i && col != j))
					solucion[posicion++] = convierteAString(j, i, filas);
		return solucion;
	}

	public static int volteaFilas(int filas, int fila) {
		return filas - fila;
	}

	public static String convierteAString(int i, int j, int filas) {
		char fila = (char)(volteaFilas(filas, j) + 48);
		char col = (char)(i + 97);
		String sol = "" + col + fila;
		return sol;
	}

	public static void muestraSolucion(String[] solucion) {
		for (int i = 0; i < solucion.length && solucion[i] != null; i++)
			System.out.print(solucion[i] + " ");
		System.out.println();
	}
}

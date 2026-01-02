package funciones;

public class Utils {

	public static String pidePosicion() {
		boolean correcto = false;
		String posicion = "";
		do {
			try {
				System.out.print("Introduzca la posición del álfil (por ejemplo, d5): ");
				posicion = System.console().readLine();
				correcto = validaPosicion(posicion);
				if (!correcto) System.out.println("La posición introducida no es correcta.");
			} catch (Exception e) {
				System.out.println("Ha ocurrido un error inesperado.");
			}
		} while (!correcto);
		return posicion;
	}

	public static boolean validaPosicion(String pos) {
		boolean correcta = false;
		correcta = pos.charAt(0) >= 'a' && pos.charAt(0) <= 'h';
		correcta = pos.charAt(1) >= 49 && pos.charAt(1) <= 56;
		return correcta;
	}

	public static void muestraTablero(int[][] tablero) {
		String borde = "▓▓";
		String negra = "  ", blanca = "\033[47m  \033[0m";
		boolean esBlanca = true;
		int fila = 8;
		muestraLetras(tablero);
		muestraBorde(tablero);
		for (int i = 0; i < tablero.length; i++) {
			System.out.print(fila + " " + borde);
			esBlanca = !esBlanca;
			for (int j = 0; j < tablero[i].length; j++) {
				System.out.print(esBlanca ? blanca : negra);
				esBlanca = !esBlanca;
			}
			System.out.println(borde + " " + fila--);
		}
		muestraBorde(tablero);
		muestraLetras(tablero);
		System.out.println();
	}

	public static void muestraLetras(int[][] tablero) {
		char c = 'a';
		System.out.print("    ");
		for (int i = 0; i < tablero.length; i++) {
			System.out.printf(" %s", c++);
		}
		System.out.println();
	}

	public static int[][] calculaPosiciones(int[][] tablero, String pos) {
		int[] coord = convierteACoord(pos);
		int fila = coord[0];
		int col = coord[1];
		int posicion = 0;
		int[][] resultados = new int[16][2];
		incializaResultados(resultados);
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[i].length; j++) {
				if (Math.abs(fila - i) == Math.abs(col - j) && (fila != i && col != j)) {
					resultados[posicion][0] = i;
					resultados[posicion++][1] = j;
				}
			}
		}
		return resultados;
	}

	public static void incializaResultados(int[][] coordenadas) {
		for (int i = 0; i < coordenadas.length; i++)
			for (int j = 0; j < coordenadas[i].length; j++)
				coordenadas[i][j] = -1;
	}

	public static void pintaPosiciones(int[][] tablero, int[][] resultados, String pos) {
		String borde = "▓▓";
		boolean esBlanca = true;
		int fila = 8;

		muestraLetras(tablero);
		muestraBorde(tablero);
		for (int i = 0; i < tablero.length; i++) {
			esBlanca = !esBlanca;
			System.out.print(fila + " " + borde);
			pintaFila(resultados, i, esBlanca, pos);
			System.out.println(borde + " " + fila--);
		}
		muestraBorde(tablero);
		muestraLetras(tablero);
		System.out.println();
	}

	public static void muestraBorde(int[][] tablero) {
		String borde = "▓▓";
		System.out.println("  " + borde.repeat(tablero.length + 2));
	}

	public static void pintaFila(int[][] resultados, int fila, boolean esBlanca, String pos) {
		String negra = "  ", blanca = "\033[47m  \033[0m";
		String alfilN = "\033[47m\033[30m ♗\033[0m", alfilB = " ♝";
		String puntoB = " •", puntoN = "\033[47m\033[30m •\033[0m";
		int[] posicion = convierteACoord(pos);
		for (int col = 0; col < 8; col++) {
			boolean pintada = false;
			int posiciones = 0;
			while (posiciones < resultados.length) {
				if ((fila == posicion[0] && col == posicion[1]) && esBlanca) {
					System.out.print(alfilN);
					pintada = true;
					break;
				}
				else if ((fila == posicion[0] && col == posicion[1]) && !esBlanca) {
					System.out.print(alfilB);
					pintada = true;
					break;
				}
				else if ((fila == resultados[posiciones][0] && col == resultados[posiciones][1]) && esBlanca) {
					System.out.print(puntoN);
					pintada = true;
					break;
				}
				else if ((fila == resultados[posiciones][0] && col == resultados[posiciones][1]) && !esBlanca) {
					System.out.print(puntoB);
					pintada = true;
					break;
				}
				else {
					posiciones++;
				}
			}
			if (!pintada)
				System.out.print(esBlanca ? blanca : negra);
			esBlanca = !esBlanca;
		}
	}

	public static int[] convierteACoord(String pos) {
		int[] coord = new int[2];
		int filas = 8;
		coord[0] = volteaFilas(filas, (int)(pos.charAt(1)) - 48);
		coord[1] = (int)(pos.charAt(0)) - 97;
		return coord;
	}

	public static int volteaFilas(int filas, int fila) {
		return filas - fila;
	}

	public static String convierteAString(int[] resultados) {
		int filas = 8;
		char fila = (char)(volteaFilas(filas, resultados[0]) + 48);
		char col = (char)(resultados[1] + 97);
		String sol = "" + col + fila;
		return sol;
	}

	public static void muestraSolucion(int[][] tablero, int[][] resultados, String pos) {
		pintaPosiciones(tablero, resultados, pos);
		String[] soluciones = new String[16];
		for (int i = 0; i < resultados.length && resultados[i][0] >= 0; i++)
			soluciones[i] = convierteAString(resultados[i]);
		System.out.println("El álfil puede moverse a las siguientes posiciones: ");
		for (int i = 0; i < soluciones.length && soluciones[i] != null; i++)
			System.out.print(soluciones[i] + " ");
		System.out.println();
	}
}

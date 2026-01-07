package funciones;

public class Utils {
	public static boolean modificaTablero(int[][] tablero, String entrada) throws InterruptedException {
		boolean terminada = false;
		int[] coord = pasaACoord(entrada);
		boolean vacia = true;
		int jugador = 1, ordenador = 2, huecos = 9;

		vacia = tablero[coord[0]][coord[1]] == 0;
		if (vacia) {
			tablero[coord[0]][coord[1]] = 1;
			muestraTablero(tablero);
			terminada = compruebaJugada(tablero, jugador);
			if (huecos > 0 && terminada) {
				System.out.println("El jugador ha ganado la partida.");
				return true;
			}
			huecos--;
		}
		else
			System.out.println("La posicion está ya ocupada. Pierdes el turno.");
		
		Thread.sleep(1000);
		
		if (!terminada) {
			juegaMaquina(tablero);
			huecos--;
			muestraTablero(tablero);
		}
		terminada = compruebaJugada(tablero, ordenador);
		if (huecos > 0 && terminada) {
			System.out.println("El ordenador ha ganado la partida.");
			return true;
		}
		if (huecos == 0) {
			System.out.println("Partida terminada: no hay más casillas libres.");
			return true;
		}
		return false;
	}

	public static boolean compruebaJugada(int[][] tablero, int valor) {
		return compruebaHorizontal(tablero, valor) || compruebaVertical(tablero, valor) ||
				compruebaDiagonales(tablero, valor);
	}

	public static boolean compruebaHorizontal(int[][] tablero, int valor) {
		for (int fila = 0; fila < tablero.length; fila++) {
			int col = 0;
			while (col < tablero[fila].length && tablero[fila][col] == valor)
				col++;
			if (col == 3)
				return true;
		}
		return false;
	}

	public static boolean compruebaVertical(int[][] tablero, int valor) {
		for (int col = 0; col < tablero[0].length; col++) {
			int fila = 0;
			while (fila < tablero.length && tablero[fila][col] == valor)
				fila++;
			if (fila == 3)
				return true;
		}
		return false;
	}

	public static boolean compruebaDiagonales(int[][] tablero, int valor) {

		return (tablero[0][0] == valor && tablero[1][1] == valor && tablero[2][2] == valor) ||
			(tablero[0][2] == valor && tablero[1][1] == valor && tablero[2][0] == valor);
	}

	public static void juegaMaquina(int[][] tablero) {
		boolean vacia = false;
		int fila = -1, col = -1;

		do {
			fila = (int)(Math.random() * 3);
			col = (int)(Math.random() * 3);
			vacia = tablero[fila][col] == 0;
		} while (!vacia);
		tablero[fila][col] = 2;
	}

	public static int[] pasaACoord(String entrada) {
		int[] coordenadas = new int[2];

		coordenadas[0] = switch (entrada.charAt(0)) {
			case 'c' -> 0;
			case 'b' -> 1;
			case 'a' -> 2;
			default -> -1;
		};
		coordenadas[1] = entrada.charAt(1) - 49;
		return coordenadas;
	}

	public static boolean validaEntrada(String entrada) {
		if (entrada.length() != 2)
			return false;
		return (entrada.charAt(0) == 'a' || entrada.charAt(0) == 'b' || 
			entrada.charAt(0) == 'c') && (entrada.charAt(1) == '1' || 
			entrada.charAt(1) == '2' || entrada.charAt(1) == '3');
	}

	public static void muestraTablero(int[][] tablero) {
		char letra = 'c';

		System.out.println();
		System.out.println("   " +"░".repeat(15));
		for (int i = 0; i < tablero.length; i++) {
			System.out.printf(" %s ░", letra--);
			for (int j = 0; j < tablero[i].length; j++) {
				String contenido = tablero[i][j] == 1 ? "∙" : tablero[i][j] == 2 ? "X" : " ";
				System.out.printf("░ %s ", contenido);
			}
			System.out.println("░░\n   " + "░".repeat(15));
		}
		System.out.print("   ");
		for (int i = 1; i <= 3; i++)
			System.out.print("   " + i);
		System.out.println("\n");
	}

	public static void muestraMatriz(int[][] tablero) {
		System.out.println("Mapa: ");
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[i].length; j++)
				System.out.print(" " + tablero[i][j] + " ");
			System.out.println();
		}
	}
}

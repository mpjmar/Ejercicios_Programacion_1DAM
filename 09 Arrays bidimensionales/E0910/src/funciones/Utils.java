package funciones;

public class Utils {
	public static int huecos = 9;

	public static boolean modificaTablero(int[][] tablero, String entrada, boolean turnoJugador) throws InterruptedException {
		boolean terminada = false;
		int[] coord = new int[2];
		boolean vacia = true;
		int jugador = 1, ordenador = 2;

		if (turnoJugador) {
			coord = pasaACoord(entrada);
			vacia = tablero[coord[0]][coord[1]] == 0;
			if (vacia) {
				tablero[coord[0]][coord[1]] = jugador;
				huecos--;
			}
			else {
				System.out.println("La posicion está ya ocupada. Pierdes el turno.");
				return false;
			}
		}
		else {
			Thread.sleep(1000);
			coord = juegaMaquina(tablero);
			tablero[coord[0]][coord[1]] = ordenador;
			huecos--;
		}
		
		terminada = compruebaJugada(tablero, turnoJugador);
		if (huecos > 0 && terminada) {
			System.out.printf("%n¡¡El %s gana la partida!!%n%n", turnoJugador ? "jugador" : "ordenador");
			return true;
		}
		if (huecos == 0) {
			System.out.println("Partida terminada: no hay más casillas libres.");
			return true;
		}
		return false;
	}

	public static boolean compruebaJugada(int[][] tablero, boolean turnoJugador) {
		return compruebaHorizontal(tablero, turnoJugador) || compruebaVertical(tablero, turnoJugador) ||
				compruebaDiagonales(tablero, turnoJugador);
	}

	public static boolean compruebaHorizontal(int[][] tablero, boolean turnoJugador) {
		int valor = turnoJugador ? 1 : 2;

		for (int i = 0; i < tablero.length; i++)
			if (tablero[i][0] == valor && tablero[i][1] == valor && tablero[i][2] == valor)
				return true;
		return false;
	}

	public static boolean compruebaVertical(int[][] tablero, boolean turnoJugador) {
		int valor = turnoJugador ? 1 : 2;

		for (int i = 0; i < tablero[0].length; i++) {
			if (tablero[0][i] == valor && tablero[1][i] == valor && tablero[2][i] == valor)
				return true;
		}
		return false;
	}

	public static boolean compruebaDiagonales(int[][] tablero, boolean turnoJugador) {
		int valor = turnoJugador ? 1 : 2;

		return (tablero[0][0] == valor && tablero[1][1] == valor && tablero[2][2] == valor) ||
			(tablero[0][2] == valor && tablero[1][1] == valor && tablero[2][0] == valor);
	}

	public static int[] juegaMaquina(int[][] tablero) {
		boolean vacia = false;
		int[] coord = new int[2];

		do {
			coord[0] = (int)(Math.random() * 3);
			coord[1] = (int)(Math.random() * 3);
			vacia = tablero[coord[0]][coord[1]] == 0;
		} while (!vacia);
		return coord;
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
		char letra = entrada.charAt(0);
		char num = entrada.charAt(1);

		if (entrada.length() != 2)
			return false;
		return (letra >= 'a' && letra <= 'c') && (num >= '1' && num <= '3');
	}

	public static void muestraTablero(int[][] tablero) {
		char letra = 'c';

		System.out.println();
		System.out.println("   " +"░".repeat(15));
		for (int i = 0; i < tablero.length; i++) {
			System.out.printf(" %s ░", letra--);
			for (int j = 0; j < tablero[i].length; j++) {
				String contenido = tablero[i][j] == 1 ? "◉" : tablero[i][j] == 2 ? "x" : " ";
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

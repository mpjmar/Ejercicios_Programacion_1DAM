public class App {
    public static void main(String[] args) throws Exception {
		int[][] tablero = new int[3][3];
		String entrada = "";
		boolean terminada = false, valida = false;

		do {
			muestraMatriz(tablero);
			muestraTablero(tablero);
			try {
				do {
					System.out.print("Introduzca las coordenadas, por ejemplo b2: ");
					entrada = System.console().readLine().toLowerCase();
					valida = validaEntrada(entrada);
					if (!valida) System.out.println("Coordenadas incorrectas.");
				} while (!valida);
			} catch (NumberFormatException e) {
				System.out.println("El número debe ser un entero.");
			} catch (Exception e) {
				System.out.println("Ha ocurrido un error inesperado.");
			}
			terminada = modificaTablero(tablero, entrada);
		} while (!terminada);
	}

	public static boolean modificaTablero(int[][] tablero, String entrada) throws InterruptedException {
		boolean terminada = false;
		int[] coord = pasaACoord(entrada);
		boolean vacia = true;

		vacia = tablero[coord[0]][coord[1]] == 0;
		if (vacia) {
			tablero[coord[0]][coord[1]] = 1;
			terminada = compruebaJugada(tablero);
			if (terminada) {
				System.out.println("El jugador ha ganado la partida.");
				return true;
			}
		}
		else
			System.out.println("La posicion está ya ocupada. Pierdes el turno.");
		muestraTablero(tablero);
		Thread.sleep(1000);
		if (!terminada)
			juegaMaquina(tablero);
		terminada = compruebaJugada(tablero);
		if (terminada) {
			System.out.println("El ordenador ha ganado la partida.");
			return true;
		}
		return false;
	}

	public static boolean compruebaJugada(int[][] tablero) {
		for (int i = 0; i < tablero.length; i++)
			for (int j = 0; j < tablero[i].length; j++)
				if (tablero[i][j] )
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

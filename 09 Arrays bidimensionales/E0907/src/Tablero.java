public class Tablero {

	public static void juega(int[][] mapa) {
		boolean encontrado = false;
		System.out.println("\n¡BUSCA EL TESORO!\n");
		do {
			imprimeTablero(mapa);
			int[] coord = pideCoord(mapa);
			coord[1] = volteaCoord(coord[1], mapa.length - 1);
			int intento = compruebaCoordenadas(mapa, coord);;
			encontrado = intento == 1 || intento == 2;
		} while (!encontrado);
	}

	public static int compruebaCoordenadas(int[][] mapa, int[] coord) {
		final int VACIO = 0;
		final int MINA = 1;
        final int TESORO = 2;
		final int INTENTO = 3;
		switch(mapa[coord[1]][coord[0]]) {
			case VACIO:
				mapa[coord[1]][coord[0]] = INTENTO;
				break;
			case MINA:
				System.out.println("¡Lo siento, has perdido!\n");
				break;
			case TESORO:
				System.out.println("¡Enhorabuena! ¡Has encontrado el tesoro!\n");
				break;
			default:
				break;
		}
		avisaMina(mapa, coord);
		return mapa[coord[1]][coord[0]];
	}

	public static void avisaMina(int[][] mapa, int[] coord) {
		int MINA = 1, X = coord[1], Y = coord[0];
		for (int i = 0; i < mapa.length; i++) {
			for (int j = 0; j < mapa[i].length; j++) {
				if (mapa[i][j] == MINA && 
					((i == X + 1 && j == Y) || (i == X - 1 && j == Y) ||
					(i == X && j == Y + 1) || (i == X && j == Y - 1) ||
					(i == X + 1 && j + 1 == Y) || (i == X - 1 && j - 1 == Y) ||
					(i == X + 1 && j - 1 == Y) || (i == X - 1 && j + 1 == Y))) {
					System.out.println("!Cuidado, hay una mina cerca!\n");
					return;
				}
			}
		}
	}

	public static int[] pideCoord(int[][] mapa) {
		int[] coord = new int[2];
		boolean correcto = false;
		do {
			try {
				System.out.println("---------------");
				System.out.print("Coordenada x: ");
				coord[0] = Integer.parseInt(System.console().readLine());
				System.out.print("Coordenada y: ");
				coord[1] = Integer.parseInt(System.console().readLine());
				System.out.println("---------------");
				correcto = coord[0] < mapa[0].length && coord[1] < mapa.length;
				if (!correcto) System.out.println("Las coordenadas introducidas no son correctas.");
			} catch (NumberFormatException e) {
				System.out.println("El número debe ser un entero.");
			} catch (Exception e) {
				System.out.println("Ha ocurrido un error inesperado.");
			}
		} while (!correcto);
		System.out.println();
		return coord;
	}

	public static int volteaCoord(int coord, int filas) {
		return filas - coord;
	}

	public static void imprimeTablero(int[][] mapa) {
		int fila = 3;
		for (int i = 0; i < mapa.length; i++) {
			System.out.printf("%d|", fila--);
			for (int j = 0; j < mapa[i].length; j++)
				System.out.print(mapa[i][j] == 3 ? "X " : "  ");
			System.out.println();
		}
		System.out.print("  " + "--".repeat(mapa[0].length) + "\n  ");
		for (int i = 0; i < mapa[0].length; i++)
			System.out.print(i + " ");
		System.out.println();
	}

	public static void imprimeFin(int[][] mapa) {
		final int MINA = 1;
        final int TESORO = 2;
		final int INTENTO = 3;
		int fila = 3;
		for (int i = 0; i < mapa.length; i++) {
			System.out.printf("%d|", fila--);
			for (int j = 0; j < mapa[i].length; j++)
				System.out.print(mapa[i][j] == INTENTO ? "X " : mapa[i][j] == TESORO ? "$ " : 
					mapa[i][j] == MINA ? "* " : "  ");
			System.out.println();
		}
		System.out.print("  " + "--".repeat(mapa[0].length) + "\n  ");
		for (int i = 0; i < mapa[0].length; i++)
			System.out.print(i + " ");
		System.out.println();
	}
}

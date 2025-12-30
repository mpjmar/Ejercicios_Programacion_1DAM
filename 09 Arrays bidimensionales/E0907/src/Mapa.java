public class Mapa {

	public static void inicializaMapa(int[][] mapa, int valor) {
		for (int i = 0; i < mapa.length; i++)
			for (int j = 0; j < mapa[i].length; j++)
				mapa[i][j] = valor;
	}

	public static void colocaObjetos(int[][] mapa) {
		final int VACIO = 0;
		final int MINA = 1;
        final int TESORO = 2;
		int filaMina = (int)(Math.random() * mapa.length);
		int colMina = (int)(Math.random() * mapa[0].length);
		int filaTesoro = 0, colTesoro = 0;
		do {
			filaTesoro = (int)(Math.random() * mapa.length);
			colTesoro = (int)(Math.random() * mapa[0].length);
		} while (filaTesoro == filaMina && colTesoro == colMina);
	
		inicializaMapa(mapa, VACIO);
		mapa[filaMina][colMina] = MINA;
		mapa[filaTesoro][colTesoro] = TESORO;
	}

	public static void muestraMapa(int[][] mapa) {
		for (int i = 0; i < mapa.length; i++) {
			for (int j = 0; j < mapa[i].length; j++)
				System.out.print(mapa[i][j] + " ");
			System.out.println();
		}
	}
}

public class App {
    public static void main(String[] args) throws Exception {
		String[] paises = {"España", "Rusia", "Japón", "Australia"};
		int[][] estaturas = generaEstaturas(4, 10, 140, 210);
		muestraDatos(paises, estaturas);
	}

	public static int[][] generaEstaturas(int filas, int columnas, int min, int max) {
		int[][] estaturas = new int[filas][columnas];
		for (int i = 0; i < estaturas.length; i++)
			for (int j = 0; j < estaturas[i].length; j++)
				estaturas[i][j] = (int)(Math.random() * (max - min + 1)) + min;
		return estaturas;
	}

	public static void muestraDatos(String[] paises, int[][] estaturas) {
		System.out.printf("%65s%n", "MED MIN MAX");
		for (int i = 0; i < paises.length; i++) {
			int suma = 0, min = Integer.MAX_VALUE, max = 0;
			System.out.printf("%10s: ", paises[i]);
			for (int j = 0; j < estaturas[i].length; j++) {
				System.out.print(estaturas[i][j] + " ");
				max = max < estaturas[i][j] ? estaturas[i][j] : max;
				min = min > estaturas[i][j] ? estaturas[i][j] : min;
				suma += estaturas[i][j];
			}
			System.out.printf("| %d %d %d%n", suma / estaturas[0].length, min, max);
		}
	}

}

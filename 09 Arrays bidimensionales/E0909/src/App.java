public class App {
    public static void main(String[] args) throws Exception {
		int[][] matriz = generaMatriz(8, 8, 0, 100);
		System.out.println("\nArray original: \n---------------");
		muestraMatriz(matriz);
		int[][] rotada = rotaMatriz(matriz);
		System.out.println("\nArray rotado: \n-------------");
		muestraMatriz(rotada);
	}

	public static int[][] rotaMatriz(int[][] matriz) {
		int filas = matriz.length;
		int col = matriz[0].length;
		int[][] rotada = new int[filas][col];
		for (int i = 0; i < filas / 2; i++) {
			int[] array = extraeArray(matriz, i);
			System.out.println("Array extraido: ");
			muestraArray(array);
			System.out.println("Array rotado: ");
			int[] rotado = rotaArray(array);
			muestraArray(rotado);
			//devuelveAMatriz(rotada, array, i);
		}
		return rotada;
	}

	public static int[] extraeArray(int[][] matriz, int fila) {
		int pos = 0;
		int filas = matriz.length;
		int col = matriz[0].length;
		int longitud = filas * 2 + (col - 2) * 2;
		int[] array = new int[longitud];
		for (int i = 0; i < matriz[0].length; i++) 
			array[pos++] = matriz[0][i];
		for (int i = )
		return array;
	}

	public static int[] rotaArray(int[] array) {
		int longitud = array.length;
		int[] rotado = new int[longitud];
		int temp = array[longitud - 1];
		for (int i = longitud - 1; i > 0; i--)
			rotado[i] = array[i - 1];
		rotado[0] = temp;
		return rotado;
	}

	public static int[][] generaMatriz(int filas, int col, int min, int max) {
		int[][] matriz = new int[filas][col];
		for (int i = 0; i < matriz.length; i++)
			for (int j = 0; j < matriz[i].length; j++)
				matriz[i][j] = (int)(Math.random() * (max - min + 1)) + min;
		return matriz;
	}

	public static void muestraMatriz(int[][] matriz) {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++)
				System.out.printf("%3d ", matriz[i][j]);
			System.out.println();
		}
	}

	public static void muestraArray(int[] array) {
		for (int i = 0; i < array.length; i++)
			System.out.print(array[i] + " ");
		System.out.println();
	}
}

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
		int[][] matrizRotada = new int[matriz.length][matriz[0].length];

		for (int i = 0; i < matriz.length / 2; i++) {
			int[] array = extraeArray(matriz, i);
			System.out.println("Array extraido: ");
			muestraArray(array);
			System.out.println("Array rotado: ");
			int[] arrayRotado = rotaArray(array);
			muestraArray(arrayRotado);
			devuelveAMatriz(matrizRotada, arrayRotado, i);
		}
		return matrizRotada;
	}

	public static void devuelveAMatriz(int[][] matriz, int[] array, int fila) {
		int pos = 0;
		int filas = matriz.length - fila;
		int col = matriz[fila].length - fila;

		for (int i = fila; i < col; i++)
			matriz[fila][i] = array[pos++];
		for (int i = fila + 1; i <= filas - 1; i++)
			matriz[i][col - 1] = array[pos++];
		for (int i = filas - 2; i > fila; i--)
			matriz[filas - 1][i] = array[pos++];
		for (int i = filas - 1; i > fila; i--)
			matriz[i][fila] = array[pos++];
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

	public static int[] extraeArray(int[][] matriz, int fila) {
		int pos = 0;
		int filas = matriz.length;
		int col = matriz[0].length;
		int longitud = (filas - fila * 2) * 2 + (col - 2 - fila * 2) * 2;
		int[] array = new int[longitud];

		for (int i = fila; i < col - fila; i++) 
			array[pos++] = matriz[fila][i];
		for (int i = fila + 1; i <= filas - fila - 1; i++)
			array[pos++] = matriz[i][col - 1 - fila];
		for (int i = col - fila - 1; i > fila; i--)
			array[pos++] = matriz[filas - fila - 1][i - 1];
		for (int i = filas - fila - 2; i > fila; i--)
			array[pos++] = matriz[i][fila]; 
		return array;
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
		System.out.println();
	}

	public static void muestraArray(int[] array) {
		for (int i = 0; i < array.length; i++)
			System.out.print(array[i] + " ");
		System.out.println();
	}
}

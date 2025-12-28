public class App {
    public static void main(String[] args) throws Exception {
		int[][] matrix = generaMatrix(8, 8, 500, 900);
		muestraMatrix(matrix);
		muestraDiagonalInversa(matrix);
	}

	public static int[][] generaMatrix(int filas, int columnas, int min, int max) {
		int[][] matrix = new int[filas][columnas];
		for (int i = 0; i < matrix.length; i++)
			for (int j = 0; j < matrix[i].length; j++)
				matrix[i][j] = (int)(Math.random() * (max - min + 1)) + min;
		return matrix;
	}

	public static void muestraMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++)
				System.out.print(matrix[i][j] + "  ");
			System.out.println();
		}
	}

	public static void muestraDiagonalInversa(int[][] matrix) {
		int max = 0, min = Integer.MAX_VALUE, suma = 0;
		System.out.println("\nDiagonal desde la esquina inf. izquierda a la esquina sup. derecha:");
		for (int i = matrix.length - 1; i >= 0; i--) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (j == matrix[i].length - 1 - i) {
					max = max < matrix[i][j] ? matrix[i][j] : max;
					min = min > matrix[i][j] ? matrix[i][j] : min;
					suma += matrix[i][j];
					System.out.print(matrix[i][j] + " ");
				}
			}
		}
		System.out.printf("\nMáximo: %d   Mínimo: %d   Media: %.2f%n", max, min, (double)suma / matrix.length);
	}
}

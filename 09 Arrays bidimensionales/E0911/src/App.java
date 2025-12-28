public class App {
    public static void main(String[] args) throws Exception {
        int[][] matrix = generaMatrix(9, 9, 200, 300);
		muestraMatrix(matrix);
		muestraDiagonal(matrix);
    }

	public static void muestraDiagonal(int[][] matrix) {
		int max = 0, min = Integer.MAX_VALUE, suma = 0;
		System.out.println("Diagonal desde la esquina sup. izquierda a la esquina inf. derecha:");
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (i == j) {
					max = max < matrix[i][j] ? matrix[i][j] : max;
					min = min > matrix[i][j] ? matrix[i][j] : min;
					suma += matrix[i][j];
					System.out.print(matrix[i][j] + " ");
				}
			}
		}
		System.out.println();
		System.out.printf("Máximo: %d   Mínimo: %d   Madia: %.2f%n", max, min, (double)suma / matrix.length);
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
}

public class App {
    public static void main(String[] args) throws Exception {
        int[][] matrix = generaMatrix(6, 10, 0, 1000);
        muestraMatrix(matrix);
        encuentraMax(matrix);
        encuentraMin(matrix);
    }

    public static void encuentraMin(int[][] matrix) {
        int fila = 0, columna = 0, min = Integer.MAX_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] < min) {
                    fila = i;
                    columna = j;
                    min = matrix[fila][columna];
                }
            }
        }
        System.out.printf("El mínimo es %d y está en la fila %d, columna %d.%n", matrix[fila][columna], fila, columna);
    }

    public static void encuentraMax(int[][] matrix) {
        int fila = 0, columna = 0, max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] > max) {
                    fila = i;
                    columna = j;
                    max = matrix[fila][columna];
                }
            }
        }
        System.out.printf("El máximo es %d y está en la fila %d, columna %d.%n", matrix[fila][columna], fila, columna);
    }

    public static void muestraMatrix(int[][] matrix) {
        System.out.print("   ");
        for (int i = 0; i < matrix[0].length; i++) 
            System.out.printf("%5d", i);
        System.out.println();

        System.out.println("  ____________________________________________________");
        for (int i = 0; i < matrix.length; i++) {
            System.out.printf("%d |", i);
            for (int j = 0; j < matrix[i].length; j++)
                System.out.printf("%5d", matrix[i][j]);
            System.out.println("|");
        }
        System.out.println("  |__________________________________________________|");
        System.out.println();
    }

    public static int[][] generaMatrix(int filas, int columnas, int min, int max) {
        int[][] matrix = new int[filas][columnas];
        int numero = -1;
        inicializaMatrix(matrix, numero);
        for(int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                do {
                    numero = (int)(Math.random() * (max - min + 1)) + min;
                } while (encontrado(matrix, numero));
                matrix[i][j] = numero;
            }
        }
        return matrix;
    }

    public static void inicializaMatrix(int[][] matrix, int num) {
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[i].length; j++)
                matrix[i][j] = num;
    }

    public static boolean encontrado(int[][] matrix, int num) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == num)
                    return true;
            }
        }
        return false;
    }
}

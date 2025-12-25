public class App {
    public static void main(String[] args) throws Exception {

        int[][] numeros = pedirNumeros(4, 5);
        mostrarArray(numeros);
    }

    public static int[][] pedirNumeros(int filas, int columnas) {
        int[][] numeros = new int[filas][columnas];
        System.out.println("Por favor, introduzca los números (enteros) en el array: ");
        for (int i = 0; i < numeros.length; i++) {
            for (int j = 0; j < numeros[i].length; j++) {
                System.out.printf("Fila %d, columna %d: ", i, j);
                try {
                    numeros[i][j] = Integer.parseInt(System.console().readLine());
                }
                catch (NumberFormatException e) {
                    System.out.println("El número debe ser un entero.");
                }
                catch (Exception e) {
                    System.out.println("Ha ocurrido un error inesperado.");
                }
            }
        }
        return numeros;
    }

    public static void mostrarArray(int[][] array) {
        System.out.println();
        for (int i = 0; i < array.length; i++)
            muestraFila(array, i);
        System.out.println("------------------------------------------------");
        muestraTotales(array);
    }

    public static void muestraFila(int[][] array, int fila) {
        int suma = 0;
        for (int j = 0; j < array[fila].length; j++) {
            System.out.printf("%7d", array[fila][j]);
            suma += array[fila][j];
        }
        System.out.printf("  |%7d%n", suma);
    }

    public static int sumaColumna(int[][] array, int columna) {
        int suma = 0;
        for (int i = 0; i < array.length; i++)
            suma += array[i][columna];
        return suma;
    }

    public static void muestraTotales(int[][] array) {
        int suma = 0, total = 0;;
        for (int i = 0; i < array[0].length; i++) {
            total = sumaColumna(array, i);
            System.out.printf("%7d", total);
            suma += total;
        }
        System.out.printf("  |%7d", suma);
    }
}

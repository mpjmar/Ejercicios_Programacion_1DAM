import metodos.ArraysBi;

public class App {
    public static void main(String[] args) throws Exception {

        int[][] arrayBi = ArraysBi.generaArrayBi(5, 7, 0, 99);
        ArraysBi.muestraArrayBi(arrayBi);
        System.out.print("Fila 2: ");
        ArraysBi.muestraArray(ArraysBi.filaDeArrayBiInt(arrayBi, 2));
        System.out.printf("Columna 6: ");
        ArraysBi.muestraArray(ArraysBi.columnaDeArrayBiInt(arrayBi, 6));
        System.out.print("Coordenadas del 24 (fila, columna): ");
        ArraysBi.muestraCoordenadas(ArraysBi.coordenadasEnArrayBiInt(arrayBi, 24));

        System.out.println("\n" + "-".repeat(42) + "\n");

        System.out.println("Busca los puntos de silla\n");
        ArraysBi.muestraPuntosDeSilla(arrayBi);

        System.out.println("\n" + "-".repeat(42) + "\n");

        System.out.println("Muestra la diagonal: \n");
        ArraysBi.muestraArrayBi(arrayBi);
        ArraysBi.muestraArray(ArraysBi.diagonal(arrayBi));
    }
}

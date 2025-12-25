import metodos.Arrays;

public class App {
    public static void main(String[] args) throws Exception {

        int[] array = Arrays.generaArrayInt(10, 0, 100);
        Arrays.muestraArrayInt(array);
        System.out.printf("Mínimo: %d%n", Arrays.minimoArrayInt(array));
        System.out.printf("Máximo: %d%n", Arrays.maximoArrayInt(array));
        System.out.printf("Media: %.2f%n", Arrays.mediaArrayInt(array));
        System.out.printf("El %d%s está en el array.%n", 24, 
                            Arrays.estaEnArrayInt(array, 24) ? "" : " no");
        System.out.printf("El %d %s%n", 24, 
                            Arrays.posicionEnArray(array, 24) < 0 ? "no se encuentra en el array." :
                            String.format("está en la posición " + "%d.", Arrays.posicionEnArray(array, 24)));
        System.out.printf("Array al revés:%n");
        Arrays.muestraArrayInt(Arrays.volteaArrayInt(array));
        System.out.printf("Array rotado %d pasos a la derecha:%n", 3);
        Arrays.muestraArrayInt(Arrays.rotaDerechaArrayInt(array, 3));
        System.out.printf("Array rotado %d pasos a la izquierda:%n", 4);
        Arrays.muestraArrayInt(Arrays.rotaIzquierdaArrayInt(array, 4));
    }
}

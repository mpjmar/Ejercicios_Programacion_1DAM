public class App {
    public static void main(String[] args) throws Exception {
        int[] array = generaArray(4, 100, 1000);
        muestraArray(array);
        System.out.println(aleatorioDeArray(array));
    }

    public static int aleatorioDeArray(int[] array) {
        int aleatorio = (int)(Math.random() * array.length);
        return array[aleatorio];
    }

    public static void muestraArray(int[] array) {
        for (int i = 0; i < array.length; i++)
            System.out.print(array[i] + " ");
        System.out.println();
    }

    public static int[] generaArray(int longitud, int max, int min) {
        int[] array = new int[longitud];
        for (int i = 0; i < array.length; i++)
            array[i] = (int)(Math.random() * (max - min + 1)) + min;
        return array;
    }
}

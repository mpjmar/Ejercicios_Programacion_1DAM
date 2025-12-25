public class App {
    public static void main(String[] args) throws Exception {

        int[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        //int[] array = generaArray(25, 1, 100);
        System.out.println("Array original: ");
        muestraArray(array);
        System.out.println("Primos: ");
        muestraArray(filtraPrimos(array));
    }

    public static int[] filtraPrimos(int array[]) {
        int[] primos = new int[cuentaPrimos(array)];
        int idx = 0;
        for (int i = 0; i < array.length; i++)
            if (esPrimo(array[i]))
                primos[idx++] = array[i];
        return primos;
    }

    private static int cuentaPrimos(int[] array) {
        int cantidad = 0;
        for (int i = 0; i < array.length; i++)
            if (esPrimo(array[i]))
                cantidad++;
        return cantidad;
    }

    private static boolean esPrimo(int num) {
        if (num == 2)
            return true;
        if (num < 2 || num % 2 == 0)
            return false;
        for (int i = 3; i < num / 2; i += 2)
            if (num % i == 0)
                return false;
        return true;
    }

    private static void muestraArray(int[] array) {
        for (int i = 0; i < array.length; i++)
            System.out.print(array[i] + " ");
        System.out.println();
    }

    private static int[] generaArray(int longitud, int min, int max) {
        int[] array = new int[longitud];
        for (int i = 0; i < array.length; i++)
            array[i] = (int)(Math.random() * (max - min + 1)) + min;
        return array;
    }
}

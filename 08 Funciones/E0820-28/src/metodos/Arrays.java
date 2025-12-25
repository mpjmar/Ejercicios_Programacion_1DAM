package metodos;

public class Arrays {

    public static int[] rotaIzquierdaArrayInt(int[] array, int n) {
        int[] arrayCopia = copiaArrayInt(array);
        for (int i = 0; i < n; i++)
            rotaPosicionIzq(arrayCopia);
        return arrayCopia;
    }

    public static int[] rotaDerechaArrayInt(int[] array, int n) {
        int[] arrayCopia = copiaArrayInt(array);
        for (int i = 0; i < n; i++)
            rotaPosicionDcha(arrayCopia);
        return arrayCopia;
    }

    private static void rotaPosicionIzq(int[] array) {
        int aux = array[0];
        for (int i = 0; i < array.length - 1; i++)
            array[i] = array[i + 1];
        array[array.length - 1] = aux;
    }

    private static void rotaPosicionDcha(int[] array) {
        int aux = array[array.length - 1];
        for (int i = 0; i < array.length - 1; i++)
            array[array.length - i - 1] = array[array.length - i - 2];
        array[0] = aux;
    }

    public static int[] volteaArrayInt(int[] array) {
        int[] arrayCopia = copiaArrayInt(array);
        for (int i = 0; i < arrayCopia.length / 2; i++) 
            swap(arrayCopia, i, arrayCopia.length - i - 1);
        return arrayCopia;
    }
    
    private static void swap(int[] array, int pos1, int pos2) {
        int aux = array[pos1];
        array[pos1] = array[pos2];
        array[pos2] = aux;
    }

    private static int[] copiaArrayInt(int[] array) {
        int[] arrayCopia = new int[array.length];
        for (int i = 0; i < array.length; i++)
            arrayCopia[i] = array[i];
        return arrayCopia;
    }

    public static int posicionEnArray(int[] array, int n) {
        int i = 0;
        while (i < array.length) {
            if (array[i] == n)
                return i;
            i++;
        }
        return -1;
    }

    public static boolean estaEnArrayInt(int[] array, int n) {
        for (int i: array)
            if (n == i)
                return true;
        return false;
    }

    public static double mediaArrayInt(int[] array) {
        int suma = 0;
        for (int i: array)
            suma += i;
        return suma / array.length;
    }

    public static int maximoArrayInt(int[] array) {
        int max = Integer.MIN_VALUE;
        for (int i: array)
            max = i > max ? i : max;
        return max;
    }

    public static int minimoArrayInt(int[] array) {
        int min = Integer.MAX_VALUE;
        for (int i: array)
            min = i < min ? i : min;
        return min;
    }
    
    public static void muestraArrayInt(int[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++)
            System.out.printf(i < array.length - 1 ? "%d, " : "%d]%n", array[i]);
    }

    public static int[] generaArrayInt(int n, int min, int max) {
        int[] array = new int[n];
        for (int i = 0; i < array.length; i++)
            array[i] = (int)(Math.random() * (max - min + 1)) + min;
        return array;
    }


}

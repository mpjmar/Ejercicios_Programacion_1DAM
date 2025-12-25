public class App {
    public static void main(String[] args) throws Exception {
        int[] array = generaArray(25, 100, 1000);
        muestraArray(array);
        muestraArray(filtraConNum(array, 7));
    }

    public static int[] filtraConNum(int[] array, int num) {
        int[] filtrados = new int[cuentaNum(array, num)];
        int pos = 0;
        for (int i = 0; i < array.length; i++)
            if (contieneNum(array[i], num))
                filtrados[pos++] = array[i];
        return filtrados;
    }

    private static int cuentaNum(int[] array, int num) {
        int cantidad = 0;
        for (int i = 0; i < array.length; i++)
            if (contieneNum(array[i], num))
                cantidad++;
        return cantidad;
    }

    private static boolean contieneNum(int num, int n) {
        while (num > 0) {
            if (num % 10 == n)
                return true;
            num /= 10;
        }
        return false;
    } 

    public static void muestraArray(int[] array) {
        for (int i = 0; i < array.length; i++)
            System.out.print(array[i] + " ");
        System.out.println();
    }

    public static int[] generaArray(int longitud, int min, int max) {
        int[] array = new int[longitud];
        for (int i = 0; i < array.length; i++)
            array[i] = (int)(Math.random() * (max - min + 1)) + min;
        return array;
    }
}

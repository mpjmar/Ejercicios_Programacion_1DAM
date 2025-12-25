public class App {
    public static void main(String[] args) throws Exception {
        int[] numeros = generaArray(25, 0, 100);
        muestraArray(numeros);
        System.out.println();
        int[] capicuas = filtraCapicuas(numeros);
        muestraArray(capicuas);
    }

    public static void muestraArray(int[] array) {
        for (int i = 0; i < array.length; i++)
            System.out.print(array[i] + " ");
    }

    public static int[] filtraCapicuas(int[] x){
        int cantidad = cuentaCapicuas(x);
        int[] capicuas = new int[cantidad];
        int pos = 0;
        for (int i = 0; i < x.length; i++)
            if (esCapicua(x[i]))
                capicuas[pos++] = x[i];
        return capicuas;
    }

    private static int cuentaCapicuas(int[] x) {
        int cantidad = 0;
        for (int i = 0; i < x.length; i++)
            cantidad += esCapicua(x[i]) ? 1 : 0;
        return cantidad;
    }

    private static boolean esCapicua(int n) {
        if (n == 2)
            return true;
        if (n < 2 || n % 2 == 0)
            return false;
        for (int i = 3; i < n / 2; i += 2)
            if (n % i == 0)
                return false;
        return true;
    }

    public static int[] generaArray(int longitud, int max, int min) {
        int[] array = new int[longitud];
        for (int i = 0; i < array.length; i++) 
            array[i] = (int)(Math.random() * (max - min + 1)) + min;
        return array;
    }
}

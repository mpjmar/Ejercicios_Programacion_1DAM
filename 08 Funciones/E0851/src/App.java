public class App {
    public static void main(String[] args) throws Exception {
        int[] array = generaArray(10, 2, 100);
        System.out.print("Array generado: ");
        muestraArray(array);
        catalogaArray(array);
    }

    public static void catalogaArray(int[] array) {
        for (int i = 0; i < array.length; i++)
            catalogaNum(array[i]);
    }

    private static void catalogaNum(int num) {
        System.out.printf("El %d%s es primo y%s es capicúa.%n", num, 
            esPrimo(num) ? "" : " no",
            esCapicua(num) ? "" : " no");
    }

    private static boolean esPrimo(int num) {
        if (num == 2)
            return true;
        if (num < 2 || num % 2 == 0)
            return false;
        int i = 3;
        while (i < num / 2) {
            if (num % i == 0)
                return false;
            i += 2;
        }
        return true;
    }

    private static boolean esCapicua(int num) {
        int invertido = invertido(num);
        return invertido == num;
    }

    private static int invertido(int num) {
        int invertido = 0;
        while (num > 0) {
            invertido = invertido * 10 + num % 10;
            num /= 10;
        }
        return invertido;
    }

    public static void muestraArray(int array[]) {
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

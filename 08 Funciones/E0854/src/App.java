public class App {
    public static void main(String[] args) throws Exception {
        System.out.printf("número: %d%n", 4672);
        System.out.printf("ocurrencias del %d: %d%n", 8, ocurrencias(8, 4672));

        System.out.printf("número: %d%n", 5251535);
        System.out.printf("ocurrencias del %d: %d%n", 5, ocurrencias(5, 5251535));

        System.out.printf("número: %d%n", 12345);
        System.out.printf("ocurrencias del %d: %d%n", 2, ocurrencias(2, 12345));

        int[] array = {714, 81, 9, 11};
        System.out.print("Array: ");
        muestraArray(array);
        System.out.printf("ocurrencias del %d: %d%n", 1, ocurrencias(1, array));

        int[] array1 = {42, 13, 12345, 4};
        System.out.print("Array: ");
        muestraArray(array);
        System.out.printf("ocurrencias del %d: %d%n", 4, ocurrencias(4, array1));

        int[] array2 = {6, 66, 666};
        System.out.print("Array: ");
        muestraArray(array);
        System.out.printf("ocurrencias del %d: %d%n", 6, ocurrencias(6, array2));
    }

    public static int ocurrencias(int digito, int[] array) {
        int ocurrencias = 0;
        for (int i = 0; i < array.length; i++)
            ocurrencias += ocurrencias(digito, array[i]);
        return ocurrencias;
    }

    public static int ocurrencias(int digito, int num) {
        int ocurrencias = 0;
        while (num > 0) {
            ocurrencias += num % 10 == digito ? 1 : 0;
            num /= 10;
        }
        return ocurrencias;
    }

    public static void muestraArray(int[] array) {
        for (int i = 0; i < array.length; i++)
            System.out.print(array[i] + " ");
        System.out.println();
    }
}

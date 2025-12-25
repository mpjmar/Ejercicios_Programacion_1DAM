public class App {
    public static void main(String[] args) throws Exception {
        int[] a = {8, 9, 0};
        int[] b = {1, 2, 3};

        System.out.print("a: ");
        muestraArray(a);
        System.out.print("b: ");
        muestraArray(b);
        System.out.print("concatena(a, b): ");
        muestraArray(concatena(a, b));
    }

    public static int[] concatena(int[] a, int[] b) {
        int[] array = new int[a.length + b.length];
        copiaArray(a, array, 0);
        copiaArray(b, array, b.length);
        return array;
    }

    private static int[] copiaArray(int[] src, int[] dst, int pos) {
        for (int i = 0; i < src.length; i++)
            dst[pos++] = src[i];
        return dst;
    }

    public static void muestraArray(int[] array) {
        for (int i = 0; i < array.length; i++)
            System.out.print(array[i] + " ");
        System.out.println();
    }
}

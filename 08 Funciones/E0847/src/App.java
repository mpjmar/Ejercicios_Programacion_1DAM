public class App {
    public static void main(String[] args) throws Exception {
        int[] a = {};
        int[] b = {8};
        int[] c = {6, 2, 5, 0, 1};

        System.out.println("a: " + convierteArrayEnString(a));
        System.out.println("b: " + convierteArrayEnString(b));
        System.out.println("c: " + convierteArrayEnString(c));
    }

    public static String convierteArrayEnString(int[] array) {
        String numeros = "";
        for (int i = 0; i < array.length; i++)
            numeros += array[i];
        return numeros;
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        int[] a = {8, 9, 0};
        muestraArray("a: ", a);
        int[] b = {1, 2, 3};
        muestraArray("b: ", b);
        muestraArray("mezcla(a, b): ", mezcla(a, b));
        System.out.println();

        int[] c = {4, 3};
        muestraArray("c: ", c);
        int[] d = {7, 8, 9, 10};
        muestraArray("d: ", d);
        muestraArray("mezcla(c, d): ", mezcla(c, d));
        System.out.println();

        int[] e = {8, 9, 0, 3};
        muestraArray("e: ", e);
        int[] f = {1};
        muestraArray("f: ", f);
        muestraArray("mezcla(e, f): ", mezcla(e, f));
        System.out.println();

        int[] g = {};
        muestraArray("g: ", g);
        int[] h = {1, 2, 3};
        muestraArray("h: ", h);
        muestraArray("mezcla(g, h): ", mezcla(g, h));
        System.out.println();
    }

    public static int[] mezcla(int[] a, int[] b) {
        int[] resultado = new int[a.length + b.length];
        int posA = 0, posB = 0;
        int i = 0;
        while (i < resultado.length) {
            if (posA < a.length)
                resultado[i++] = a[posA++];
            if (posB < b.length)
                resultado[i++] = b[posB++];
        }
        return resultado;
    }

    public static void muestraArray(String mensaje, int[] array) {
        System.out.print(mensaje);
        for (int i = 0; i < array.length; i++)
            System.out.print(array[i] + " ");
        System.out.println();
    }
}

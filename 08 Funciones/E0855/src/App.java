public class App {
    public static void main(String[] args) throws Exception {
        String[] array = {"casa", "coche", "sol", "mesa", "mesa", "coche", "ordenador", "sol", "CASA"};
        muestraArray(sinRepetir(array));
    }

    public static String[] sinRepetir(String[] array) {
        String[] aux = new String[array.length];
        aux[0] = array[0];
        int pos = 0;
        for (int i = 1; i < array.length; i++)
            if (!estaRepetida(aux, array[i], pos))
                aux[++pos] = array[i];
        String[] sinRepetir = new String[pos + 1];
        copiaArray(aux, sinRepetir, pos);
        return sinRepetir;
    }

    public static boolean estaRepetida(String[] array, String palabra, int pos) {
        for (int i = 0; i <= pos; i++)
            if (array[i].equals(palabra))
                return true;
        return false;
    }

    public static String[] copiaArray(String[] src, String[] dst, int posiciones) {
        for (int i = 0; i < dst.length; i++)
            dst[i] = src[i];
        return dst;
    }

    public static void muestraArray(String[] array) {
        for (int i = 0; i < array.length; i++)
            System.out.print(array[i] + " ");
        System.out.println();
    }
}

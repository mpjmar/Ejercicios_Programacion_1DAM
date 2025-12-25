package biblioteca;

public class Operaciones {

    public static int[] generaArray(int longitud, int min, int max) {
        int array[] = new int[longitud];
        for (int i = 0; i < array.length; i++)
            array[i] = (int)(Math.random() * (max - min + 1)) - min;
        return array;
    }

    public static void muestraArray(int array[]) {
        for (int i = 0; i < array.length; i++)
            System.out.print(array[i] + " ");
    }

    public static int[] cincuerizaArray(int array[]) {
        int cincuerizado[] = new int[array.length];
        int aux = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 5 == 0)
                cincuerizado[i] = array[i];
            else {
                aux = array[i];
                do {
                    aux++;
                } while (aux % 5 != 0);
                cincuerizado[i] = aux;
            }
        }
        return cincuerizado;
    }
}
package biblioteca;

public class Operaciones {
    
    public static int[] recolocaArray(int[] array) {
        int[] resultado = new int[array.length];
        int longitud = array.length;
        int resInic = 0, resFin = resultado.length - 1;
        for (int i = 0; i < longitud; i += 2) {
            resultado[resInic] = array[i];
            if (longitud % 2 != 0 && resFin == longitud / 2)
                break;
            resultado[resFin] = array[i + 1];
            resInic++;
            resFin --;
        }
        return resultado;
    }

    public static void muestraArray(int[] array) {
        System.out.printf("%-8s", "Índice");
        for (int i = 0; i < array.length; i++)
            System.out.printf("%4d ",i);
        System.out.printf("%n%-8s", "Valor");
        for (int i = 0; i < array.length; i++)
            System.out.printf("%4d ",array[i]);
    }

    public static int[] crearArray(int longitud, int min, int max) {
        int[] array = new int[longitud];
        for (int i = 0; i < array.length; i++)
            array[i] = (int)(Math.random() * (max - min + 1) + min);
        return array;
    }
}
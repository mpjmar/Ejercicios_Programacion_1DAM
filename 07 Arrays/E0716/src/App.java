public class App {
    public static void main(String[] args) throws Exception {

        int aleatorios[] = rellenaAleatorios(20, 0, 400);
        muestraArray(aleatorios);
        int opcion = 0;
        System.out.printf("Elija los múltiplos que quiere resaltar: ");
        try {
            opcion = Integer.parseInt(System.console().readLine());
        }
        catch (NumberFormatException e) {
            System.out.println("El número debe ser un entero.");
        }
        catch (Exception e) {
            System.out.println("Ha ocurrido un error inesperado.");
        }
        muestraArray(aleatorios, opcion);
    }

    public static boolean esMultiplo(int num, int mult) {
        if (num % mult == 0)
            return true;
        return false;
    }

    public static void muestraArray(int array[], int multiplo) {
        for (int i = 0; i < array.length; i++)
            System.out.printf(esMultiplo(array[i], multiplo) ? "[%d] " : "%d ", array[i]);
        System.out.println();
    }
    
    public static void muestraArray(int array[]) {
        for (int i = 0; i < array.length; i++)
            System.out.printf("%d ", array[i]);
        System.out.println();
    }
    
    public static int[] rellenaAleatorios(int cantidad, int min, int max) {
        int aleatorios[] = new int[cantidad];
        for (int i = 0; i < cantidad; i++)
            aleatorios[i] = (int)(Math.random() * (max - min + 1)) + min;
        return aleatorios;
    }
}

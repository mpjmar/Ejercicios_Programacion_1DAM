public class App {
    public static void main(String[] args) throws Exception {

        int opcion = 0;
        boolean correcto = false;
        int array[] = creaArray(100, 0, 500);
        muestraArray(array);
        System.out.print("¿Qué quiere destacar? (1 - mínimo, 2 - máximo): ");
        do {
            try {
                opcion = Integer.parseInt(System.console().readLine());
                correcto = opcion == 1 || opcion == 2;       
            }
            catch (NumberFormatException e) {
                System.out.println("El número debe ser un entero (1 o 2).");
            }
            catch (Exception e) {
                System.out.println("Ha ocurrido un error inesperado.");
            }
        } while (!correcto);
        muestraArrayDestacado(array, opcion);
    }

    public static int encuentraMin(int array[]) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < array.length; i++)
            min = min > array[i] ? array[i] : min;
        return min;
    }

    public static int encuentraMax(int array[]) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++)
            max = max < array[i] ? array[i] : max;
        return max;
    }
 
    public static void muestraArrayDestacado(int array[], int opcion) {
        int valor = opcion == 1 ? encuentraMin(array) : encuentraMax(array);
        for (int i = 0; i < array.length; i++)
            System.out.printf(array[i] == valor ? "**%d** " : "%d ", array[i]);
    }

    public static void muestraArray(int array[]) {
        for (int i = 0; i < array.length; i++)
            System.out.print(array[i] + " ");
        System.out.println();
    }

    public static int[] creaArray(int elementos, int min, int max) {
        int array[] = new int[elementos];
        for (int i = 0; i < elementos; i++)
            array[i] = (int)(Math.random() * (max - min + 1)) - min;
        return array;
    }
}

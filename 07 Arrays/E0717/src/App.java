public class App {
    public static void main(String[] args) throws Exception {
        int array[] = generaAleatorios(10, 0, 100);
        muestraArray(array);
        int num = pideNum(array);
        muestraArray(rotaArray(array, num));
    }

    public static void muestraArray(int array[]) {
        repeatBorde("┌────────", "┬─────", "┐", array.length);
        repeatIndice("│ Indice ", "│%4d ", "│", array);
        repeatBorde("├────────", "┼─────", "┤", array.length);
        repeatContenido("│ Valor  ", "│%4d ", "│",array);
        repeatBorde("└────────", "┴─────", "┘", array.length);
    }

    public static void repeatBorde(String izq, String centro, String dcha, int len) {
        System.out.print(izq);
        for (int i = 0; i < len; i++)
            System.out.print(centro);
        System.out.println(dcha);
    }

    public static void repeatIndice(String izq, String centro, String dcha, int array[]) {
        System.out.print(izq);
        for (int i = 0; i < array.length; i++)
            System.out.printf(centro, i + 1);
        System.out.println(dcha);
    }

    public static void repeatContenido(String izq, String centro, String dcha, int array[]) {
        System.out.print(izq);
        for (int i = 0; i < array.length; i++)
            System.out.printf(centro, array[i]);
        System.out.println(dcha);
    }

    public static int[] rotaArray(int array[], int num) {
        int nuevoArray[] = new int[array.length];
        int i = 0;
        int indiceNum = buscaPos(array, num);
        if (indiceNum >= 0) {
            while (indiceNum < array.length)
                nuevoArray[i++] = array[indiceNum++];
            indiceNum = 0;
            while (i < nuevoArray.length)
                nuevoArray[i++] = array[indiceNum++];
        }
        return nuevoArray;
    }

    public static int buscaPos(int array[], int num) {
        for (int i = 0; i < array.length; i++)
            if (array[i] == num)
                return i;
        return -1;
    }

    public static int pideNum(int array[]) {
        boolean correcto = false;
        int num = -1;
        do {
            System.out.print("Introduzca uno de los números del array: ");
            try {
                num = Integer.parseInt(System.console().readLine());
                correcto = compruebaNum(array, num);
                if (!correcto)
                    System.out.println("Ese número no se encuentra en el array.");
            }
            catch (NumberFormatException e) {
                System.out.println("El número debe ser un entero.");
            }
            catch (Exception e) {
                System.out.println("Ha ocurrido un error inesperado.");
            }
        } while (!correcto);
        return num;   
    }

    public static boolean compruebaNum(int array[], int num) {
        for(int i = 0; i < array.length; i++)
            if (array[i] == num)
                return true;
        return false;
    }

    public static int[] generaAleatorios(int cantidad, int min, int max) {
        int aleatorios[] = new int[cantidad];
        for (int i = 0; i < aleatorios.length; i++)
            aleatorios[i] = (int)(Math.random() * (max - min + 1)) - min;
        return aleatorios;
    }
}

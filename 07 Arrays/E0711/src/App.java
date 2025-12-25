public class App {
    public static void main(String[] args) throws Exception {

        int numeros[] = pedirNumeros(10);
        System.out.println("Array original: ");
        imprimeTabla(numeros);
        System.out.println();
        System.out.println("Array con los primos al principio: ");
        numeros = desplazaPrimos(numeros);
        imprimeTabla(numeros);
    }

    public static void imprimeTabla(int array[]) {
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

    public static int[] desplazaPrimos(int numeros[]) {
        int desplazados[] = new int[numeros.length];
        int j = 0;
        for (int i = 0; i < numeros.length; i++)
            if (esPrimo(numeros[i]))
                desplazados[j++] = numeros[i];
        for(int i = 0; i < numeros.length; i++)
            if (!esPrimo(numeros[i]))
                desplazados[j++] = numeros[i];
        return desplazados;
    }

    public static boolean esPrimo(int num) {
        if (num < 2)
            return false;
        for (int i = num / 2; i >= 2; i--)
            if (num % i == 0)
                return false;
        return true;
    }

    public static int[] pedirNumeros(int cantidad) {
        int numeros[] = new int[cantidad];

        System.out.println("Introduzca 10 números separados por INTRO:");
        try {
            for (int i = 0; i < numeros.length; i++)
                numeros[i] = Integer.parseInt(System.console().readLine());
        }
        catch(NumberFormatException e) {
            System.out.println("El número debe ser un entero.");
        }
        catch (Exception e) {
            System.out.println("Ha ocurrido un error inesperado.");
        }
        return numeros;
    }
}


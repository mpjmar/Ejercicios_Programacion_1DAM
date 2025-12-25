public class App {
    public static void main(String[] args) throws Exception {

        String palabras[] = pidePalabras(8);
        System.out.println("Array original: ");
        muestraArray(palabras);
        palabras = ordenaArray(palabras);
        System.out.println("Array resultado: ");
        muestraArray(palabras);
    }

    public static String[] ordenaArray(String[] array) {
        String colores[] = {"verde", "rojo", "azul", "gris", "naranja", 
            "rosa", "negro", "blanco", "morado"};
        String siColor[] = new String[array.length];
        String noColor[] = new String[array.length];
        int posColor = 0;
        int posNoColor = 0;
        for (int i = 0; i < array.length; i++) {
            boolean encontrado = false;
            for (int j = 0; j < colores.length && !encontrado; j++) {
                if (array[i].equals(colores[j])) {
                    siColor[posColor++] = array[i];
                    encontrado = true;
                }
            }
            if (!encontrado)
                noColor[posNoColor++] = array[i];
        }
        int i = 0;
        while (posColor < siColor.length)
            siColor[posColor++] = noColor[i++];
        return siColor;
    }

        public static void muestraArray(String array[]) {
        repeatBorde("┌───────", "┬───────", "┐", array.length - 1);
        repeatIndice("│%4d   ", "│", array);
        repeatBorde("├───────", "┼───────", "┤", array.length - 1);
        repeatContenido("│%-7s", "│", array);
        repeatBorde("└───────", "┴───────", "┘", array.length - 1);
    }

    public static void repeatBorde(String izq, String centro, String dcha, int len) {
        System.out.print(izq);
        for (int i = 0; i < len; i++)
            System.out.print(centro);
        System.out.println(dcha);
    }

    public static void repeatIndice(String centro, String dcha, String array[]) {
        for (int i = 0; i < array.length; i++)
            System.out.printf(centro, i);
        System.out.println(dcha);
    }

    public static void repeatContenido(String centro, String dcha, String array[]) {
        for (int i = 0; i < array.length; i++)
            System.out.printf(centro, array[i]);
        System.out.println(dcha);
    }

    public static String[] pidePalabras(int cantidad) {
        System.out.printf("Introduzca %d palabras: %n", cantidad);
        String palabras[] = new String[cantidad];
        for (int i = 0; i < palabras.length; i++)
            palabras[i] = System.console().readLine();
        System.out.println();
        return palabras; 
    }
}

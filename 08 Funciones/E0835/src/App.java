public class App {
    public static void main(String[] args) throws Exception {

        System.out.printf("El %d es el %s en el sistema de palotes.%n", 470213, convierteEnPalotes(470213));
        System.out.printf("El %d es el %s en el sistema de palotes.%n", 0, convierteEnPalotes(0));
        System.out.printf("El %d es el %s en el sistema de palotes.%n", 11, convierteEnPalotes(11));
        System.out.printf("El %d es el %s en el sistema de palotes.%n", 24, convierteEnPalotes(24));
        System.out.printf("El %d es el %s en el sistema de palotes.%n", 867024, convierteEnPalotes(867024));
    }

    public static String convierteEnPalotes(int n) {
        String palotes = "";
        int digitos = calculaDigitos(n);
        int num = voltea(n);
        for (int i = 0; i < digitos; i++) {
            palotes = almacenaPalotes(palotes, num % 10);
            num /= 10;
            if (num > 0) palotes += "-";
        }
        return palotes;
    }

    private static String almacenaPalotes(String str, int n) {
        for (int i = 0; i < n; i++)
            str += "|";
        return str;
    }

    private static int voltea(int num) {
        int volteado = 0;
        while (num > 0) {
            volteado = volteado * 10 + num % 10;
            num/= 10;
        }
        return volteado;
    }

    private static int calculaDigitos(int n) {
        int digitos = 0;
        while (n > 0) {
            n /= 10;
            digitos++;
        }
        return digitos;
    }
}

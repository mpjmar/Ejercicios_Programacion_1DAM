public class App {
    public static void main(String[] args) throws Exception {

        System.out.printf("El %d es el %s en Morse.%n", 213, convierteEnMorse(213));
        System.out.printf("El %d es el %s en Morse.%n", 0, convierteEnMorse(0));
        System.out.printf("El %d es el %s en Morse.%n", 11, convierteEnMorse(11));
        System.out.printf("El %d es el %s en Morse.%n", 24, convierteEnMorse(24));
        System.out.printf("El %d es el %s en Morse.%n", 86, convierteEnMorse(86));
        System.out.printf("El %d es el %s en Morse.%n", 100, convierteEnMorse(100));
    }

    public static String convierteEnMorse(int n) {
        String morse = "";
        String[] equivalencia = {"_ _ _ _ _", ". _ _ _ _", ". . _ _ _", ". . . _ _",  ". . . . _", ". . . . .",
            "_ . . . .", "_ _ . . .", "_ _ _ . .", "_ _ _ _ ."};
        if (n < 10)
            return equivalencia[n];
        int invertido = invertido(n);
        while (invertido > 1) {
            morse += equivalencia[invertido % 10];
            invertido /= 10;
        }
        return morse;
    }

    private static int invertido(int n) {
        int invertido = 1;
        while (n > 0) {
            invertido = invertido * 10 + n % 10;
            n /= 10;
        }
        System.out.println("Invertido: " + invertido);
        return invertido;
    }
}

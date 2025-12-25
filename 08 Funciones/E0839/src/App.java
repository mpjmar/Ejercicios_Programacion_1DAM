public class App {
    public static void main(String[] args) throws Exception {
        System.out.println(convierteEnPalabras(470213));
    }

    public static String convierteEnPalabras(int n) {
        String palabras = "";
        int invertido = invierteNum(n);
        while (invertido > 1) {
            palabras += convierteNumero(invertido % 10);
            invertido /= 10;
            palabras += invertido > 1 ? ", " : "";
        }
        return palabras;
    }

    private static String convierteNumero(int n) {
        String[] palabras = {"cero", "uno", "dos", "tres", 
            "cuatro", "cinco", "seis", "siete", "ocho", "nueve"};
        return palabras[n];
    }

    private static int invierteNum(int n) {
        int invertido = 1;
        while (n > 0) {
            invertido = invertido * 10 + n % 10;
            n /= 10;
        }
        return invertido;
    }
}

public class App {

        public static final String RESET = "\u001B[0m";
        public static final String RED = "\u001B[31m";
        public static final String GREEN = "\u001B[32m";
        public static final String BLUE = "\u001B[34m";

    public static void main(String[] args) throws Exception {

        int temperaturas[] = pideTemperaturas();
        pintaGrafico(temperaturas);

    }

    public static void pintaGrafico(int temperaturas[]) {

        for (int i = 0; i < temperaturas.length; i++) {
            System.out.printf("%10s |", muestraMes(i));
            for (int j = 0; j < temperaturas[i]; j++) 
                System.out.printf("%s", (temperaturas[i] < 10 ? BLUE : temperaturas[i] < 20 ? GREEN : RED) + "▄");
            System.out.println(RESET + " " + temperaturas[i] + "ºC");
        }
    }

    public static String muestraMes(int m) {
        String mes = switch (m) {
            case 0 -> "enero";
            case 1 -> "febrero";
            case 2 -> "marzo";
            case 3 -> "abril";
            case 4 -> "mayo";
            case 5 -> "junio";
            case 6 -> "julio";
            case 7 -> "agosto";
            case 8 -> "septiembre";
            case 9 -> "octubre";
            case 10 -> "noviembre";
            case 11 -> "diciembre";
            default -> "";
        };
        return mes;
    }

    public static int[] pideTemperaturas() {
        
        int temperaturas[] = new int[12];
        for (int i = 0; i < 12; i++) {
            try {
                System.out.printf("Introduzca la temperatura media de %s: ", muestraMes(i));
                temperaturas[i] = Integer.parseInt(System.console().readLine());
            }
            catch (NumberFormatException e) {
                System.out.println("Los valores deben ser enteros.");
            }
            catch (Exception e) {
                System.out.println("Ha ocurrido un error inesperado.");
            }
        }
        System.out.println();
        return temperaturas;
    }
}

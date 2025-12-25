public class App {
    public static void main(String[] args) throws Exception {

        int numeros[] = pideNumeros(8);
        for (int i = 0; i < numeros.length; i++)
            System.out.println(catalogaNum(numeros[i]));
        System.out.println();
    }

    public static String catalogaNum(int num) {
        String catalogado = String.format("%d", num);
        catalogado += esPar(num) ? " par" : " impar";
        return catalogado;
    }

    public static boolean esPar(int num) {
        return (num % 2 == 0);
    }

    public static int[] pideNumeros(int cantidad) {
        int numeros[] = new int[cantidad];
        System.out.println("Introduzca 8 números enteros, pulse INTRO después de cada número:");
        for (int i = 0; i < numeros.length; i++) {
            try {
                numeros[i] = Integer.parseInt(System.console().readLine());
            }
            catch (NumberFormatException e) {
                System.out.println("El número debe ser un entero.");
            }
            catch (Exception e) {
                System.out.println("Ha ocurrido un error inesperado.");
            }
        }
        System.out.println();
        return numeros;
    }
}

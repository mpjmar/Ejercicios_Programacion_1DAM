public class App {

    public static int[] rotaElementos(int numeros[]) {
        int last = numeros[numeros.length - 1];
        for (int i = numeros.length - 1; i > 1; i--) {
            numeros[i] = numeros[i - 1];
        }
        numeros[0] = last;
        return numeros;
    }

    public static void imprimeArray(int array[]) {
        for (int i = 0; i < array.length; i++)
            System.out.printf("|%3d ", i);
        System.out.println("|");

        for (int i = 0; i < array.length * 5 + 1; i++)
            System.out.print("-");
        System.out.println();

        for (int i = 0; i < array.length; i++)
            System.out.printf("|%3d ", array[i]);
        System.out.println("|");
        System.out.println();
    }

    public static void main(String[] args) throws Exception {

        int numeros[] = new int[12];

        System.out.println("Vaya introduciendo números enteros y pulsando INTRO: ");
        for (int i = 0; i < numeros.length; i++) {
            boolean valido = false;
            while (!valido) {
                try {
                    numeros[i] = Integer.parseInt(System.console().readLine());
                    valido = true;
                } catch (NumberFormatException e) {
                    System.out.println("Los número deben ser enteros.");
                } catch (Exception e) {
                    System.out.println("Ha ocurrido un error inesperado.");
                }
            }
        }
        System.out.println();

        System.out.println("Array original:");
        imprimeArray(numeros);

        numeros = rotaElementos(numeros);
        System.out.println("Array original:");
        imprimeArray(numeros);
    }
}

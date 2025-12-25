public class App {
    public static void main(String[] args) throws Exception {
        System.out.print("Introduzca la altura de la figura: ");
        int altura = Integer.parseInt(System.console().readLine());
        pintaFigura(altura);
    }

    public static void pintaFigura(int altura) {
        superior(altura);
        for (int i = 0; i < altura; i++) 
            siguientes(altura - i - 1);
    }

    private static void superior(int altura) {
        for (int i = 0; i < altura; i++)
            System.out.print("*");
        System.out.println();
    }

    private static void siguientes(int longitud) {
        for (int i = 0; i < longitud; i++)
            System.out.print(i == 0 | i == longitud - 1 ? "*" : " ");
        System.out.println();
    }
}

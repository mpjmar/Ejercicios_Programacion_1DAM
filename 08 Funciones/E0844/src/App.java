public class App {
    public static void main(String[] args) throws Exception {
        System.out.print("Introduzca la altura de la figura: ");
        int altura = Integer.parseInt(System.console().readLine());
        pintaFigura(altura);
    }

    public static void pintaFigura(int altura) {
        pintaPrimera(altura);
        for (int i = 0; i < altura - 1; i++)
            pintaSiguientes(altura, i + 1);
    }

    private static void pintaPrimera(int altura) {
        for (int i = 0; i < altura; i++)
            System.out.print("*");
        System.out.println();
    }

    private static void pintaSiguientes(int altura, int fila) {
        for (int i = 0; i < altura; i++)
            System.out.print(i == fila || i == altura - 1 ? "*" : " ");
        System.out.println();
    }
}

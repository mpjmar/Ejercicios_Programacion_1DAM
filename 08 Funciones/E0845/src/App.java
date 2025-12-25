public class App {
    public static void main(String[] args) throws Exception {
        System.out.print("Introduzca la altura de la figura: ");
        int altura = Integer.parseInt(System.console().readLine());
        pintaFigura(altura);
    }

    public static void pintaFigura(int altura) {
        for (int i = 0; i < altura - 1; i++)
            pintaLinea(altura * 2 - 1, i);
        pintaLinea(altura * 2 - 1, altura);
        System.out.println();
    }

    private static void pintaLinea(int ancho, int fila) {
        for (int i = 0; i < ancho; i++)
            System.out.print(i <= fila || i >= ancho - fila - 1 ? "*" : " ");
        System.out.println();
    }
}

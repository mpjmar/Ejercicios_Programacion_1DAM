public class App {
    public static void main(String[] args) throws Exception {
        System.out.print("Introduzca la altura de la figura: ");
        int altura = Integer.parseInt(System.console().readLine());
        pintaTriangulo(altura);
    }

    public static void pintaTriangulo(int altura) {
        for (int i = 0; i < altura; i++)
            pintaFila(altura, i);
    }

    private static void pintaFila(int altura, int fila) {
        for (int i = 0; i < altura; i++) 
            System.out.print(i < fila ? " " : "*");
        System.out.println();
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        System.out.print("Introduzca la altura de la figura: ");
        int altura = Integer.parseInt(System.console().readLine());
        linea(altura);
    }

    public static void linea(int altura) {
        for (int i = 0; i < altura; i++) {
            for (int j = 0; j < altura - i; j++)
                System.out.print("*");
            System.out.println();
        }
    }
}

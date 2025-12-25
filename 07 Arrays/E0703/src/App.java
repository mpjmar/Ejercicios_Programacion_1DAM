public class App {
    public static void main(String[] args) throws Exception {

        int numeros[] = new int[10];

        System.out.println("Por favor, introduzca 10 números enteros.");
        System.out.println("Pulse la tecla INTRO después de introducir cada número.");
        for (int i = 0; i < 10; i++) {
            try {
                numeros[i] = Integer.parseInt(System.console().readLine());
            } catch (NumberFormatException e) {
                System.out.println("Los números deben ser enteros.");
            } catch (Exception e) {
                System.out.println("Ha ocurrido un error inesperado.");
            }
        }
        System.out.println("Los número en orden inverso son: ");
        for (int i = 9; i >= 0; i--)
            System.out.println(numeros[i]);
    }
}

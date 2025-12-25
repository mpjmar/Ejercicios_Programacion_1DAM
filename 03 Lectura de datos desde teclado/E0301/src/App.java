public class App {
    public static void main(String[] args) throws Exception {

        System.out.println("Este programa multiplica dos números enteros.");
        System.out.print("Por favor, introduzca el primer número: ");
		int num1 = Integer.parseInt(System.console().readLine());
        System.out.print("Introduzca el segundo número: ");
		int num2 = Integer.parseInt(System.console().readLine());
        System.out.println(num1 + " * " + num2 + " = " + num1 * num2);
    }
}

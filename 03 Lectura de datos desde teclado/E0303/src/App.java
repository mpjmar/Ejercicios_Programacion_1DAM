public class App {
    public static void main(String[] args) throws Exception {

        System.out.print("Introduzca la cantidad de pesetas que quiere convertir: ");
		int ptas = Integer.parseInt(System.console().readLine());

		double euros = ptas / 166.386;

		System.out.printf("%d pesetas son %.2f%n",ptas, euros);
    }
}

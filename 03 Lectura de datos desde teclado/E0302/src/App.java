public class App {
    public static void main(String[] args) throws Exception {
		double ptas = 166.30;
        System.out.print("Por favor, introduzca la cantidad de euros que quere convertir: ");
		double euros = Double.parseDouble(System.console().readLine());
		System.out.println(euros + (" euros son " + (int)(euros * ptas) + " pesetas"));
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        
		System.out.println("Área de un rectángulo");
		System.out.println("---------------------");
		System.out.print("Por favor, introduzca la longitud de la base (cm): ");
		double base = Double.parseDouble(System.console().readLine());
		System.out.print("Introduzca la altura (cm): ");
		double altura = Double.parseDouble(System.console().readLine());
		System.out.printf("El área del rectángulo es %.2f cm2%n", (base * altura));
		System.out.println("El área del rectángulo es " + (base * altura) + " cm2");
    }
}

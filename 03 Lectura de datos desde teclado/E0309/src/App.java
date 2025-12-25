public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Volumen de un cono");
        System.out.println("------------------");

		try {
			System.out.print("Por favor, introduzca la altura (cm): ");
			double altura = Double.parseDouble(System.console().readLine());
			System.out.print("Introduzca el radio de la base (cm): ");
			double radio = Double.parseDouble(System.console().readLine());
			double volumen = (1.0/3.0) * Math.PI * radio * radio * altura;
			System.out.println("El volumen del cono es de " + volumen + " cm3");
		}
        catch (NumberFormatException e) {
			System.out.println("Invalid input");
		}
		catch (Exception e) {
			System.out.println("Unexpected error");
		}
    }
}

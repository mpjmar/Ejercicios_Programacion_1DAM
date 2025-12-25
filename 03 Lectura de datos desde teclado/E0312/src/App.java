public class App {
    public static void main(String[] args) throws Exception {
        
		try {
			System.out.print("Introduzca la nota del primer examen: ");
			double nota1 = Double.parseDouble(System.console().readLine());
			System.out.print("¿Qué nota quiere sacar en el trimestre?: ");
			double notaFinal = Double.parseDouble(System.console().readLine());
			double nota2 = ((notaFinal * 100) - (nota1 * 40)) / 60;
			System.out.printf("Para tener un %.1f en el trimestre, necesita sacar un %.1f en el segundo examen.%n", notaFinal, nota2);
			System.out.print("Para tener un " + notaFinal + " en el trimestre, ");
			System.out.println("necesita sacar un " + nota2 + " en el segundo examen.");
		}
		catch (NumberFormatException e) {
			System.out.println("Invalid input");
		}
		catch (Exception e) {
			System.out.println("Unexpected error");
		}
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        
		try {
			System.out.print("Nota del primer control: ");
			int nota1 = Integer.parseInt(System.console().readLine());

			System.err.print("Nota del segundo control: ");
			int nota2 = Integer.parseInt(System.console().readLine());

			float media = ((float)nota1 + nota2) / 2;
			if (media >= 5)
				System.out.println("Tu nota de Programación es " + media);
			else {
				System.out.print("¿Cuál ha sido el resultado de la recuperación? (apto / no apto): ");
				String resul = System.console().readLine();
				System.out.print("Tu nota de Programación es ");
				if (resul.toLowerCase().equals("apto"))
					System.out.println("5");
				else
					System.out.println(media);
			}
		} catch (NumberFormatException e) {
			System.out.println("Invalid input");
		} catch (Exception e) {
			System.out.println("Unexpected error");
		}
    }
}

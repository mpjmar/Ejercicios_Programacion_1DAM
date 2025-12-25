public class App {
    public static void main(String[] args) throws Exception {
        
		try {
			System.out.println("Este programa calcula la media de tres notas.");
			System.out.print("Por favor, introduzca la primera nota: ");
			int nota1 = Integer.parseInt(System.console().readLine());
			System.out.print("Ahora introduzca la segunda nota: ");
			int nota2 = Integer.parseInt(System.console().readLine());
			System.out.print("Por último, introduzca la tercera nota: ");
			int nota3 = Integer.parseInt(System.console().readLine());
			
			double media = (double)(nota1 + nota2 + nota3) / 3;
			System.out.printf("La media es %.2f%n", media);
	
			System.out.println(
				switch((int)Math.round(media)) {
					case 0, 1, 2, 3, 4 -> "Insuficiente";
					case 5 -> "Suficiente";
					case 6 -> "Suficiente";
					case 7, 8 -> "Notable";
					case 9, 10 -> "Sobresaliente";
					default -> "Error: nota no válida";
				}
			);
		} catch (NumberFormatException e) {
			System.out.println("Invalid input");
		} catch (Exception e) {
			System.out.println("Unexpected error");
		}
    }
}

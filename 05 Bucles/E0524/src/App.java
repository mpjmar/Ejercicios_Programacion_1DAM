public class App {
    public static void main(String[] args) throws Exception {
        
		int altura = 0;

		System.out.println("Este programa pinta una pirámide hecha a base de números.");
		try {
			altura = Integer.parseInt(System.console().readLine("Por favor, introduzca la altura de la pirámide: "));
		}
		catch (NumberFormatException e) {
			System.out.println("El número debe ser un entero.");
		}
		catch (Exception e) {
			System.out.println("Ha ocurrido un error inesperado.");
		}
		for (int i = 0; i < altura; i++) {
			for (int j = 0; j < (altura - i - 1); j++)
				System.out.print(" ");
			for (int j = 0; j < i + 1; j++)
				System.out.print(j + 1);
			for (int j = i; j > 0; j--)
				System.out.print(j);
			System.out.println();
		}
	}
}

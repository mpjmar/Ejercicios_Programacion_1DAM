public class App {
    public static void main(String[] args) throws Exception {

		boolean correcto = false;
		int altura = 0;

		do {
			try {
				System.out.print("Introduzca la altura de la figura: ");
				altura = Integer.parseInt(System.console().readLine());
				correcto = altura > 0;
				if (!correcto) System.out.println("La altura debe ser mayor a 0.");
			}
			catch (NumberFormatException e) {
				System.out.println("El número debe ser un entero.");
			}
			catch (Exception e) {
				System.out.println("Ha ocurrido un error inesperado.");
			}
		} while (!correcto);

		for (int i = 0; i < altura; i++) {
			for (int j = 0; j < altura; j++)
				System.out.print(j < i ? " " : "*");
			System.out.println();
		}
	}
}
